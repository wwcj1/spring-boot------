package com.example.springbootteach.service.impl;

import com.example.springbootteach.common.JsonResult;
import com.example.springbootteach.entity.TAdmin;
import com.example.springbootteach.entity.TStudent;
import com.example.springbootteach.mapper.TAdminMapper;
import com.example.springbootteach.service.ITAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootteach.service.exception.SeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.example.springbootteach.controller.BaseController.OK;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements ITAdminService {
    @Autowired
    TAdminMapper tAdminMapper;
    @Override
    public JsonResult login(String name, String password, HttpSession session) {
        TAdmin byName = tAdminMapper.getByName(name);
        String pswd = byName.getPassword();
        if(password.equals(pswd)){
            session.setAttribute("aid",byName.getId());
            return new JsonResult<>(OK);
        }else {
           throw new SeException("账号或者密码错误");
        }
    }

    @Override
    public boolean insertStudent(TStudent tStudent) {
        return false;
    }
}
