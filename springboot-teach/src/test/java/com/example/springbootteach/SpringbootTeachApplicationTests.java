package com.example.springbootteach;

import com.example.springbootteach.entity.TAdmin;
import com.example.springbootteach.entity.TAppointment;
import com.example.springbootteach.mapper.TAdminMapper;
import com.example.springbootteach.mapper.TAppointmentMapper;
import com.example.springbootteach.service.ITAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootTeachApplicationTests {
@Autowired
    TAdminMapper tAdminMapper;
@Autowired
    ITAdminService itAdminService;
@Autowired
    TAppointmentMapper tAppointmentMapper;
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
@Test
    void appoint(){
    List<TAppointment> tAppointments = tAppointmentMapper.selectBySId(7L);
    for (TAppointment tAppointment : tAppointments) {
        System.out.println(tAppointment);
    }
}
}
