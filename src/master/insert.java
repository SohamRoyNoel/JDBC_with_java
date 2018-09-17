package master;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class insert {
	Connection cn = null;
	java.sql.Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String select = "select * from dept";
	String insertEn = "insert into dept values (?,?,?)"; 
	String deleteEn = "delete from dept where DEPTNO=?";
	String updateEn = "update dept set ADDRESS=?,NAME=? where DEPTNO=?";
	String joins = "select customer.NAME, customer.CITY, pay.PRICE from customer customer inner join pay pay on customer.ID=pay.CUSTOMER_ID";
	
	public void getdata() {
		try {
			connectionfactory con = new connectionfactory();
			cn = con.getCon();
			st = cn.createStatement();
			rs = st.executeQuery(select);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"=======>"+rs.getString(2)+"=======>"+rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertinto(){
		try {
			connectionfactory con = new connectionfactory();
			cn = con.getCon();
			ps = cn.prepareStatement(insertEn);
			ps.setInt(1, 13);
			ps.setString(2, "AAA");
			ps.setString(3, "Dura");
			ps.executeUpdate();
			cn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletefrom() {
		try {
			connectionfactory con = new connectionfactory();
			cn = con.getCon();
			ps = cn.prepareStatement(deleteEn);
			ps.setInt(1, 11);
			ps.executeQuery();
			cn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updatefrom() {
		try {
			connectionfactory con = new connectionfactory();
			cn = con.getCon();
			ps = cn.prepareStatement(updateEn);
			ps.setString(1, "Dubai");
			ps.setString(2, "DDD");
			ps.setInt(3, 10);
			ps.executeUpdate();
			cn.commit();
						
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public void findlike(String d) {
		try {
			String like = "select * from dept where ADDRESS like '"+d+"'";
			connectionfactory con = new connectionfactory();
			cn = con.getCon();
			st = cn.createStatement();
			rs = st.executeQuery(like);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"=======>"+rs.getString(2)+"=======>"+rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void join() {
		try {
			connectionfactory con = new connectionfactory();
			cn = con.getCon();
			st = cn.createStatement();
			rs = st.executeQuery(joins);
			while(rs.next()) {
				System.out.println(" Name : " + rs.getString(1)+ " CITY ; " + rs.getString(2)+ " PRICE : " + rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
