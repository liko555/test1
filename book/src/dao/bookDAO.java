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
	//1��ҳ��ѯ
	public List<book> query(int bPageNo,int bPageSize){
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		
		if(conn!=null) {
			try {
				String sql="select * from book limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (bPageNo-1)*bPageSize);
				pstmt.setInt(2, bPageSize);
				
				//������ѯ���
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
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return null;
	}
	//��ѯͼ�������
	public int queryCount() {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book";
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//����ͼ������ѯ
	public book query(String bookTitle) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		try {
			//sql���
			String sql="select * from book where bookTitle=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookTitle);
			//������ѯ���
			rs = pstmt.executeQuery();
			//���ز�ѯ���result
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
		}finally {//�ر���Դ
			BaseDAO.close(conn, rs,pstmt);
		}
		return null;
	}
	
	//��ѯ����bookID
	public book query(int bookId) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		try {
			//sql���
			String sql="select * from book where bookId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			//������ѯ���
			rs = pstmt.executeQuery();
			//���ز�ѯ���result
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
		}finally {//�ر���Դ
			BaseDAO.close(conn, rs,pstmt);
		}
		return null;
	}
	
	//��ѯ���и���ͼ����⣬����list
	public List<book> queryTitle(String bookTitle,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book where bookTitle like ? limit ?,?";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bookTitle+"%");
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ�������������ѯ����������
	public int querytitleCount(String bookTitle) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where bookTitle=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bookTitle);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ���и���ͼ��id������list
	public List<book> queryBookId(int BookId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book where BookId=? limit ?,?";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, BookId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ���и���ͼ��author������list
	public List<book> queryAuthor(String author,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book where author like ? limit ?,?";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+author+"%");
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ��������author��ѯ����������
	public int queryAuthorCount(String author) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where author=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, author);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ���и���ͼ��author������list
	public List<book> queryPublish(int publishId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book where publishId=? limit ?,?";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, publishId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ��������publish��ѯ����������
	public int queryPublishNameCount(int publishId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where publishId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, publishId);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ���и���ͼ��languageid������list
	public List<book> querylanguage(int languageId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//��������
	conn=BaseDAO.getConn();
	if(conn==null) {
		return null;
	}
	//������ѯ������
	String sql = "select * from book where languageId=? limit ?,?";
	//3 ����statement  
	PreparedStatement pstmt = null;
	//4 ������ѯ���
	ResultSet rs = null;
	try {
		//����������
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, languageId);
		pstmt.setInt(2, (bPageNo-1)*bPageSize);
		pstmt.setInt(3, bPageSize);
		//ִ�з��ؽ�����
		rs=pstmt.executeQuery();
		//  ʹ�ý����
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
	}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ��������languageid��ѯ����������
	public int querylanguageCount(int languageId) {
		//��������
	conn=BaseDAO.getConn();
	//����statement  
	PreparedStatement pstmt = null;
	//������ѯ���
	ResultSet rs = null;
	if(conn!=null) {
		try {
			String sql="select count(*) from book where languageId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, languageId);
			//������ѯ���
			rs = pstmt.executeQuery();
			if(rs!=null&&rs.next()) {
				int count=rs.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ���и���ͼ��languageid������list
	public List<book> querybookrack(int bookrackId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book where bookrackId=? limit ?,?";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookrackId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ��������languageid��ѯ����������
	public int querybookrackCount(int bookrackId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where bookrackId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookrackId);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ���и���ͼ��typeid������list
	public List<book> queryType(int typeId,int bPageNo,int bPageSize){
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book where typeId=? limit ?,?";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			pstmt.setInt(2, (bPageNo-1)*bPageSize);
			pstmt.setInt(3, bPageSize);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ��������typeid��ѯ����������
	public int queryTypeNameCount(int typeId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where typeId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, typeId);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ���и���ͼ��id������list
	public List<book> queryAuthor(int BookId){
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book where BookId=?";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, BookId);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��ѯ�������������ѯ����������
	public int queryBookIdCount(int BookId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from book where BookId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, BookId);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//3����ѯ���е�ͼ������ʵ�����
	public List<book> query() {
		List<book> books=new ArrayList<book>();
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//������ѯ������
		String sql = "select * from book";
		//3 ����statement  
		PreparedStatement pstmt = null;
		//4 ������ѯ���
		ResultSet rs = null;
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			//  ʹ�ý����
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
		}finally {//�ر���Դ
			BaseDAO.close(conn,rs,pstmt);
		}
		return books;
	}
	//��
	public int insert(book book) {
		//2 �������� connection
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
		//3 ����statement  
		PreparedStatement pstmt = null;
		try {
			//3 sql���
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
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
		
	}
	
	//ɾ�� bookID
	public int del(int bookId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //���ݿ����
 		String sql = "delete from book where bookId="+bookId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	
	//ɾ������publishId
	public int delPublishId(int publishId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //���ݿ����
 		String sql = "delete from book where publishId="+publishId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	//ɾ������languageId
	public int delLanguageId(int languageId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //���ݿ����
 		String sql = "delete from book where languageId="+languageId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	//ɾ������typeid
	public int delTypeID(int typeId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //���ݿ����
 		String sql = "delete from book where typeId="+typeId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	
	//�޸�
	public int update(book book) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql���
	    String sql = "update book set typeId=?,languageId=?,publishId=?,bookTitle=?,"
	    		+ "author=?,bookrackId=?,inventory=?,loan=? where bookId=?";
	    //����statement  
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
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	//�޸Ľ�������ֶ�
	public int updateLoan(int bookId,int loan) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql���
	    String sql = "update book set loan=? where bookId=?";
	    //����statement  
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
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	public static void main(String[] args) throws SQLException, IOException {
		/*��ҳ��ѯ����*/
		/*bookDAO dao=new bookDAO();
		List<book> list=dao.query(1, 4);
		for(book book:list) {
			System.out.println(book.toString());
		}*/
		
		//��ѯ����
		/*bookDAO dao=new bookDAO();
		System.out.println(dao.queryCount());*/
		
		//������������ѯ
		/*bookDAO dao=new bookDAO();
		book book=dao.query("������Щ�¶�");
		if(book!=null) {
			System.out.println(book.toString());
		}*/
		
		//����ISDN��ѯ
		/*bookDAO dao=new bookDAO();
		book book=dao.query(1);
		if(book!=null) {
			System.out.println(book.toString());
		}*/
		
		//��ѯ����
		/*bookDAO dao=new bookDAO();
		List<book> list=dao.query();
		for(book book:list) {
			System.out.println(book.toString());
		}*/
		
		//��
		/*bookDAO dao=new bookDAO();
		book book=new book();
		book.setTypeId(9);
		book.setLanguageId(1);
		book.setPublishId(4);
		book.setBookTitle("��ҹ��");
		book.setAuthor("��Ұ����");
		book.setBookrackId(2);
		book.setInventory(1);
		book.setLoan(0);
		int a=dao.insert(book);
		System.out.println(a);*/
		
		//ɾ��
		/*bookDAO dao=new bookDAO();
		book book=new book();
		int a=dao.del(2);
		System.out.println(a);*/
		
		//�޸�
		/*bookDAO dao=new bookDAO();
		book book=new book();
		book.setTypeId(10);
		book.setLanguageId(1);
		book.setPublishId(4);
		book.setBookTitle("��ҹ��");
		book.setAuthor("��Ұ����");
		book.setBookrack("2");
		book.setInventory(1);
		book.setLoan(0);
		book.setISDN(3);
		int a=dao.update(book);
		System.out.println(a);*/
		
		//�޸Ľ��
		bookDAO dao=new bookDAO();
		int a=dao.updateLoan(1,3);
		System.out.println(a);
	}
		
}
