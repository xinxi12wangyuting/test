package com.neusooft.util;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class DBUil1Test {
    private final String STATICURL = "jdbc:mariadb://localhost:3306/mysqldb?user=root=root&password=mariadb";
    private final String URL = "jdbc:mariadb://localhost:3306/mysqldb";
    private final String DBURL = "jdbc:mariadb://localhost:3306/";
    //private final String test = "jdbc:mariadb://localhost/";
    private final String DB = "test";
    private final String USER = "root";
    private final String PASSWORD = "mariadb";

    //建表
    @Test
    void excuteTest1() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getConnection("",DBURL,USER,PASSWORD);
            statement = connection.createStatement();
            final String SQL1 = "create database if not exists test;";
            statement.execute(SQL1);
            final String SQL2 = "use test;";
            statement.execute(SQL2);
            final String SQL3 ="create table offerprice(ofpId int primary key auto_increment,proId varchar(5) ,price varchar(5),typeCd varchar(5))";
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
    //查询
    @Test
    void queryTest() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;

        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "select * from offerprice;";
            resultSet= statement.executeQuery(SQL1);
            System.out.println("ofpId  | proId | price | typeCd");
            while (resultSet.next()){
                System.out.printf("\t%d\t%d\t%s\t%s%n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
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
    //添加
    @Test
    void insertTest() throws SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "insert into offerprice values (1110,'111','28','元'),(1111,'222','58','元'),(1112,'333','18','元'),(1113,'444','24','元'),(1114,'555','27','元'),(1115,'666','26','元'),(1116,'777','29','元');";
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
    //删除
    @Test
    void deleteTest() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "delete from offerprice where proId=2 and proId=4;";
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
    //修改
    @Test
    void updateTest() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getConnection(DB,DBURL,USER,PASSWORD);
            statement = connection.createStatement();

            final String SQL1 = "update offerprice set price=11 where price=29;";
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
}