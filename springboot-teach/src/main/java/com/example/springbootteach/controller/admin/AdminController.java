package com.example.springbootteach.controller.admin;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TAdmin;
import com.example.springbootteach.service.ITAdminService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/springbootteach/t-admin")
@Api(value = "管理员接口", tags = {"管理员接口"})
public class AdminController extends BaseController {
    @Autowired
    ITAdminService itAdminService;
    @PostMapping("/login")
    @ApiOperation("管理员登录")
    public JsonResult login(String name, String password, HttpSession session) {
        JsonResult jsonResult = itAdminService.login(name, password, session);
        return jsonResult;
    }

    @GetMapping("/register")
    @ApiOperation("管理员注册增加")
    public JsonResult<Void> register(TAdmin tAdmin , HttpSession session) {
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        itAdminService.save(tAdmin);//增加管理员
        return new JsonResult<>(OK);
    }
}
