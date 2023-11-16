package com.heima.user.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dto.LoginDto;
import com.heima.model.user.pojo.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import com.heima.utils.common.AppJwtUtil;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName ApuserServiceImpl
 * @Description TODO
 * @Author 胡
 * @Date 2023/11/13 18:23
 * @Version 1.0
 */
@Service
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper,ApUser>  implements ApUserService {

    @Override
    public ResponseResult login(LoginDto dto) {
        if (StringUtils.isNotBlank(dto.getPhone()) || StringUtils.isNotBlank(dto.getPassword())){
            // 如果手机号或密码非空
            ApUser user = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, dto.getPhone()));
            // 通过手机号查询用户
            if(user == null){
                // 如果用户不存在
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户信息不存在");
                // 返回错误结果，提示用户信息不存在
            }

            String salt = user.getSalt();
            // 获取用户的盐值
            String password = dto.getPassword();
            // 获取用户输入的密码
            String pwsd = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            // 将用户输入的密码与盐值拼接后进行MD5加密
            if (!pwsd.equals(user.getPassword())){
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
                // 如果加密后的密码与数据库中的密码不一致，则返回登录密码错误的错误结果
            }

            String token = AppJwtUtil.getToken(user.getId().longValue());
            // 通过用户id获取token
            Map<String, Object> map = new HashMap<>();
            // 创建一个map用于存储数据
            map.put("token", token);
            // 将token放入map中
            user.setPassword("");
            // 清空用户密码
            user.setSalt("");
            // 清空用户盐值
            map.put("user", user);
            // 将用户放入map中
            return ResponseResult.okResult(map);
            // 返回ok结果及map对象

        }
        else {
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            //游客登陆
            return ResponseResult.okResult(map);
            // 返回ok结果及map对象
        }



    }

}
