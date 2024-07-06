package com.b430.commonmodule.model.dto.dataScreen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "数据大屏左中返回值DTO", description = "数据大屏左中返回值DTO")
public class LeftCenterResponseDTO {
    @ApiModelProperty(value = "aqi等级为1的数量")
    private Integer aqiLevel_1;
    @ApiModelProperty(value = "aqi等级为2的数量")
    private Integer aqiLevel_2;
    @ApiModelProperty(value = "aqi等级为3的数量")
    private Integer aqiLevel_3;
    @ApiModelProperty(value = "aqi等级为4的数量")
    private Integer aqiLevel_4;
    @ApiModelProperty(value = "aqi等级为5的数量")
    private Integer aqiLevel_5;
    @ApiModelProperty(value = "aqi等级为6的数量")
    private Integer aqiLevel_6;

}
