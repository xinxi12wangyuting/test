package com.neusooft.neusoft.dao;
import com.neusooft.entity.OfferPrice;
import com.neusooft.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDAOImpl implements ProductDAO {
    private final String STATICURL = "jdbc:mariadb://localhost:3306/mysqldb?user=root=root&password=mariadb";
    private final String URL = "jdbc:mariadb://localhost:3306/mysqldb";
    private final String DBURL = "jdbc:mariadb://localhost:3306/";

    private final String DB = "test";
    private final String USER = "root";
    private final String PASSWORD = "mariadb";

    public OfferPrice findByPrice(int price) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        OfferPrice offerPrice=null;
        try {
            connection  = DBUtil.getConnection(URL,USER,PASSWORD);
            final String SQL="select * from offerprice where proId=25;";
            preparedStatement=connection.prepareStatement(SQL);

            resultSet=preparedStatement.executeQuery();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }if(preparedStatement!=null){
                preparedStatement.close();
            }if(resultSet!=null){
                resultSet.close();
            }
        }
        return offerPrice;
    }
    public List<OfferPrice> findByProId(int proId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<OfferPrice> offerPrices=new ArrayList<>();

        try {
            connection  = DBUtil.getConnection(URL,USER,PASSWORD);
            final String SQL="select price from offerprice where price>?;";
            preparedStatement=connection.prepareStatement(SQL);
            preparedStatement.setDouble(1,proId);

            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                offerPrices.add(new OfferPrice(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));

                System.out.printf("%d %s %d%n",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }if(preparedStatement!=null){
                preparedStatement.close();
            }if(resultSet!=null){
                resultSet.close();
            }
        }
        return offerPrices;
    }
}
