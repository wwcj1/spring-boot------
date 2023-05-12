package com.example.springbootteach.mapper;

import com.example.springbootteach.entity.TAppointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Mapper
public interface TAppointmentMapper extends BaseMapper<TAppointment> {

    public List<TAppointment> selectBySId(Long sid);
    public List<TAppointment> selectByTId(Long tid);
    public TAppointment selectByTIdAndSId(Long tid,Long sid);
}
