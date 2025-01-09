package com.itcast.admin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "查全数据库反商品图片实体类")
public class DityUrls {

    @ApiModelProperty("关联商品id")
    private Long dityId;

    @ApiModelProperty("图片路径")
    private String avatar;
}
