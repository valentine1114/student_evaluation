package stu_eva_backend.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
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

import java.awt.image.BufferedImage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CaptchaController.class)
class CaptchaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DefaultKaptcha mockDefaultKaptcha;

    @Test
    void testShowCaptcha() throws Exception {
        // Setup
        when(mockDefaultKaptcha.createText()).thenReturn("text");
        when(mockDefaultKaptcha.createImage("text")).thenReturn(new BufferedImage(0, 0, 0));

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/captcha")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
