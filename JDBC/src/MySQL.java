import java.io.Console;
import java.math.BigInteger;
import java.sql.*;
import java.util.Properties;

public class MySQL {
    private static String DB_URL = "jdbc:mysql://103.130.216.99:3306/nttuanco_Test";
    private static String USER_NAME = "nttuanco_xuantuanoccho";
    private static String PASSWORD = "h@hStwQ2wdW4sCw";
    public static void main(String[] args) {
        Connection connection = getConnection(DB_URL, USER_NAME, PASSWORD);
        if(connection != null){
            System.out.println("Statement");
            statement(connection);

            System.out.println("Prepared Statement ");
            preparedStatement(connection);
        }
    }

    private static void preparedStatement(Connection connection) {
        try {
            String sql = "select * from Student where id > ? and name like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 2);
            statement.setString(2, "%Tuấn%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }

            // insert
            sql = "insert into Student (name) values (?) ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Test 1");
            statement.addBatch();
            statement.setString(1, "Test 2");
            statement.addBatch();

            System.out.println(statement);
            int [] n = statement.executeBatch();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void statement(Connection connection){
        try {
            Statement statement = connection.createStatement();
            // Get table
            ResultSet resultSet = statement.executeQuery("select * from Student");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
            // Update
            String sql = String.format("insert into %s(name) values ( '%s'), ( '%s')", "Student", "Xuân Tuấn óc chó", "Xuân Tuấn óc chó");
            int n = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if(n > 0){
                System.out.println("Thêm dữ liệu thành công");
                resultSet=statement.getGeneratedKeys();
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    System.out.println("id vừa thêm: " + id);
                }
            }
            else {
                System.out.println("Error insert ");
            }
        } catch (SQLException throwables) {
            System.err.println("SQLException " + throwables.getMessage());
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
