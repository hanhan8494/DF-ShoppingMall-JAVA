package com.itcast.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "管理员登录时传递的数据模型")
public class AdminDTO {

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String password;

}
