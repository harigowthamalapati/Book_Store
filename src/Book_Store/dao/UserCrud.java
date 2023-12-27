package Book_Store.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Book_Store.dto.User;

public class UserCrud {
	
	public void insertUser(User user)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store","root", "root");
			PreparedStatement cs = con.prepareStatement("insert into user values(?,?,?)");
			cs.setInt(1, user.getId());
			cs.setString(2, user.getName());
			cs.setDouble(3, user.getWallet());
			cs.execute();
			cs.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("please check the Driver fully Qualified name");
		} catch (SQLException e) {
			System.out.println(" SQL Exception");
			e.printStackTrace();
		}	
		System.out.println(" USer Inseted Sucessfully....");
		
	}
	public void updateUser(String name ,int id ) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root","root");
		PreparedStatement st = con.prepareStatement("upadate  user set name=? where id=? ");
		st.setInt(2, id);
		st.setString(1, name);
		int res = st.executeUpdate();
		st.close();
		con.close();
		System.out.println(res+ " Records are updsated Sucessfully");
		
	}
	

}
