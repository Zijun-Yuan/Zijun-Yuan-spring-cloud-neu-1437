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
@TableName("province")
@ApiModel(value="Province对象", description="")
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "省id")
    @TableId(value = "province_id", type = IdType.AUTO)
    private Integer provinceId;

    @ApiModelProperty(value = "省名")
    private String provinceName;

    @ApiModelProperty(value = "省简称")
    private String simpleName;

    @ApiModelProperty(value = "省序号")
    private Integer index;


}
