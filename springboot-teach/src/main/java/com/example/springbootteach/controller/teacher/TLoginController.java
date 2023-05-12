package com.example.springbootteach.controller.teacher;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TTeacher;
import com.example.springbootteach.service.ITTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/springbootteach/t-teacher")
@Api(value = "教师-登录注册接口", tags = {"教师-登录注册接口"})
public class TLoginController extends BaseController {
    @Autowired
    ITTeacherService itTeacherService;

    @PostMapping("/login")
    @ApiOperation("教师登录")
    public JsonResult<Void> login(String name, String password, HttpSession session) {
        itTeacherService.login(name,password,session);
        JsonResult jsonResult = new JsonResult<>(OK);
        return jsonResult;
    }
    @PostMapping("/register")
    @ApiOperation("教师注册")
    public JsonResult<Void> login(TTeacher tTeacher){
        itTeacherService.register(tTeacher);
        return new JsonResult<>(OK);
    }
}
