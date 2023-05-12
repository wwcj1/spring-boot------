package com.example.springbootteach.admin;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.entity.TAdmin;
import com.example.springbootteach.mapper.TAdminMapper;
import com.example.springbootteach.service.ITAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest {
    @Autowired
    TAdminMapper tAdminMapper;
    @Autowired
    ITAdminService itAdminService;
    @Test
    void contextLoads() {

        TAdmin byName = tAdminMapper.getByName("admin");
        String password = byName.getPassword();
        System.out.println("password:"+password);
        System.out.println("id"+byName.getId());
    }
    @Test
    void cc(){
        TAdmin tAdmin = new TAdmin();
        tAdmin.setName("admin1");
        tAdmin.setPassword("123123");
        System.out.println(itAdminService.save(tAdmin));
    }
}
