package text.kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees_Chapter04 {

    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/challenge_java", "root", "sql_Matsu@1221");
            System.out.println("データベース接続成功");
            
            statement = con.createStatement();
            String sql =    """
                            CREATE TABLE employees (
                              id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
                              name VARCHAR(60) NOT NULL,
                              email VARCHAR(255) NOT NULL,
                              age INT(11),
                              address VARCHAR(255)
                            );
                            """;
            int rowCnt = statement.executeUpdate(sql);
            System.out.println("テーブルを作成:rowCnt=" + rowCnt);
            
        } catch(SQLException e) {
            System.out.println("エラー発生：" + e.getMessage());
        } finally {
            if (statement != null) {
                try { statement.close(); } catch(SQLException ignore) {}
                try { con.close(); } catch(SQLException ignore) {}
            }
        }
        
    }

}
