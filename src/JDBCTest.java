import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//连接数据库
public class JDBCTest {

	public static void main(String[] args){
		 // 不同的数据库有不同的驱动
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:xaiu";
        String user = "xaiu";
        String password = "xaiu";

        try {
            // 加载驱动
            Class.forName(driverName);
            // 设置 配置数据
            // 1.url(数据看服务器的ip地址 数据库服务端口号 数据库实例)
            // 2.user
            // 3.password
            Connection  conn = DriverManager.getConnection(url, user, password);
            // 开始连接数据库
            System.out.println("数据库连接成功..");
            
           // sql 操作
            PreparedStatement  st = conn.prepareStatement("select * from xaiu_book");
            ResultSet  rs = st.executeQuery();
            
            while(rs.next()){
            	System.out.println(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

	}
}
