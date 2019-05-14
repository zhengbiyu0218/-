package com.zby.demo.service.impl;

import com.zby.demo.dao.ProductDao;
import com.zby.demo.model.Product;
import com.zby.demo.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDao productDao;

    @Override
    public List<Product> getAll() {
        List list = productDao.getProductList();
        return list;
    }

    @Override
    public boolean updateProduct(Product product) {
        int result = 0;
        if (product.getProductId() != null) {
            result = productDao.updateByPrimaryKeySelective(product);
        } else {
            result = productDao.insert(product);
        }
        if ( result > 0) {
            return true;
        } else {
             return false;
        }
    }

    @Override
    public boolean delProduct(int productId) {
        int result = productDao.deleteByPrimaryKey(productId);
        if ( result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
