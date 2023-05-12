package com.example.springbootteach.controller.admin;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TTeacher;
import com.example.springbootteach.service.ITTeacherService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/springbootteach/t-admin")
@Api(value = "管理员-教师信息接口", tags = {"管理员-教师信息接口"})
public class ATeacherController extends BaseController {
    @Autowired
    ITTeacherService itTeacherService;
    @ApiOperation("查看所有老师")
    @GetMapping("/teacher-list")
    public JsonResult<List<TTeacher>> teacherlist() {
        List<TTeacher> list = itTeacherService.list();
        if (list == null) {
            throw new SeException("出现异常");
        }
        JsonResult<List<TTeacher>> JsonResult = new JsonResult<>(OK);
        JsonResult.setMessage("查询成功");
        JsonResult.setData(list);
        return JsonResult;
    }

    @PostMapping("/teacher-insert")
    @ApiOperation("增加老师")
    public JsonResult<Void> teacherInsert(TTeacher tTeacher, HttpSession session) {
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        String name = tTeacher.getName();
        boolean rows = itTeacherService.getByName(name);
        if (rows == true) {
            throw new SeException("该用户已经存在");
        }
        if (itTeacherService.save(tTeacher) == true) {
            return new JsonResult<>(OK);
        } else {
            throw new SeException("增加老师失败");
        }
    }

    @PostMapping("/teacher-delete/{tId}")
    @ApiOperation("删除老师")
    public JsonResult<Void> teacherDelete(@PathVariable String tId, HttpSession session) {
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        //判断是否为存在
        TTeacher rows = itTeacherService.getById(tId);
        if (rows == null) {
            throw new SeException("该用户不存在");
        }
        if (itTeacherService.removeById(tId) == true) {
            return new JsonResult<>(OK);
        } else {
            throw new SeException("删除老师失败");
        }
    }

    @PostMapping("/teacher-update")
    @ApiOperation("修改老师")
    public JsonResult<Void> teacherUpdate(TTeacher tTeacher, HttpSession session) {

        itTeacherService.updateTeacher(tTeacher);

        return new JsonResult<Void>(OK);
    }
}
