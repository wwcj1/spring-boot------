package com.example.springbootteach.controller.admin;/*
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/springbootteach/t-admin")
@Api(value = "管理员-学生信息接口", tags = {"管理员-学生信息接口"})
public class AStudentController extends BaseController {
    @Autowired
    ITStudentService itStudentService;
    @GetMapping("/student-list")
    @ApiOperation("查看所有学生")
    public JsonResult<List<TStudent>> studentlist() {
        List<TStudent> list = itStudentService.list();
        if (list == null) {
            throw new SeException("出现异常");
        }
        JsonResult<List<TStudent>> JsonResult = new JsonResult<>(OK);
        JsonResult.setMessage("查询成功");
        JsonResult.setData(list);
        return JsonResult;
    }

    @PostMapping("/student-insert")
    @ApiOperation("增加学生")
    public JsonResult<Void> studentInsert(TStudent tStudent, HttpSession session) {
        //判断用户是否存在
        String name = tStudent.getName();
        boolean rows = itStudentService.getByName(name);
        if (rows == true) {
            throw new SeException("该用户已经存在");
        }
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        if (itStudentService.save(tStudent) == true) {
            return new JsonResult<>(OK);
        } else {
            throw new SeException("增加学生失败");
        }
    }

    @PostMapping("/student-delete/{tId}")
    @ApiOperation("删除学生")
    public JsonResult<Void> StudentDelete(@PathVariable String tId, HttpSession session) {
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        //判断是否为存在
        TStudent rows = itStudentService.getById(tId);
        if (rows == null) {
            throw new SeException("该用户不存在");
        }
        if (itStudentService.removeById(tId) == true) {
            return new JsonResult<>(OK);
        } else {
            throw new SeException("删除学生失败");
        }
    }

    @PostMapping("/student-update")
    @ApiOperation("修改学生")
    public JsonResult<Void> studentUpdate(TStudent tStudent, HttpSession session) {

        itStudentService.updateStudent(tStudent);

        return new JsonResult<Void>(OK);
    }

}
