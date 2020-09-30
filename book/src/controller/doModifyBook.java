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
 * Servlet implementation class doModifyBook
 */
@WebServlet("/doModifyBook.do")
public class doModifyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doModifyBook() {
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
		
		String strBookId=request.getParameter("bookId");
		String bookTitle=request.getParameter("bookTitle");
		String author=request.getParameter("author");
		String strPlishId=request.getParameter("publishId");
		String strTypeId=request.getParameter("typeId");
		String strLanguageId=request.getParameter("languageId");
		String strBookrack=request.getParameter("bookrackId");
		String strInventory=request.getParameter("inventory");
//		String strLoan=request.getParameter("loan");
		if(strBookId==null||bookTitle==null||author==null||strPlishId==null||strTypeId==null||
		strLanguageId==null||strBookrack==null||strInventory==null) {
			out.println("<script language='javaScript'>");
			out.println("alert('未输入值');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showBook.do'");
			out.println("</script>");
			return;
		}
		int publishId=0,typeId=0,languageId=0,inventory=0,loan=0,bookrack=0,bookId=0;
		publishId=Integer.parseInt(strPlishId);
		typeId=Integer.parseInt(strTypeId);
		languageId=Integer.parseInt(strLanguageId);
		inventory=Integer.parseInt(strInventory);
//		loan=Integer.parseInt(strLoan);
		bookrack=Integer.parseInt(strBookrack);
		bookId=Integer.parseInt(strBookId);
		
		bookService bs=new bookService();
		book book=new book();
		
		book.setBookId(bookId);
		book.setTypeId(typeId);
		book.setLanguageId(languageId);
		book.setPublishId(publishId);
		book.setBookTitle(bookTitle);
		book.setAuthor(author);
		book.setBookrackId(bookrack);
		book.setInventory(inventory);
		book.setLoan(loan);
		
		boolean isSuccess=bs.modifyBook(book);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('修改成功');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
		}else{
			out.print("alert('修改失败');");
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
