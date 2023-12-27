package Book_Store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import Book_Store.dto.Book;

public class BookCrud {

//	public void createTable() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?createDatabaseIfNotExist=true", "root","root");
//		Statement st = con.createStatement();
//		st.execute("create table IF NOT EXIST book (id int primary key,"
//		+" name varchar(45) not null,author varchar(45),"
//				+"price double, language varchar(45))");
//		con.close();
//	}
	public void deleteBook(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?user=root&password=root");
		PreparedStatement s = con.prepareStatement("delete from book where id=?");
		s.setInt(1, id);
		int res = s.executeUpdate();
		s.close();
		con.close();
		System.out.println(res + " Records Deletion sucessful...");

	}

	public void insertBook(Book book) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "root");
		PreparedStatement st = con.prepareStatement("insert into book values(?,?,?,?,?)");
		st.setInt(1, book.getId());
		st.setString(2, book.getName());
		st.setString(3, book.getAuthor());
		st.setDouble(4, book.getPrice());
		st.setString(5, book.getLanguage());
		st.execute();
		st.close();
		con.close();
		System.out.println(" Book inserted Sucessfully..");
	}

	public void updateBook(String name, int id) throws Throwable {
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?user=root&password=root");
		PreparedStatement st = con.prepareStatement("update book set name=? where id=?");
		st.setString(1, name);
		st.setInt(2, id);
		int res = st.executeUpdate();
		st.close();
		con.close();
		System.out.println(res + " Records are updated sucessfully...");

	}

	public void display() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from book");
		System.out.println(" id     Name       Author      Price     Language");
		while (rs.next()) {
			System.out.println("----------------------------------------------------------");
			System.out.print(rs.getInt(1) + "      ");
			System.out.print(rs.getString(2) + "     ");
			System.out.print(rs.getString(3) + "     ");
			System.out.print(rs.getDouble(4) + "     ");
			System.out.print(rs.getString(5) + "     ");
			System.out.println();

		}
		rs.close();
		con.close();
		st.close();
	}

	public void buyingABook(int id, int book_id) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "root");
		PreparedStatement st = con.prepareStatement("select wallet from user where id=?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			double wallet = rs.getDouble("wallet");
			double bookPrice = fetchBookPrice(book_id);
			if (wallet >= bookPrice) {
				double balaence = wallet - bookPrice;
				PreparedStatement ps = con.prepareStatement("update user set wallet=? where id=?");
				ps.setDouble(1, balaence);
				ps.setInt(2, id);
				ps.executeUpdate();
				System.out.println("Purchase sucessful wallet balance : " + balaence);

			} else {
				System.out.println(" Insufficient balance ");
			}
		} else {
			System.out.println("User not found");
		}
		rs.close();
		st.close();
		con.close();
	}
	public double fetchBookPrice( int id) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "root");
		PreparedStatement st = con.prepareStatement("select price from Book where id=?");
		st.setInt(1, id);
		ResultSet r = st.executeQuery();
		if(r.next()) {
			return r.getDouble("price");
		}
		return 0;
		
	}

}
