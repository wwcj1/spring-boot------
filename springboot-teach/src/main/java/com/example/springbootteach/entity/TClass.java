package com.example.springbootteach.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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
@ApiModel(value="TClass对象", description="课程")
public class TClass implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "课程名")
    private String name;

    @ApiModelProperty(value = "上课时段")
    private String time;

    @ApiModelProperty(value = "上课时长")
    @TableField("Duration")
    private String duration;

    @ApiModelProperty(value = "老师id",example = "1")
    private Long tId;

    @ApiModelProperty(value = "课程介绍")
    private String introduce;

    @ApiModelProperty(value = "0为被预约 1为未被预约确认")
    private String status;


}
