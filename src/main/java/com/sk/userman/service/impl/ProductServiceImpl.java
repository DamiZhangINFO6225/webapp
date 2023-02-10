package com.sk.userman.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sk.userman.domain.Product;
import com.sk.userman.mapper.ProductMapper;
import com.sk.userman.service.ProductService;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
implements ProductService {

}
