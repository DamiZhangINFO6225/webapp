package com.sk.userman.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName product
 */
@Data
public class Product implements Serializable {
    /**
     * 产品id
     */
    @TableId
    private Integer id;

    /**
     * 产品名
     */
    private String name;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 产品sku
     */
    private String sku;
    private String manufacturer;

    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 产品创建者
     */

    private String ownerUserId;

    private Date dateAdded;
    private Date dateLastUpdated;

    private static final long serialVersionUID = 1L;
}