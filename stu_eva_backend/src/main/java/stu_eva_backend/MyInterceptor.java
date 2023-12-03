package stu_eva_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import stu_eva_backend.model.Role;
import stu_eva_backend.model.URIs;
import stu_eva_backend.model.User;
import stu_eva_backend.repository.StudentInfoRepository;
import stu_eva_backend.repository.TeacherRepository;
import stu_eva_backend.service.BackaccessServices;
import stu_eva_backend.service.UserServices;
import stu_eva_backend.util.jwtTokenUtil;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private BackaccessServices backaccessServices;

    @Autowired
    private UserServices userServices;

    @Autowired
    private jwtTokenUtil jwtTokenUtil;

    private static final Map<String, Integer> INTERFACE_PERMISSION_MAP = new HashMap<>();

    @PostConstruct
    public void init(){
        List<URIs> backaccesses = backaccessServices.getAllBackaccesses();
        for(URIs backaccess:backaccesses){
            INTERFACE_PERMISSION_MAP.put(backaccess.getNode_URI(),backaccess.getId());
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在请求处理之前执行的操作
        System.out.println("=====preHandle=====");
        // for(String key:INTERFACE_PERMISSION_MAP.keySet()){
        //     System.out.println(key+" "+INTERFACE_PERMISSION_MAP.get(key));
        // }
        System.out.println("request.getRequestURI(): "+request.getRequestURI());
        String token = request.getHeader("Authorization").substring(7);
        if (!jwtTokenUtil.validateToken(token)) {
            // 如果 JWT 无效，返回错误响应
            System.out.println("JWT 无效");
            return false;
        }
        String username = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println("username: "+username);
        // if(studentInfoRepository.findByStudentNumber(username)==null){
        //     Teacher foundUser = teacherRepository.findByJobNumber(username);
        //     // CommonResult<Teacher> result = CommonResult.success(foundUser);
        // }
        // StudentInfo foundUser = studentInfoRepository.findByStudentNumber(username);
        User foundUser = userServices.getUserByUserId(username);
        if(foundUser==null){
            System.out.println("用户不存在");
            return false;
        }
        Long userId=foundUser.getId();
        Integer requiredPermission = INTERFACE_PERMISSION_MAP.get(request.getRequestURI());
        System.out.println("requiredPermission: "+requiredPermission);
        if (requiredPermission == null) {
            // 没有在映射中找到接口，可以自由访问
            System.out.println("公开链接可以自由访问");
            return true;
        }
        Role role = foundUser.getRole();
        // List<URIs> userNodes = backaccessServices.getBackaccessesByUserId(Long.toString(userId));
        List<URIs> userNodes = backaccessServices.findURIsByRoleId(role.getId());
        for(URIs node:userNodes){
            System.out.println(node.getNode_URI());
        }
        boolean hasPermission = userNodes.stream().anyMatch(node -> node.getId().equals(requiredPermission));
        if(!hasPermission) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append(userId);
            errorMessage.append(role.getName());
            errorMessage.append("You don't have permission to access this interface. ");
            errorMessage.append("Your permissions are: ");
            for (URIs node : userNodes) {
                errorMessage.append(node.getNode_URI()).append(", ");
            }
            // 移除最后一个逗号和空格
            errorMessage.setLength(errorMessage.length() - 2);

            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(errorMessage.toString());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 在请求处理之后，视图渲染之前执行的操作
        System.out.println("=====postHandle=====");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // 在请求完成之后执行的操作，即视图渲染完成后
        System.out.println("=====afterCompletion=====");
    }
}
