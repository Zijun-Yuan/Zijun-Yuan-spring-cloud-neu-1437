package com.b430.commonmodule.model.dto.dataScreen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "数据大屏右上返回值DTO", description = "数据大屏右上返回值DTO")
public class RightTopResponseDTO {
    @ApiModelProperty(value = "月份时间")
    private String monthTime;
    @ApiModelProperty(value = "超标次数")
    private Integer exceedNum;
}
