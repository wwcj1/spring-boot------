package com.example.springbootteach.controller.teacher;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TClass;
import com.example.springbootteach.service.ITClassService;
import com.example.springbootteach.service.exception.SeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/springbootteach/t-teacher")
@Api(value = "教师-课程接口", tags = {"教师-课程接口"})
public class TClassController extends BaseController {
    @Autowired
    ITClassService itClassService;

    @PostMapping("/class-insert")
    @ApiOperation("老师发布课程")
    public JsonResult<Void> classInsert(TClass tClass, HttpSession session){
        Object tid = session.getAttribute("tid");
        if (tid == null) {
            throw new SeException("请先登录账号");
        }
        itClassService.classInsert(tClass);
        return new JsonResult<>(OK);
    }

    @PostMapping("/class-update")
    @ApiOperation("老师修改课程")
    public JsonResult<Void> ClassUpdate(TClass tClass, HttpSession session) {
        Object tid = session.getAttribute("tid");
        if (tid == null) {
            throw new SeException("请先登录账号");
        }
        itClassService.updateClass(tClass);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/class-delete/{tId}")
    @ApiOperation("教师删除课程")
    public JsonResult<Void> classDelete(@PathVariable String tId, HttpSession session) {
        Object tid = session.getAttribute("tid");
        if (tid == null) {
            throw new SeException("请先登录账号");
        }
        //判断是否存在
        TClass rows = itClassService.getById(tId);
        if (rows == null) {
            throw new SeException("该课程不存在");
        }
        if (itClassService.removeById(tId) == true) {
            return new JsonResult<>(OK);
        } else {
            throw new SeException("删除课程失败");
        }
    }
    @PostMapping("/class-select")
    @ApiOperation("教师查询自己的课程表")
    public JsonResult< List<TClass> > selectMyClass(HttpSession session) {
        Object tid = session.getAttribute("tid");
        if (tid == null) {
            throw new SeException("请先登录账号");
        }
        List<TClass> list = itClassService.selectTeacherClass((Long) tid);
        JsonResult<List<TClass>> listJsonResult = new JsonResult<>(OK);
        listJsonResult.setData(list);
        return listJsonResult;
    }
}
