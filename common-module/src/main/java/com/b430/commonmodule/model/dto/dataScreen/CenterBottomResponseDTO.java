package com.b430.commonmodule.model.dto.dataScreen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "数据大屏中下返回值DTO", description = "数据大屏中下返回值DTO")
public class CenterBottomResponseDTO {
    @ApiModelProperty(value = "城市覆盖率")
    private Double UrbanCoverRate;
    @ApiModelProperty(value = "省份简称")
    private String simpleName;
    @ApiModelProperty(value = "城市SO2超标数")
    private Integer so2Exceed;
    @ApiModelProperty(value = "城市CO超标数")
    private Integer coExceed;
    @ApiModelProperty(value = "城市O3超标数")
    private Integer o3Exceed;
    @ApiModelProperty(value = "城市PM2.5超标数")
    private Integer pm25Exceed;
}
