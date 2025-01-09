package com.itcast.admin.entity;

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
@ApiModel(description = "数据库反回商品类")
public class DityAll {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品折扣")
    private double discount;

    @ApiModelProperty("商品价格")
    private double price;

    @ApiModelProperty("库存数量")
    private Integer number;

    @ApiModelProperty("商品描述")
    private String present;

    @ApiModelProperty("商品状态起售")
    private Integer status;

    @ApiModelProperty("分类表Id")
    private Integer sortId;

    @ApiModelProperty("商品创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("商品图片")
    private String avatar;

}
