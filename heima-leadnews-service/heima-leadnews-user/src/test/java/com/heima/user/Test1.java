package com.heima.user;

import com.heima.model.user.pojo.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 胡
 * @Date 2023/11/14 16:04
 * @Version 1.0
 */

@SpringBootTest
public class Test1 {

    @Resource
    ApUserService apUserService;
    @Test
    public  void main() {
        if (apUserService!=null)
//        ApUser id = apUserService.getById(1);
        System.out.println(1);
//        apUserService.login()

    }

}
