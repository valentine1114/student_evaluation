package stu_eva_backend.util;

import lombok.Data;

@Data
public class LoginRequest {
    private String number;
    private String captchaText;


    public String getNumber() {
        System.out.println(number);
        return number;
    }

    public String getCaptchaText() {
        return captchaText;
    }
}
