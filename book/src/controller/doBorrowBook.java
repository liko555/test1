package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.book;
import entity.record;
import service.bookService;
import service.recordService;
import service.userService;

/**
 * Servlet implementation class doBorrowBook
 */
@WebServlet("/doBorrowBook.do")
public class doBorrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doBorrowBook() {
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
		
		String StrBookId=request.getParameter("bookId");
		String userName=request.getParameter("userName");
//		System.out.println(userName);
		String strCount=request.getParameter("count");
		
		if(StrBookId==null) {
			System.out.println("bookId未接到值");
		}
		int bookId=Integer.parseInt(StrBookId);
		
		if(strCount==null) {
			System.out.println("count未接到值");
		}
		int count=Integer.parseInt(strCount);
		
		//通过用户名查询用户id
		userService us=new userService();
		int userId=us.getUserId(userName);
//		System.out.println(userId);
		//添加借阅记录
		recordService service=new recordService();
		record record=new record();
		record.setBookId(bookId);
		record.setUserId(userId);
		record.setCount(count);
		
		//修改图书的借出数量（本次借阅数量+以前借阅数量）
		bookService bs=new bookService();
		book book=bs.getBook(bookId);
		count=count+book.getLoan();
		if(count>book.getInventory()) {
			out.print("<script language='javaScript'>");
			out.print("alert('添加失败，该图书不可借阅');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/BorrowBook.do'");
			out.print("</script>");
//			return;
		}else {
			bs.modifyBookLoan(bookId,count);
			
			boolean isSuccess=service.addRecord(record);
			out.print("<script language='javaScript'>");
			if(isSuccess){
				out.print("alert('录入记录成功');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showBorrowBook.do'");
			}else{
				out.print("alert('添加失败,该用户或者图书不存在');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showBorrowBook.do'");
			}
			out.print("</script>");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
