package com.example.springbootteach.mapper;

import com.example.springbootteach.entity.TClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootteach.entity.TTeacher;
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
public interface TClassMapper extends BaseMapper<TClass> {
   public List<TClass> selectByTId(Long tid);
}
