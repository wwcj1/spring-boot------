package com.example.springbootteach.entity;

import java.time.LocalDateTime;
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
@ApiModel(value="TStudent对象", description="学生")
public class TStudent implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "学生密码")
    private String password;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄",example = "1")
    private Integer age;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "详细地址")
    private String area;

    @ApiModelProperty(value = "年级")
    private String grade;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updatedTime;


}
