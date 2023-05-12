package com.example.springbootteach.controller.student;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TClass;
import com.example.springbootteach.entity.TTeacher;
import com.example.springbootteach.service.ITTeacherService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/springbootteach/t-student")
@Api(value = "学生-家教信息接口", tags = {"学生-家教信息接口"})
public class STeacherController extends BaseController {
    @Autowired
    ITTeacherService itTeacherService;

    @ApiOperation("查看所有老师")
    @GetMapping("/teacher-list")
    public JsonResult<List<TTeacher>> teacherList(HttpSession session) {
        Object sid = session.getAttribute("sid");
        if (sid == null) {
            throw new SeException("请先登录账号");
        }
        List<TTeacher> list = itTeacherService.list();
        if (list == null) {
            throw new SeException("出现异常");
        }
        JsonResult<List<TTeacher>> JsonResult = new JsonResult<>(OK);
        JsonResult.setMessage("查询成功");
        JsonResult.setData(list);
        return JsonResult;
    }

    @ApiOperation("查看预约过的老师")
    @GetMapping("/myteacher-list")
    public JsonResult<List<TTeacher>> myTeacherList(HttpSession session) {
        Object sid = session.getAttribute("sid");
        if (sid == null) {
            throw new SeException("请先登录账号");
        }
        List<TTeacher> list = itTeacherService.selectMyTeacher((Long) sid);
        JsonResult<List<TTeacher>> listJsonResult = new JsonResult<>();
        listJsonResult.setState(OK);
        listJsonResult.setData(list);
        return listJsonResult;
    }
}