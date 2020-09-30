package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.bookType;
import service.bookTypeService;

/**
 * Servlet implementation class doAddBookType
 */
@WebServlet("/doAddBookType.do")
public class doAddBookType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddBookType() {
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
		
		String typeName=request.getParameter("typeName");
		bookTypeService bt=new bookTypeService();
		bookType bookType=new bookType();
		
		bookType.setTypeName(typeName);
		boolean isSuccess=bt.addType(bookType);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('��ӳɹ�');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showBookType.do'");
		}else{
			out.print("alert('���ʧ��');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showBookType.do'");
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
