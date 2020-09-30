package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.book;
import service.bookService;

/**
 * Servlet implementation class doAddBook
 */
@WebServlet("/doAddBook.do")
public class doAddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求对象的编码
		request.setCharacterEncoding("utf-8");
		//设置响应对象的编码
		response.setContentType("text/html; charset=UTF-8");
		//定义产生out对象
		PrintWriter out = response.getWriter();
		
		String bookTitle=request.getParameter("bookTitle");
		String author=request.getParameter("author");
		String strPlishId=request.getParameter("publishId");
		String strTypeId=request.getParameter("typeId");
		String strLanguageId=request.getParameter("languageId");
		String strBookrack=request.getParameter("bookrackId");
		String strInventory=request.getParameter("inventory");
//		String strLoan=request.getParameter("loan");
		if(bookTitle==null||author==null||strPlishId==null||strTypeId==null||
		strLanguageId==null||strBookrack==null||strInventory==null) {
			out.println("<script language='javaScript'>");
			out.println("alert('未输入值');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showBook.do'");
			out.println("</script>");
			return;
		}
		int publishId=0,typeId=0,languageId=0,inventory=0,loan=0,bookrack=0;
		publishId=Integer.parseInt(strPlishId);
		typeId=Integer.parseInt(strTypeId);
		languageId=Integer.parseInt(strLanguageId);
		inventory=Integer.parseInt(strInventory);
//		loan=Integer.parseInt(strLoan);
		bookrack=Integer.parseInt(strBookrack);
		
		bookService bs=new bookService();
		book book=new book();
		
		book.setTypeId(typeId);
		book.setLanguageId(languageId);
		book.setPublishId(publishId);
		book.setBookTitle(bookTitle);
		book.setAuthor(author);
		book.setBookrackId(bookrack);
		book.setInventory(inventory);
		book.setLoan(loan);
		
		boolean isSuccess=bs.addBook(book);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('添加成功');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
		}else{
			out.print("alert('添加失败');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
		}
		out.print("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
