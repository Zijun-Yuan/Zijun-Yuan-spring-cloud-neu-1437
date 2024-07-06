package com.b430.commonmodule.model.dto.dataScreen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "数据大屏地图返回值DTO", description = "数据大屏地图返回值DTO")
public class CenterMapResponseDTO {
    @ApiModelProperty(value = "地区代码")
    private String regionCode;

    @ApiModelProperty(value = "数据列表")
    private List<DataItem> dataList;

    @Data
    @Accessors(chain = true)
    public static class DataItem {
        @ApiModelProperty(value = "地区下级名称")
        private String name;

        @ApiModelProperty(value = "AQI数值")
        private Integer value;
    }
}
