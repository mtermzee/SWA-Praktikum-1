package de.hsos.swa.ssa.JDBC.sql;

import java.sql.*;

public class MysqlConnection {
    private static String dbURL = "jdbc:mysql://localhost:3306/test_simple_shop?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "admin";
    private static String host = "localhost";
    private static int port = 3306;
    private static String database = "test_simple_shop";

    public static Connection getConnection() throws SQLException {
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL, user, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn = DriverManager.getConnection(dbURL, user, password);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement statement) throws SQLException {
        statement.close();
    }

    public static void close(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    public static void close(Connection cnn) throws SQLException {
        cnn.close();
    }

    public static void setDatabaseUser(String userdb) {
        user = userdb;
    }

    public static void setDatabasePassword(String passwd) {
        password = passwd;
    }

    public static void reloadStringConnection() {
        dbURL = "jdbc:mysql://" + host + ":" + port + "/" + database +
                "?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        MysqlConnection.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        MysqlConnection.port = port;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        MysqlConnection.database = database;
    }

    public static String getConnectionString() {
        return dbURL;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

}