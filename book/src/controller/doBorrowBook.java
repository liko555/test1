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
		//�����������ı���
		request.setCharacterEncoding("utf-8");
		//������Ӧ����ı���
		response.setContentType("text/html; charset=UTF-8");
		//�������out����
		PrintWriter out = response.getWriter();
		
		String StrBookId=request.getParameter("bookId");
		String userName=request.getParameter("userName");
//		System.out.println(userName);
		String strCount=request.getParameter("count");
		
		if(StrBookId==null) {
			System.out.println("bookIdδ�ӵ�ֵ");
		}
		int bookId=Integer.parseInt(StrBookId);
		
		if(strCount==null) {
			System.out.println("countδ�ӵ�ֵ");
		}
		int count=Integer.parseInt(strCount);
		
		//ͨ���û�����ѯ�û�id
		userService us=new userService();
		int userId=us.getUserId(userName);
//		System.out.println(userId);
		//��ӽ��ļ�¼
		recordService service=new recordService();
		record record=new record();
		record.setBookId(bookId);
		record.setUserId(userId);
		record.setCount(count);
		
		//�޸�ͼ��Ľ�����������ν�������+��ǰ����������
		bookService bs=new bookService();
		book book=bs.getBook(bookId);
		count=count+book.getLoan();
		if(count>book.getInventory()) {
			out.print("<script language='javaScript'>");
			out.print("alert('���ʧ�ܣ���ͼ�鲻�ɽ���');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/BorrowBook.do'");
			out.print("</script>");
//			return;
		}else {
			bs.modifyBookLoan(bookId,count);
			
			boolean isSuccess=service.addRecord(record);
			out.print("<script language='javaScript'>");
			if(isSuccess){
				out.print("alert('¼���¼�ɹ�');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showBorrowBook.do'");
			}else{
				out.print("alert('���ʧ��,���û�����ͼ�鲻����');");
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
