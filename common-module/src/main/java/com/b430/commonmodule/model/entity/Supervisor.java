package com.b430.commonmodule.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("supervisor")
@ApiModel(value="Supervisor对象", description="")
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公众监督员编号")
    @TableId(value = "supervisor_id", type = IdType.AUTO)
    private Integer supervisorId;

    @ApiModelProperty(value = "公众监督员编号（手机号码）")
    private String telId;

    @ApiModelProperty(value = "公众监督员登录密码")
    private String password;

    @ApiModelProperty(value = "公众监督员真实姓名")
    private String realName;

    @ApiModelProperty(value = "公众监督员生日日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "公众监督员性别（1：男；0：女）")
    private Integer sex;

    @ApiModelProperty(value = "公众监督员年龄")
    private Integer age;

    @ApiModelProperty(value = "软删除 ")
    private Integer isdel;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "token")
    private String token;

}
