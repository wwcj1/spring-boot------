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
@ApiModel(value="TMessage对象", description="留言")
public class TMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "学生id",example = "1")
    private Long sId;

    @ApiModelProperty(value = "老师id",example = "1" )
    private Long tId;

    @ApiModelProperty(value = "留言")
    private String mess;

    @ApiModelProperty(value = "回复留言")
    private String responseMess;
}
