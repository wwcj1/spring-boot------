package com.example.springbootteach.mapper;

import com.example.springbootteach.entity.TMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Mapper
public interface TMessageMapper extends BaseMapper<TMessage> {

}
