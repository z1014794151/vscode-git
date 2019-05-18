import java.sql.*;

public class JdbcInsertTest {
    public static Connection connection = null;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EXAMPLE", "root", "");
            Statement statement = connection.createStatement();
            //单条插入
            boolean execute = statement.execute("insert into Students values (0,1,'shiyanlou')");
            if (execute) {
                System.out.println("插入失败");
            }else {
                System.out.println("单条插入成功");
            }
            // 批量插入  需要关闭自动提交
            connection.setAutoCommit(false);
            String sql = "insert into Students values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //设置插入的值
            for (int i = 1; i <= 10; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setInt(2, i + 10);
                preparedStatement.setString(3, "shiyanlou");
                preparedStatement.addBatch();
            }
            //执行批量插入，使用executeBatch 方法
            preparedStatement.executeBatch();
            //提交到数据库
            connection.commit();
            System.out.println("提交批量插入完成");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
