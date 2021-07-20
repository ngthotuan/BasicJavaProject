import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class MySQL {
    private static String DB_URL = "jdbc:mysql://localhost:3306/st";
    private static String USER_NAME = "root";
    private static String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection(DB_URL, USER_NAME, PASSWORD);
        if (connection != null) {
//            System.out.println("=====Statement");
//            statement(connection);
            connection.setAutoCommit(false);
            System.out.println("=====Prepared Statement ");
            preparedStatement(connection);
            connection.close();
        }
    }

    private static void preparedStatement(Connection connection) {
        try {
            PreparedStatement statement;
            String sql;
            // insert multiple
            sql = "insert into students (name) values (?) ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Test 1");
            statement.addBatch();
            statement.setString(1, "Test 2");
            statement.addBatch();
            int[] n = statement.executeBatch();
            System.out.println("Thêm thành công: "+ n.length);


            sql = "select * from students where id > ? and name like ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 2);
            statement.setString(2, "%Test%");

            ResultSet resultSet = statement.executeQuery();
            System.out.println("Select student id > 2 name like %Test%:");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void statement(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet;

            // executeUpdate: insert, update, delete
            String sql = String.format("insert into %s(name) values ( '%s'), ( '%s')", "students", "student 1", "student 2");
            int n = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (n > 0) {
                System.out.println("Thêm dữ liệu thành công: " + n);
                resultSet = statement.getGeneratedKeys();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("id vừa thêm: " + id);
                }
            } else {
                System.out.println("Error insert ");
            }

            // executeQuery: select
            resultSet = statement.executeQuery("select * from students");
            System.out.println("Lấy danh sách sinh viên");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }

        } catch (SQLException ex) {
            System.err.println("SQLException " + ex.getMessage());
        }
    }

    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(dbURL, userName, password);
            Properties info = new Properties();
            info.setProperty("characterEncoding", "utf8");
            info.setProperty("user", userName);
            info.setProperty("password", password);
            connection = DriverManager.getConnection(dbURL, info);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return connection;
    }
}
