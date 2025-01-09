package com.itcast.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "商品接收的数据")
public class CommodityDTO {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品价格")
    private double price;

    @ApiModelProperty("库存数量")
    private Integer number;

    @ApiModelProperty("商品描述")
    private String present;

    @ApiModelProperty("分类表Id")
    private Integer sortId;


}
