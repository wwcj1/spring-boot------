package com.example.springbootteach.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author snoppy
 * @since 2023-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TAppointment对象", description="预约")
public class TAppointment implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "老师id",example = "1")
    private Long tId;

    @ApiModelProperty(value = "学生id",example = "1")
    private Long sId;

    @ApiModelProperty(value = "课程id",example = "1")
    private Long cId;

    @ApiModelProperty(value = "0为老师未确认 1为老师确认")
    private String status;


}
