package com.example.springbootteach.service.impl;

import com.example.springbootteach.entity.TAppointment;
import com.example.springbootteach.entity.TStudent;
import com.example.springbootteach.entity.TTeacher;
import com.example.springbootteach.mapper.TAppointmentMapper;
import com.example.springbootteach.mapper.TTeacherMapper;
import com.example.springbootteach.service.ITTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootteach.service.exception.SeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Service
public class TTeacherServiceImpl extends ServiceImpl<TTeacherMapper, TTeacher> implements ITTeacherService {
    @Autowired
    TTeacherMapper tTeacherMapper;
    @Autowired
    TAppointmentMapper tAppointmentMapper;

    @Override
    public boolean getByName(String name) {
        TTeacher rows = tTeacherMapper.getByName(name);
        if (rows != null) {
            return true;
        }
        return false;
    }

    @Override
    public Void updateTeacher(TTeacher tTeacher) {
        TTeacher rows = getById(tTeacher.getId());
        if (rows == null) {
            throw new SeException("该用户不存在");
        } else {
            Integer integer = tTeacherMapper.updateById(tTeacher);
            if (integer != 1) {
                throw new SeException("修改教师异常");
            }
        }
        return null;
    }

    @Override
    public List<TTeacher> selectMyTeacher(Long sid) {
        List<TAppointment> tAppointments = tAppointmentMapper.selectBySId(sid);
        List<TTeacher> listTeacher=new ArrayList<>();
        for (TAppointment tAppointment : tAppointments) {
            Long tId = tAppointment.getTId();
            TTeacher tTeacher = tTeacherMapper.selectById(tId);
            listTeacher.add(tTeacher);
        }
        return listTeacher;
    }

    @Override
    public void login(String name, String password, HttpSession session) {
        TTeacher result = tTeacherMapper.getByName(name);
        if(result==null){
            throw new SeException("该用户不存在");
        }
        if(password.equals(result.getPassword())){
            session.setAttribute("tid",result.getId());
        }else{
            throw new SeException("密码错误");
        }
    }
    @Override
    public void register(TTeacher tTeacher) {
        String name = tTeacher.getName();
        TTeacher result = tTeacherMapper.getByName(name);
        if(result!=null){
            throw new SeException("该用户名已存在");
        }else{
            int insert = tTeacherMapper.insert(tTeacher);
            if(insert!=1){
                throw new SeException("注册异常");
            }
        }

    }


}
