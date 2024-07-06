package com.b430.commonmodule.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("inspector")
@ApiModel(value="Inspector对象", description="")
public class Inspector implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "网格员编号")
    @TableId(value = "inspector_id", type = IdType.AUTO)
    private Integer inspectorId;

    @ApiModelProperty(value = "网格员登录编码")
    private String inspectorCode;

    @ApiModelProperty(value = "网格员登录密码")
    private String password;

    @ApiModelProperty(value = "网格员电话")
    private String telNum;

    @ApiModelProperty(value = "网格员姓名")
    private String realName;

    @ApiModelProperty(value = "网格员所负责的城市代码")
    private String cityCode;

    @ApiModelProperty(value = "软删除")
    private Integer isdel;

    @ApiModelProperty(value = "备注")
    private String remarks;


}
