package ru.netology.data;

import lombok.SneakyThrows;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper{
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();
    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String password = System.getProperty("db.password");

    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    @SneakyThrows
    public static  String getBuyStatus(){
        var sqlCode = "SELECT * from payment_entity pe order by created desc limit 1";
        var conn = getConnection();
        return  QUERY_RUNNER.query(conn,sqlCode, new ScalarHandler<String>());

    }

}



