package stu_eva_backend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import stu_eva_backend.model.Node;
import stu_eva_backend.model.Role;
import stu_eva_backend.model.StudentInfo;
import stu_eva_backend.model.Teacher;
import stu_eva_backend.repository.StudentInfoRepository;
import stu_eva_backend.repository.TeacherRepository;
import stu_eva_backend.service.RedisService;
import stu_eva_backend.util.jwtTokenUtil;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthController.class)
class
AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentInfoRepository mockStudentInfoRepository;
    @MockBean
    private TeacherRepository mockTeacherRepository;
    @MockBean
    private jwtTokenUtil mockJwtTokenUtil;
    @MockBean
    private RedisService mockRedisService;

    @Test
    void testLogin() throws Exception {
        // Setup
        // Configure StudentInfoRepository.findByStudentNumber(...).
        final StudentInfo studentInfo = new StudentInfo();
        final Role role = new Role();
        role.setId(0);
        role.setName("name");
        final Node node = new Node();
        node.setId(0);
        role.setRoutes(Arrays.asList(node));
        studentInfo.setRole(role);
        when(mockStudentInfoRepository.findByStudentNumber("number")).thenReturn(studentInfo);

        when(mockJwtTokenUtil.generateAccessToken("number")).thenReturn("accessToken");
        when(mockJwtTokenUtil.generateRefreshToken("number")).thenReturn("refreshToken");
        when(mockRedisService.getValue("number")).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/auth/login")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testLogin_StudentInfoRepositoryReturnsNull() throws Exception {
        // Setup
        when(mockStudentInfoRepository.findByStudentNumber("number")).thenReturn(null);

        // Configure TeacherRepository.findByJobNumber(...).
        final Teacher teacher = new Teacher();
        final Role role = new Role();
        role.setId(0);
        role.setName("name");
        final Node node = new Node();
        node.setId(0);
        role.setRoutes(Arrays.asList(node));
        teacher.setRole(role);
        when(mockTeacherRepository.findByJobNumber("number")).thenReturn(teacher);

        when(mockJwtTokenUtil.generateAccessToken("number")).thenReturn("accessToken");
        when(mockJwtTokenUtil.generateRefreshToken("number")).thenReturn("refreshToken");
        when(mockRedisService.getValue("number")).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/auth/login")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testLogin_TeacherRepositoryReturnsNull() throws Exception {
        // Setup
        when(mockStudentInfoRepository.findByStudentNumber("number")).thenReturn(null);
        when(mockTeacherRepository.findByJobNumber("number")).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/auth/login")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testLogin_RedisServiceGetValueReturnsNull() throws Exception {
        // Setup
        // Configure StudentInfoRepository.findByStudentNumber(...).
        final StudentInfo studentInfo = new StudentInfo();
        final Role role = new Role();
        role.setId(0);
        role.setName("name");
        final Node node = new Node();
        node.setId(0);
        role.setRoutes(Arrays.asList(node));
        studentInfo.setRole(role);
        when(mockStudentInfoRepository.findByStudentNumber("number")).thenReturn(studentInfo);

        when(mockJwtTokenUtil.generateAccessToken("number")).thenReturn("accessToken");
        when(mockJwtTokenUtil.generateRefreshToken("number")).thenReturn("refreshToken");
        when(mockRedisService.getValue("number")).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/auth/login")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockRedisService).setValueWithExpiration("number", "accessToken", 180L);
    }
}
