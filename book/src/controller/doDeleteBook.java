package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.bookService;

/**
 * Servlet implementation class doDeleteBook
 */
@WebServlet("/doDeleteBook.do")
public class doDeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDeleteBook() {
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
		String strBookId=request.getParameter("bookId");
		int bookId=0;
		if(strBookId==null) {
			request.getRequestDispatcher("/showbook.do").forward(request, response);
			return;
		}
		bookId=Integer.parseInt(strBookId);
		
		bookService bs=new bookService();
		boolean isSuccess =bs.removeBook(bookId);
		//����ɾ���������ʾ��Ӧ������
		out.println("<script type='text/javascript'>");
		if(isSuccess){
			out.println("alert('�ѳɹ�ɾ����ͼ��');");
		}else{
			out.println("alert('ɾ����ͼ��ʧ��');");
		}
		out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
		out.println("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
