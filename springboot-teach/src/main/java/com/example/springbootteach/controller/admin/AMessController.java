package com.example.springbootteach.controller.admin;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.controller.BaseController;
import com.example.springbootteach.entity.TMessage;
import com.example.springbootteach.service.ITMessageService;
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
@Api(value = "管理员-留言接口", tags = {"管理员-留言接口"})
public class AMessController extends BaseController {
    @Autowired
    ITMessageService itMessageService;

    @PostMapping("/message-select")
    @ApiOperation("查询留言")
    public JsonResult<List<TMessage>> selectMessage(HttpSession session){
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        JsonResult<List<TMessage>> listJsonResult = new JsonResult<>();
        listJsonResult.setData(itMessageService.list());
        listJsonResult.setState(OK);
        return listJsonResult;
    }
    @PostMapping("/message-delete/{id}")
    @ApiOperation("删除留言")
    public JsonResult<Void> deleteMessage(@PathVariable String id, HttpSession session){
        Object aid = session.getAttribute("aid");
        if (aid == null) {
            throw new SeException("请先登录账号");
        }
        TMessage result = itMessageService.getById(id);
        if(result==null){
            throw new SeException("该留言不存在");
        }
        itMessageService.removeById(id);
        return new JsonResult<>(OK);
    }

}
