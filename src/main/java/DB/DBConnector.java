package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
	
	private final static String URL = "jdbc:mariadb://localhost:3306/test";
	private final static String USER = "root";
	private final static String PASSWORD = "1q2w3e4r";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Connection openDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("JDBC Connection Open!");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean createTable(Connection conn, String sql) {		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public int getRows(Connection conn, String sql) {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;		
	}
	
	public boolean insertData(Connection conn, String sql, DBTable data) {
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, data.getNo());
			pstmt.setString(2, data.getName());
			pstmt.setString(3, data.getEmail());
			pstmt.setString(4, data.getDate());
			pstmt.setString(5, data.getPwd());
			pstmt.setInt(6, data.getGen());
			pstmt.setBoolean(7, data.isDel());
			
			int state = pstmt.executeUpdate();
			pstmt.close();
			if(state == 1) return true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateData(Connection conn, String sql, DBTable data) {		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getName());
			pstmt.setString(2, data.getEmail());
			pstmt.setString(3, data.getPwd());
			pstmt.setInt(4, data.getGen());
			pstmt.setInt(5, data.getNo());
			
			int state = pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			if(state == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteData(Connection conn, String sql) {		
		try {
			pstmt = conn.prepareStatement(sql);
			int state = pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			if(state == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<DBTable> getData(Connection conn, String sql) {
		List<DBTable> list = new ArrayList<>();
		try {			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DBTable data = new DBTable();
				data.setNo(rs.getInt("번호"));
				data.setName(rs.getString("이름"));
				data.setEmail(rs.getString("이메일"));
				data.setDate(rs.getString("가입날짜"));
				data.setPwd(rs.getString("비밀번호"));
				data.setGen(rs.getInt("성별"));
				list.add(data);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
