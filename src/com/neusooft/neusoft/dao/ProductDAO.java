package com.neusooft.neusoft.dao;
import com.neusooft.entity.OfferPrice;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<OfferPrice> findByProId(int porId) throws SQLException;
    OfferPrice findByPrice(int price) throws SQLException;
}
