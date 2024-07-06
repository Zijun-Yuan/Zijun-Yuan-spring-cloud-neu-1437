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
@Api(value = "数据大屏左下返回值DTO", description = "数据大屏左下返回值DTO")
public class LeftBottomResponseDTO {
    @ApiModelProperty(value = "反馈姓名")
    private String realName;
    @ApiModelProperty(value = "反馈时间")
    private Date time;
    @ApiModelProperty(value = "反馈等级")
    private Integer aqiLevel;
    @ApiModelProperty(value = "反馈信息")
    private String feedback;
    @ApiModelProperty(value = "反馈位置")
    private String location;
    @ApiModelProperty(value = "反馈格式化后的时间")
    private String formattedTime;

    public String getFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.time);
    }

}
