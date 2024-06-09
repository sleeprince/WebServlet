package DB;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppController {
	
	private DBConnector db;
	private Connection conn;
	private String sql;
	private int row = 0;
	
	public AppController() {
		this.db = new DBConnector();
		this.conn = db.openDB();
		if(conn != null) createTable();
		this.row = getRows();
		System.out.println("데이터 개수:" + row);
	}
	
	public void createTable() {
		sql = "create table if not exists USER "
				+ "("
				+ "번호 int"
				+ ", 이름 varchar(100)"
				+ ", 이메일 varchar(100)"
				+ ", 가입날짜 date"
				+ ", 비밀번호 varchar(100)"
				+ ", 성별 int"
				+ ", 삭제 boolean"
				+ ")";
		System.out.println("sql 확인: " + sql);
		db.createTable(conn, sql);
	}
	
	public int getRows() {
		sql = "select count(*) as cnt from USER";
		return db.getRows(conn, sql);
	}
	
	public void insertData(String name, String email, String pwd, int gen) {
		sql = "insert into USER value (?,?,?,?,?,?,?)";
		DBTable data = new DBTable();
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String day = dateFormat.format(today);
		
		data.setNo(row+1);
		data.setName(name);
		data.setEmail(email);		
		data.setDate(day);
		data.setPwd(pwd);
		data.setGen(gen);
		
		System.out.println("sql 확인: " + sql);
		db.insertData(conn, sql, data);
	}
	
	public void updateData(int no, String name, String email, String pwd, int gen) {
		sql = "update USER set 이름=?, 이메일=?, 비밀번호=?, 성별=? where 번호=?";
		DBTable data = new DBTable();
		
		data.setNo(no);
		data.setName(name);
		data.setEmail(email);	
		data.setPwd(pwd);
		data.setGen(gen);
		
		System.out.println("sql 확인: " + sql);
		db.updateData(conn, sql, data);
	}
	
	public void deleteData(int no) {
		sql = "update USER set 삭제=1 where 번호=" + no;
		System.out.println("sql 확인: " + sql);
		db.deleteData(conn, sql);
	}
	
	public List<DBTable> getData(){
		List<DBTable> list = new ArrayList<>();
		sql = "select * from USER where 삭제=0";
		list = db.getData(conn, sql);
		for(DBTable data : list) {
			System.out.println(data);
		}
		return list;
	}
	
	public DBTable getData(int no){
		List<DBTable> list = new ArrayList<>();
		sql = "select * from USER where (삭제=0) AND (번호=" + no + ")";
		list = db.getData(conn, sql);
		for(DBTable data : list) {
			System.out.println(data);
		}
		return list.get(0);
	}
}
