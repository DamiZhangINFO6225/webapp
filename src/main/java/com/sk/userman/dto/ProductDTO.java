package com.sk.userman.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("产品接收对象")
public class ProductDTO implements Serializable {
    /**
     * 产品id
     */
    @TableId
    @ApiModelProperty(value = "产品id",readOnly = true)
    private Integer id;

    /**
     * 产品名
     */
    @NotBlank(message = "产品名不能为空")
    @ApiModelProperty("产品名")
    private String name;
    @NotBlank(message = "描述不能为空")
    private String description;
    @NotBlank(message = "sku不能为空")
    private String sku;
    @NotBlank(message = "manufacturer不能为空")
    private String manufacturer;

    /**
     * 产品价格
     */
    @DecimalMin(value = "0", message = "产品价格不能为负数")
    @ApiModelProperty("产品价格")
    private BigDecimal price;

    /**
     * 产品数量
     */
    @Min(value = 0, message = "产品数量不能为负数No minus")
    @Max(value = 999, message = "产品数量超过最大数out of range")
    @ApiModelProperty("产品数量No. of Product")
    private Integer quantity;

    /**
     * 产品创建者
     */
    @ApiModelProperty(value = "产品创建者Creator of Product",hidden = true,readOnly = true)
    private String userId;
    @ApiModelProperty(value = "创建时间Time Created",hidden = true,readOnly = true)
    private Date dateAdded;
    @ApiModelProperty(value = "最后修改时间Time updated last time",hidden = true,readOnly = true)
    private Date dateLastUpdated;

    private static final long serialVersionUID = 1L;
}