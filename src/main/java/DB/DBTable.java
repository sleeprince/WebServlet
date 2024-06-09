package DB;

public class DBTable {
	
	private int no;
	private String name;
	private String email;
	private String date;
	private String pwd;
	private int gen;
	private boolean del;
	public DBTable() {
		this.del = false;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getGen() {
		return gen;
	}
	public void setGen(int gen) {
		this.gen = gen;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "DBTable [no=" + no + ", name=" + name + ", email=" + email + ", date=" + date + ", pwd=" + pwd
				+ ", gen=" + gen + ", del=" + del + "]";
	}
	
}
