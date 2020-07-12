package com.neusooft.util;
import org.junit.jupiter.api.Test;
import java.sql.*;
class DBUtilTest {
    private final String STATICURL = "jdbc:mariadb://localhost:3306/mysqldb?user=root=root&password=mariadb";
    private final String URL = "jdbc:mariadb://localhost:3306/mysqldb";
    private final String DBURL = "jdbc:mariadb://localhost:3306/";

    private final String DB = "test";
    private final String USER = "root";
    private final String PASSWORD = "mariadb";

//查询
    @Test
    void queryTest() throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;
        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "select * from product;";
            resultSet= statement.executeQuery(SQL1);
            System.out.println("proId   | sku  | title");
            while (resultSet.next()){
                System.out.printf("\t%d\t\t%s\t\t%s%n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
//修改
    @Test
    void updateTest() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "update product set title='大苹果' where title='牙膏';";
            int num= statement.executeUpdate(SQL1);
            System.out.println(num==0?"没有修改":"修改成功");

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
 //添加
    @Test
    void insertTest() throws SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "insert into product values (5,'555','香蕉'),(6,'666','葡萄');";
            statement.execute(SQL1);

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
//建表
    @Test
    void excuteTest() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getConnection("",DBURL,USER,PASSWORD);
            statement = connection.createStatement();
            final String SQL1 = "create database if not exists test;";
            statement.execute(SQL1);
            final String SQL2 = "use test;";
            statement.execute(SQL2);
            final String SQL3 ="create table product(proId int primary key auto_increment,sku varchar(5) not null,title varchar(10))";
            statement.execute(SQL3);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
    //删除
    @Test
    void deleteTest() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "delete from product where proId=2 and proId=4;";
            statement.execute(SQL1);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}