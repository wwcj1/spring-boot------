package com.example.springbootteach.controller.student;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TAdmin;
import com.example.springbootteach.entity.TStudent;
import com.example.springbootteach.service.ITStudentService;
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
@RequestMapping("/springbootteach/t-student")
@Api(value = "学生-登录注册接口", tags = {"学生-登录注册接口"})
public class LoginController extends BaseController {
    @Autowired
    ITStudentService itStudentService;
    @PostMapping("/login")
    @ApiOperation("学生登录")
    public JsonResult<Void> login(String name, String password, HttpSession session) {
        itStudentService.login(name,password,session);
        JsonResult jsonResult = new JsonResult<>(OK);
        return jsonResult;
    }
    @GetMapping("/register")
    @ApiOperation("学生注册")
    public JsonResult<Void> register(TStudent tStudent , HttpSession session) {

        itStudentService.register(tStudent);//增加管理员
        return new JsonResult<>(OK);
    }
    }

