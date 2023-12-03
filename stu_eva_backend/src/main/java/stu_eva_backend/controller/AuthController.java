package stu_eva_backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.StudentInfo;
import stu_eva_backend.model.Teacher;
import stu_eva_backend.repository.StudentInfoRepository;
import stu_eva_backend.repository.TeacherRepository;
import stu_eva_backend.service.RedisService;
import stu_eva_backend.util.CommonResult;
import stu_eva_backend.util.LoginRequest;
import stu_eva_backend.util.TokenResponse;
import stu_eva_backend.util.jwtTokenUtil;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private StudentInfoRepository studentInfoRepository;  // 使用StudentInfoRepository

    @Autowired
    private TeacherRepository teacherRepository;  // 使用TeacherRepository

    @Autowired
    private jwtTokenUtil jwtTokenUtil;

    @Autowired
    RedisService redisService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @PostMapping("/login")
    public CommonResult<?> login(HttpServletRequest request,@RequestBody LoginRequest loginRequest) throws JsonProcessingException {
        System.out.println(loginRequest);
        String captchaText= loginRequest.getCaptchaText();
        String storedCaptcha = (String) request.getSession().getAttribute("captcha");
        request.getSession().removeAttribute("captcha"); // 删除会话中的验证码

        if (captchaText.equalsIgnoreCase(storedCaptcha)) {
            // 验证码正确，执行登录逻辑
            // ...
            String Number = loginRequest.getNumber();  // 获取学生ID
            // 验证学生ID是否存在于数据库中
            if (studentInfoRepository.findByStudentNumber(Number) == null) {
                if(teacherRepository.findByJobNumber(Number) == null){
                    System.out.println("登录失败");
                    return CommonResult.error(50007,"登录失败，账号不存在");
                }
            }
            // 生成访问令牌和刷新令牌
            String accessToken = jwtTokenUtil.generateAccessToken(Number);
            String refreshToken = jwtTokenUtil.generateRefreshToken(Number);
            TokenResponse token_resp = new TokenResponse(accessToken,refreshToken);
            Object user=redisService.getValue(loginRequest.getNumber());
            if(user!=null){
                System.out.println("该用户已经登录");
                return CommonResult.error(50007,"该用户已经登录");
            }
            redisService.setValueWithExpiration(token_resp.getAccessToken(),loginRequest.getNumber(),1800);
            System.out.println(redisService.getValue(token_resp.getAccessToken()));
            CommonResult<TokenResponse> result = CommonResult.success(token_resp);
            System.out.println("成功");
            return result;
        } else {
            // 验证码错误，显示错误消息
            // ...
            System.out.println("验证码");
            return CommonResult.error(50007,"登录失败，验证码错误");
        }
    }

    @RestController
    @RequestMapping("/refreshToken")
    public class TokenController {
        @PostMapping
        public CommonResult<?> getToken(@RequestParam("refreshToken") String refreshToken) {
            try {
                // 处理请求并验证JWT令牌的代码
                String number = jwtTokenUtil.getUsernameFromRefreshToken(refreshToken);

                if (number != null) {
                    String accessToken = jwtTokenUtil.generateAccessToken(number);
                    String refreshTokenNew = jwtTokenUtil.generateRefreshToken(number);
                    TokenResponse tokenResponse = new TokenResponse(accessToken, refreshTokenNew);
                    redisService.setValueWithExpiration(tokenResponse.getAccessToken(),number, 1800);
                    System.out.println(tokenResponse);
                    CommonResult<TokenResponse> result = CommonResult.success(tokenResponse);
                    System.out.println("成功");
                    return result;

                }

                return CommonResult.error(50007, "登录已过期");

            } catch (ExpiredJwtException e) {
                String errorMessage = "JWT令牌已过期，请重新登录或获取新的令牌";
                // 返回错误信息给客户端
                return CommonResult.error(50007, errorMessage);
            }


        }




    }

    //@CrossOrigin
    @RestController
    @RequestMapping("/user")
    public class UserController {

        @Autowired
        private StudentInfoRepository studentInfoRepository;

        @Autowired
        private TeacherRepository teacherRepository;

        @Autowired
        private jwtTokenUtil jwtTokenUtil;


        @GetMapping("/profile/get")
        public CommonResult<?> getUserProfile(@RequestHeader("Authorization") String authHeader) {

            // 解析Authorization请求头中的JWT令牌 Bearer access_token
            String token = authHeader.substring(7);
            // 在解析 JWT 之前验证它是否有效
            if (!jwtTokenUtil.validateToken(token)) {
                // 如果 JWT 无效，返回错误响应
                return CommonResult.error(50007, "无效或过期的 JWT");
            }
            String number= redisTemplate.opsForValue().get(token);

            System.out.println("学号"+number);
           // String username = jwtTokenUtil.getUsernameFromToken(token);
            if(studentInfoRepository.findByStudentNumber(number)==null){
                Teacher foundUser = teacherRepository.findByJobNumber(number);
                CommonResult<Teacher> result = CommonResult.success(foundUser);
                System.out.println(token);
                return result;
            }
            StudentInfo foundUser = studentInfoRepository.findByStudentNumber(number);
            System.out.println(foundUser);
            CommonResult<StudentInfo> result = CommonResult.success(foundUser);
            System.out.println(token);
            return result;
        }
    }
}
