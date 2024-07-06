package com.b430.commonmodule.model.dto.dataScreen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "数据大屏右下返回值DTO", description = "数据大屏右下返回值DTO")
public class RightBottomResponseDTO {
    @ApiModelProperty(value = "网格用户名称")
    private String realName;
    @ApiModelProperty(value = "反馈时间")
    private Date time;
    @ApiModelProperty(value = "格式化后的反馈时间")
    private String formattedTime;
    @ApiModelProperty(value = "AQI等级")
    private Integer rank;
    @ApiModelProperty(value = "AQI真实值")
    private Integer aqiReal;
    @ApiModelProperty(value = "反馈地址")
    private String location;

    public String getFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.time);
    }

}
