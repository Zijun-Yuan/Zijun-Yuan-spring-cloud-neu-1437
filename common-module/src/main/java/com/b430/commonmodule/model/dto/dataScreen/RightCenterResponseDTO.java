package com.b430.commonmodule.model.dto.dataScreen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "数据大屏右中返回值DTO", description = "数据大屏右中返回值DTO")
public class RightCenterResponseDTO {
    @ApiModelProperty(value = "城市名称")
    private String cityName;
//    @ApiModelProperty(value = "排名")
//    private Integer rank;
    @ApiModelProperty(value = "AQI值")
    private Integer aqiReal;
}
