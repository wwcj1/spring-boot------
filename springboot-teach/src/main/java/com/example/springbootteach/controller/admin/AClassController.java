package com.example.springbootteach.controller.admin;/*
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
@RequestMapping("/springbootteach/t-admin")
@Api(value = "管理员-课程接口", tags = {"管理员-课程接口"})
public class AClassController extends BaseController {
    @Autowired
    ITClassService itClassService;

    @PostMapping("/class-select")
    @ApiOperation("查询全部课程")
    public JsonResult<List<TClass>> selectClass(HttpSession session){
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        JsonResult<List<TClass>> listJsonResult = new JsonResult<>();
        listJsonResult.setData(itClassService.list());
        listJsonResult.setState(OK);
        return listJsonResult;
    }
    @PostMapping("/class-delete/{tId}")
    @ApiOperation("删除课程")
    public JsonResult<Void> apointmentDelete(@PathVariable String tId, HttpSession session) {
        Object aid = session.getAttribute("aid");
        if (aid == null) {
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
    @PostMapping("/class-update")
    @ApiOperation("修改课程")
    public JsonResult<Void> ClassUpdate(TClass tClass, HttpSession session) {
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        itClassService.updateClass(tClass);

        return new JsonResult<Void>(OK);
    }
}