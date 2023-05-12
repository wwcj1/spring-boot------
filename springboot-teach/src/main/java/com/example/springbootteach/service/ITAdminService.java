package com.example.springbootteach.service;

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.entity.TAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootteach.entity.TStudent;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
public interface ITAdminService extends IService<TAdmin> {


    public JsonResult login(String name, String password, HttpSession session);
    public boolean insertStudent(TStudent tStudent);
}
