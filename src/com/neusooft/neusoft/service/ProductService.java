package com.neusooft.neusoft.service;
import com.neusooft.entity.OfferPrice;
import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<OfferPrice> findByProId(int proId) throws SQLException;
    OfferPrice findByprice(int price) throws SQLException;
}
