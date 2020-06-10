package utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * Druid工具类
 */
public class JDBCUtils {
    private static DataSource dataSource;

    /*
      获取DataSource
     */
    static {
        try {
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个Connection
     * @return Connection 返回Connection对象
     * @throws SQLException 就是个错误
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     * @param preparedStatement preparedStatement
     * @param connection Connection
     */
    public static void close(PreparedStatement preparedStatement, Connection connection){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param resultSet ResutSet
     * @param preparedStatement preparedStatement
     * @param connection Connection
     */
    public static void close(ResultSet resultSet,PreparedStatement preparedStatement, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     * 获取连接池
     * @return DataSource
     */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
