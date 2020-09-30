package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.book;


public class bookDAO {
	private static Connection conn=null;
	//1分页查询
	public List<book> query(int bPageNo,int bPageSize){
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		
		if(conn!=null) {
			try {
				String sql="select * from book limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (bPageNo-1)*bPageSize);
				pstmt.setInt(2, bPageSize);
				
				//创建查询语句
				rs = pstmt.executeQuery();
				
				if(rs!=null) {
					List<book> list=new ArrayList<book>();
					while(rs.next()) {
						book book =new book();
						book.setBookId(rs.getInt("bookId"));
						book.setTypeId(rs.getInt("typeId"));
						book.setBookTitle(rs.getString("bookTitle"));
						book.setLanguageId(rs.getInt("languageId"));
						book.setAuthor(rs.getString("author"));
						book.setPublishId(rs.getInt("publishId"));
						book.setBookrackId(rs.getInt("bookrackId"));
						book.setInventory(rs.getInt("inventory"));
						book.setLoan(rs.getInt("loan"));
						list.add(book);
					}
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return null;
	}
	//查询图书的数量
	public int queryCount() {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book";
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//按照图书名查询
	public book query(String bookTitle) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		try {
			//sql语句
			String sql="select * from book where bookTitle=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookTitle);
			//创建查询语句
			rs = pstmt.executeQuery();
			//返回查询结果result
			if(rs!=null&&rs.next()) {
				book book=new book();
				book.setBookId(rs.getInt("bookId"));
				book.setTypeId(rs.getInt("typeId"));
				book.setBookTitle(rs.getString("bookTitle"));
				book.setLanguageId(rs.getInt("languageId"));
				book.setAuthor(rs.getString("author"));
				book.setPublishId(rs.getInt("publishId"));
				book.setBookrackId(rs.getInt("bookrackId"));
				book.setInventory(rs.getInt("inventory"));
				book.setLoan(rs.getInt("loan"));
				return book;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, rs,pstmt);
		}
		return null;
	}
	
	//查询根据bookID
	public book query(int bookId) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		try {
			//sql语句
			String sql="select * from book where bookId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			//创建查询语句
			rs = pstmt.executeQuery();
			//返回查询结果result
			if(rs!=null&&rs.next()) {
				book book=new book();
				book.setBookId(rs.getInt("bookId"));
				book.setTypeId(rs.getInt("typeId"));
				book.setBookTitle(rs.getString("bookTitle"));
				book.setLanguageId(rs.getInt("languageId"));
				book.setAuthor(rs.getString("author"));
				book.setPublishId(rs.getInt("publishId"));
				book.setBookrackId(rs.getInt("bookrackId"));
				book.setInventory(rs.getInt("inventory"));
				book.setLoan(rs.getInt("loan"));
				return book;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, rs,pstmt);
		}
		return null;
	}
	
	//查询所有根据图书标题，返回list
	public List<book> queryTitle(String bookTitle,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book where bookTitle like ? limit ?,?";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bookTitle+"%");
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询根据漫画标题查询漫画的数量
	public int querytitleCount(String bookTitle) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where bookTitle=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bookTitle);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询所有根据图书id，返回list
	public List<book> queryBookId(int BookId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book where BookId=? limit ?,?";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, BookId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询所有根据图书author，返回list
	public List<book> queryAuthor(String author,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book where author like ? limit ?,?";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+author+"%");
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询根据漫画author查询漫画的数量
	public int queryAuthorCount(String author) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where author=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, author);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询所有根据图书author，返回list
	public List<book> queryPublish(int publishId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book where publishId=? limit ?,?";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, publishId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询根据漫画publish查询漫画的数量
	public int queryPublishNameCount(int publishId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where publishId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, publishId);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询所有根据图书languageid，返回list
	public List<book> querylanguage(int languageId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//创建连接
	conn=BaseDAO.getConn();
	if(conn==null) {
		return null;
	}
	//创建查询语句对象
	String sql = "select * from book where languageId=? limit ?,?";
	//3 创建statement  
	PreparedStatement pstmt = null;
	//4 创建查询语句
	ResultSet rs = null;
	try {
		//创建语句对象
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, languageId);
		pstmt.setInt(2, (bPageNo-1)*bPageSize);
		pstmt.setInt(3, bPageSize);
		//执行返回结果语句
		rs=pstmt.executeQuery();
		//  使用结果集
		if(rs!=null) {
			while(rs.next()){
				book book=new book();
				book.setBookId(rs.getInt("bookId"));
				book.setTypeId(rs.getInt("typeId"));
				book.setBookTitle(rs.getString("bookTitle"));
				book.setLanguageId(rs.getInt("languageId"));
				book.setAuthor(rs.getString("author"));
				book.setPublishId(rs.getInt("publishId"));
				book.setBookrackId(rs.getInt("bookrackId"));
				book.setInventory(rs.getInt("inventory"));
				book.setLoan(rs.getInt("loan"));
				books.add(book);
			}
			return books;	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询根据漫画languageid查询漫画的数量
	public int querylanguageCount(int languageId) {
		//创建连接
	conn=BaseDAO.getConn();
	//创建statement  
	PreparedStatement pstmt = null;
	//创建查询语句
	ResultSet rs = null;
	if(conn!=null) {
		try {
			String sql="select count(*) from book where languageId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, languageId);
			//创建查询语句
			rs = pstmt.executeQuery();
			if(rs!=null&&rs.next()) {
				int count=rs.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询所有根据图书languageid，返回list
	public List<book> querybookrack(int bookrackId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book where bookrackId=? limit ?,?";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookrackId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询根据漫画languageid查询漫画的数量
	public int querybookrackCount(int bookrackId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where bookrackId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookrackId);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询所有根据图书typeid，返回list
	public List<book> queryType(int typeId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book where typeId=? limit ?,?";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询根据漫画typeid查询漫画的数量
	public int queryTypeNameCount(int typeId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where typeId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, typeId);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询所有根据图书id，返回list
	public List<book> queryAuthor(int BookId){
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book where BookId=?";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, BookId);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//查询根据漫画标题查询漫画的数量
	public int queryBookIdCount(int BookId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where BookId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, BookId);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//3、查询所有的图书类型实体对象
	public List<book> query() {
		List<book> books=new ArrayList<book>();
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建查询语句对象
		String sql = "select * from book";
		//3 创建statement  
		PreparedStatement pstmt = null;
		//4 创建查询语句
		ResultSet rs = null;
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			//执行返回结果语句
			rs=pstmt.executeQuery();
			//  使用结果集
			if(rs!=null) {
				while(rs.next()){
					book book=new book();
					book.setBookId(rs.getInt("bookId"));
					book.setTypeId(rs.getInt("typeId"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setLanguageId(rs.getInt("languageId"));
					book.setAuthor(rs.getString("author"));
					book.setPublishId(rs.getInt("publishId"));
					book.setBookrackId(rs.getInt("bookrackId"));
					book.setInventory(rs.getInt("inventory"));
					book.setLoan(rs.getInt("loan"));
					books.add(book);
				}
				return books;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//增
	public int insert(book book) {
		//2 创建连接 connection
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
		//3 创建statement  
		PreparedStatement pstmt = null;
		try {
			//3 sql语句
			String sql="insert into book(typeId,languageId,publishId,bookTitle,author,bookrackId,inventory,loan)"
					+ "values(?,?,?,?,?,?,?,?); ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getTypeId());
			pstmt.setInt(2, book.getLanguageId());
			pstmt.setInt(3, book.getPublishId());
			pstmt.setString(4, book.getBookTitle());
			pstmt.setString(5, book.getAuthor());
			pstmt.setInt(6, book.getBookrackId());
			pstmt.setInt(7, book.getInventory());
			pstmt.setInt(8, book.getLoan());
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return 0;
		
	}
	
	//删除 bookID
	public int del(int bookId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //数据库语句
 		String sql = "delete from book where bookId="+bookId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	
	//删除根据publishId
	public int delPublishId(int publishId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //数据库语句
 		String sql = "delete from book where publishId="+publishId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	//删除根据languageId
	public int delLanguageId(int languageId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //数据库语句
 		String sql = "delete from book where languageId="+languageId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	//删除根据typeid
	public int delTypeID(int typeId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //数据库语句
 		String sql = "delete from book where typeId="+typeId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	
	//修改
	public int update(book book) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql语句
	    String sql = "update book set typeId=?,languageId=?,publishId=?,bookTitle=?,"
	    		+ "author=?,bookrackId=?,inventory=?,loan=? where bookId=?";
	    //创建statement  
	  	PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setInt(1, book.getTypeId());
			pstmt.setInt(2, book.getLanguageId());
			pstmt.setInt(3, book.getPublishId());
			pstmt.setString(4, book.getBookTitle());
			pstmt.setString(5, book.getAuthor());
			pstmt.setInt(6, book.getBookrackId());
			pstmt.setInt(7, book.getInventory());
			pstmt.setInt(8, book.getLoan());
			pstmt.setInt(9, book.getBookId());
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	//修改借出数量字段
	public int updateLoan(int bookId,int loan) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql语句
	    String sql = "update book set loan=? where bookId=?";
	    //创建statement  
	  	PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);	  
			pstmt.setInt(1, loan);
	        pstmt.setInt(2, bookId);
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	public static void main(String[] args) throws SQLException, IOException {
		/*分页查询测试*/
		/*bookDAO dao=new bookDAO();
		List<book> list=dao.query(1, 4);
		for(book book:list) {
			System.out.println(book.toString());
		}*/
		
		//查询条数
		/*bookDAO dao=new bookDAO();
		System.out.println(dao.queryCount());*/
		
		//按照漫画名查询
		/*bookDAO dao=new bookDAO();
		book book=dao.query("明朝那些事儿");
		if(book!=null) {
			System.out.println(book.toString());
		}*/
		
		//按照ISDN查询
		/*bookDAO dao=new bookDAO();
		book book=dao.query(1);
		if(book!=null) {
			System.out.println(book.toString());
		}*/
		
		//查询所有
		/*bookDAO dao=new bookDAO();
		List<book> list=dao.query();
		for(book book:list) {
			System.out.println(book.toString());
		}*/
		
		//增
		/*bookDAO dao=new bookDAO();
		book book=new book();
		book.setTypeId(9);
		book.setLanguageId(1);
		book.setPublishId(4);
		book.setBookTitle("白夜行");
		book.setAuthor("东野圭吾");
		book.setBookrackId(2);
		book.setInventory(1);
		book.setLoan(0);
		int a=dao.insert(book);
		System.out.println(a);*/
		
		//删除
		/*bookDAO dao=new bookDAO();
		book book=new book();
		int a=dao.del(2);
		System.out.println(a);*/
		
		//修改
		/*bookDAO dao=new bookDAO();
		book book=new book();
		book.setTypeId(10);
		book.setLanguageId(1);
		book.setPublishId(4);
		book.setBookTitle("白夜行");
		book.setAuthor("东野圭吾");
		book.setBookrack("2");
		book.setInventory(1);
		book.setLoan(0);
		book.setISDN(3);
		int a=dao.update(book);
		System.out.println(a);*/
		
		//修改借出
		bookDAO dao=new bookDAO();
		int a=dao.updateLoan(1,3);
		System.out.println(a);
	}
		
}
