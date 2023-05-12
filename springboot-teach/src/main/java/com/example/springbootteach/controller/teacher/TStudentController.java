package com.example.springbootteach.controller.teacher;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TStudent;
import com.example.springbootteach.service.ITStudentService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/springbootteach/t-teacher")
@Api(value = "教师-学生接口", tags = {"教师-学生接口"})
public class TStudentController extends BaseController {
    @Autowired
    ITStudentService itStudentService;

    @PostMapping("/mystudent-list")
    @ApiOperation("查看预约自己的学生信息")
    public JsonResult<List<TStudent>> selectMyStudent(HttpSession session) {
        Object tid = session.getAttribute("tid");
        if (tid == null) {
            throw new SeException("请先登录账号");
        }
        List<TStudent> tStudents = itStudentService.selectMyStudent((Long) tid);
        JsonResult<List<TStudent>> jsonResult = new JsonResult<>(OK);
        jsonResult.setData(tStudents);
        return jsonResult;
    }
}
