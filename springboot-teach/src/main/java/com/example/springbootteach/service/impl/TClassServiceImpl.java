package com.example.springbootteach.service.impl;

import com.example.springbootteach.entity.TAppointment;
import com.example.springbootteach.entity.TClass;
import com.example.springbootteach.entity.TClass;
import com.example.springbootteach.entity.TTeacher;
import com.example.springbootteach.mapper.TAppointmentMapper;
import com.example.springbootteach.mapper.TClassMapper;
import com.example.springbootteach.mapper.TClassMapper;
import com.example.springbootteach.service.ITClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootteach.service.exception.SeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Service
public class TClassServiceImpl extends ServiceImpl<TClassMapper, TClass> implements ITClassService {
    @Autowired
    TClassMapper tClassMapper;
    @Autowired
    TAppointmentMapper tAppointmentMapper;
    //修改课程信息
    @Override
    public Void updateClass(TClass tClass) {
        TClass rows= getById(tClass.getId());
        if(rows==null){
            throw new SeException("该预约不存在");
        }else {
            Integer integer = tClassMapper.updateById(tClass);
            if(integer!=1){
                throw new SeException("修改预约异常");
            }
        }
        return null;
    }

    //查询我的预约课程
    @Override
    public List<TClass> selectMyClass(Long sid) {
        List<TAppointment> tAppointments = tAppointmentMapper.selectBySId(sid);
//        QueryWrapper
//        tAppointmentMapper.selectList()
        List<TClass> listClass=new ArrayList<>();
        for (TAppointment tAppointment : tAppointments) {
            Long cId = tAppointment.getCId();
            System.out.println(cId);
            TClass tClass = tClassMapper.selectById(String.valueOf(cId));
            listClass.add(tClass);
        }

        return listClass;
//        return null;
    }

    @Override
    public Void classInsert(TClass tClass) {
        int result = tClassMapper.insert(tClass);
        if(result!=1){
            throw new SeException("发布课程出现异常");
        }
        return null;
    }

    @Override
    public List<TClass> selectTeacherClass(Long tid) {
        List<TClass> tClasslist = tClassMapper.selectByTId(tid);
        if(tClasslist==null){
            throw new SeException("查询课程表异常");
        }
        return tClasslist;
    }

}
