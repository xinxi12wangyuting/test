package com.neusooft.neusoft.service;

import com.neusooft.entity.OfferPrice;
import com.neusooft.neusoft.dao.ProductDAO;
import com.neusooft.neusoft.dao.ProductDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDAO empDAO=new ProductDAOImpl();
    @Override
    public List<OfferPrice> findByProId(int proId) throws SQLException {
        return null;
    }
    @Override
    public OfferPrice findByprice(int price) throws SQLException {
        return null;
    }
}
