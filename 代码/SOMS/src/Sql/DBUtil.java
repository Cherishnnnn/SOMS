package Sql;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class DBUtil {
	    
	    private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=Shoms";
	    private static final String NAME="sa";
	    private static final String PASSWORD="sasasa";
	    
	    private static Connection conn=null;
	    //��̬����飨�������������������ݿ���뾲̬���У�
	    static{
	        try {
	            //1.������������
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            //2.������ݿ������
	            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    //�����ṩһ����������ȡ���ݿ�����
	    public static Connection getConnection(){
	        return conn;
	    }
//	    public static void main(String[] args) throws Exception{
//	        
//	        //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
//	        Statement stmt = conn.createStatement();
//	        ResultSet rs = stmt.executeQuery("SELECT *\r\n" + 
//	        		"FROM Member");//ѡ��import java.sql.ResultSet;
//	        while(rs.next()){//��������������ݣ��ͻ�ѭ����ӡ����
//	            System.out.println(rs.getString("Member_no")+","+rs.getString("Member_name"));
//	            
//	        }
//	        rs.close();
//	        stmt.close();
//	        conn.close();
//	    }
	}

