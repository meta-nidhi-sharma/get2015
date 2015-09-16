package assignment_1_jdbc;
/**
* @author Nidhi Sharma
* Date: 16 September,2015
* Description :  Main Class with all function to execute queries
*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Connection;

public class Main 
{
	//Main function
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);			//Scanner class
		do
		{
			//Opertaions allowed
			System.out.println("1.To Fetch all the books published by an author");
			System.out.println("2.To isue a book");
			System.out.println("3.To delete all those books which were not issued in last 1 year");
			System.out.println("4.To Exit");
			int choice = sc.nextInt();   				//Hold user's choice of operation
			switch(choice)
			{
				case 1:
					executeQueryUsingPreparedStatement(choice);
					break;
				case 2:
					executeQueryUsingPreparedStatement(choice);
					break;
				case 3:
					String query3 = "SET SQL_SAFE_UPDATES=0;";
					executeQueryUsingStatement(query3);
					break;
				//To Exit
				case 4:
					sc.close();
					System.exit(0);
					break;
				//Deafult Case
				default:
					System.out.println("Invalid option");
					break;
			}
		}
		while(true);
	}
	/***************************************************
	 * To get index for prepared statement
	 ***************************************************/
	private static String getIndex()
	{
		Scanner sc = new Scanner(System.in);
		String index = sc.next();			//holds index
		return index;
		
	}
	/***************************************************
	 * To get query for choice 1
	****************************************************/
	private static String getQuery1()
	{
		String query = "select title_name from authors INNER JOIN title_author ON title_author.author_id=authors.author_id "
				+ "INNER JOIN titles ON titles.title_id=title_author.title_id WHERE author_name=?;";
		return query;
	}
	/***************************************************
	 * To get query for choice 2
	 **************************************************/
	private static String getQuery2()
	{
		String query = "SELECT status FROM titles AS t INNER JOIN books AS b ON b.title_id=t.title_id WHERE title_name=?;";
		return query;
	}
	
	/*************************************************************************
	 *  If choice =1, Fetch all the books published by author,
	 *	given the name of the author
	 *	Else if choice =2,Given the name of the book, to be issued by an
	 *	existing member.Return flag to indicate whether the book has been
	 *  issued or not
	 * @param choice
	 *************************************************************************/
	@SuppressWarnings("resource")
	private static void executeQueryUsingPreparedStatement(int choice)
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		ResultSet rs = null;				//To hold resultset
		PreparedStatement ps = null;			//To hold prepared statement
		ConnectionUtil conUtil = new ConnectionUtil();			//Creating object of ConnectionUtil
		con = (Connection) conUtil.getConnection();			//To hold connection
		String query = (choice==1) ? getQuery1():getQuery2();		//getting required query
		try 
		{
			ps = con.prepareStatement(query);
			
			if(choice==1)
			{
				System.out.println("Enter author_name");
				/* set variable in prepared statement */
				ps.setString(1, getIndex());
				rs = ps.executeQuery();
				while (rs.next())
				{
					Titles t = new Titles();			//Object of titles class
					t.setTitle_name(rs.getString("title_name"));
					System.out.println(t);
				}
			}
			else
			{
				System.out.println("Enter book_title");
				/* set variable in prepared statement */
				ps.setString(1, getIndex());
				
				// ps.setString(1,name);
				rs = ps.executeQuery();
				while (rs.next())
				{
					Books b = new Books();			//Object of books class
					b.setStatus(rs.getString("status"));
					System.out.println(b.getStatus());
					
					if(b.getStatus().equalsIgnoreCase("NOT_Issued"))
					{
						System.out.println("Enter member_id");
						int m_id = sc.nextInt();
						String q = "SELECT member_id from members where member_id "
								+ "NOT IN (SELECT member_id FROM book_issue) AND member_id=?;";
						ps = con.prepareStatement(q);
						/* set variable in prepared statement */
						ps.setInt(1, m_id);
						rs  = ps.executeQuery();
						if(rs.next())
						{
							book_issue bi = new book_issue();
							bi.setMember_id(m_id);
							
							System.out.println("Enter accession_no of this book");
							int a_no = sc.nextInt(); 
							bi.setAccession_no(a_no);
							
							ps = con.prepareStatement("INSERT INTO book_issue (accession_no, member_id) VALUES (?, ?);");
							/* set variable in prepared statement */
							ps.setInt(1,bi.getAccession_no());
							ps.setInt(2,bi.getMember_id());
							int flag=ps.executeUpdate();
							
							if(flag==1)
								System.out.println("Flag = "+flag+ " Book with accession_no "+ bi.getAccession_no()+" Issued to "+bi.getMember_id());
							else 
								System.out.println("Flag = "+flag+ " Book not Issued");
						}
						else
							System.out.println("You have already issued a book :\n please return previous book first\n");
					}
					else
						System.out.println("Book is issued to someone else");
				}
			}	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null)
				{
					con.close();
				}
				if (ps != null)
				{
					ps.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	/**************************************************************
	 * Delete all those books which were not issued in last 1 year 
	 * and return the number of books deleted
	 * @param query
	 **************************************************************/
	private static void executeQueryUsingStatement(String query) 
	{
		Connection con = null;				//To hold connection
		ResultSet rs = null;				//To hold resultset
		Statement stmt = null;				//To hold statement
		ConnectionUtil conUtil = new ConnectionUtil();
		con = (Connection) conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			String query1 = "DELETE FROM books WHERE books.accession_no NOT IN (SELECT bi.accession_no FROM book_issue AS bi WHERE bi.issue_date BETWEEN DATE_SUB(NOW(), INTERVAL 365 DAY) AND NOW());";
			int b = stmt.executeUpdate(query1);
			System.out.println(b +" number of rows deleted");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			// close connection 
			try 
			{
				if (con != null)
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
				if (rs != null) 
				{
					rs.close();
				}

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
