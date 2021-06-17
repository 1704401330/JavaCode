package Bowling.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 管理员登录登录成功返回connection提示 连接成功 登录成功
 * 登录失败 返回 null 登录失败
 */
public class DBCconnection {
    //建立连接返回数据库连接
    public Connection connect(String name,String password) {
        var url = "jdbc:mysql://localhost:3306/gamedb?SeverTimeZone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=true";
        var dbuser = "root";
        var dbpass = "root";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbuser, dbpass);
            if (conn != null) {
                System.out.println("连接成功！");
            }
            var pstmt = conn.prepareStatement("select * from account where account=? and password=?");
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("登录成功！");
                return conn;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn==null)
                System.out.println("登录失败！");
            return conn;
        }
    }
    //断开连接。
    public void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
