package cn.wbhan.disaster.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://121.199.58.227/disaster",
                "root", "wbh20000329");
        Statement statement = connection.createStatement();
        statement.execute("update logistic set status = '未发货' where id = 1");
    }
}
