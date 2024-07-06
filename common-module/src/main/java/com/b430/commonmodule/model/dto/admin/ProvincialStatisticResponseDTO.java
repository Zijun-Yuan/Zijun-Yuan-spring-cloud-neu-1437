package com.b430.commonmodule.model.dto.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "省分组分项检查统计返回值", description = "省分组分项检查统计返回值")
public class ProvincialStatisticResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "省份名称")
    private String provinceName;

    @ApiModelProperty(value = "简称")
    private String simpleName;

    @ApiModelProperty(value = "so2超标次数累计")
    private Integer so2Exceed;

    @ApiModelProperty(value = "co超标次数累计")
    private Integer coExceed;

    @ApiModelProperty(value = "o3超标次数累计")
    private Integer o3Exceed;

    @ApiModelProperty(value = "pm2.5超标次数累计")
    private Integer pm25Exceed;

    @ApiModelProperty(value = "aqi超标次数累计")
    private Integer aqiExceed;

    public ProvincialStatisticResponseDTO() {
        this.so2Exceed = 0;
        this.coExceed = 0;
        this.o3Exceed = 0;
        this.pm25Exceed = 0;
        this.aqiExceed = 0;
    }
}
