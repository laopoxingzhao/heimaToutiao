package com.heima.model.user.dto;

import lombok.Data;

/**
 * @ClassName LoginDto
 * @Description TODO
 * @Author 胡
 * @Date 2023/11/13 18:16
 * @Version 1.0
 */
@Data
public class LoginDto {
    /**
     * 手机号
     */

    private String phone;
    /**
     * 密码
     */
    private String password;
}
