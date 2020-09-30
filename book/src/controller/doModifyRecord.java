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
import service.recordService;

/**
 * Servlet implementation class doModifyRecord
 */
@WebServlet("/doModifyRecord.do")
public class doModifyRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doModifyRecord() {
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
		
		String strRecordId=request.getParameter("recordId");
		if(strRecordId==null) {
			System.out.println("recordIdδ�ӵ�ֵ");
		}
		int recordId=Integer.parseInt(strRecordId);
		
		String strBookId=request.getParameter("bookId");
		if(strBookId==null) {
			System.out.println("bookIdδ�ӵ�ֵ");
		}
		int bookId=Integer.parseInt(strBookId);
		
		String strCount=request.getParameter("count");
		if(strCount==null) {
			System.out.println("countδ�ӵ�");
		}
		int count=Integer.parseInt(strCount);
		
		recordService service=new recordService();
		bookService bs=new bookService();
		book book=bs.getBook(bookId);
		count=book.getLoan()-count;
		bs.modifyBookLoan(bookId,count);
		
		boolean isSuccess=service.updateTime(recordId);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('�黹�ɹ�');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showBorrowBook.do'");
		}else{
			out.print("alert('�黹ʧ��');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showBorrowBook.do'");
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
