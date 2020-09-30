package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.userService;

/**
 * Servlet implementation class doDelUser
 */
@WebServlet("/doDelUser.do")
public class doDelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDelUser() {
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
		
		String strUserId=request.getParameter("userId");
		int userId=0;
		if(strUserId==null) {
			System.out.println("strUserIdδ�ӵ�");
		}
		userId=Integer.parseInt(strUserId);
		
		userService service=new userService();
		boolean isSuccess =service.removeUser(userId);
		//����ɾ���������ʾ��Ӧ������
		out.println("<script type='text/javascript'>");
		if(isSuccess){
			out.println("alert('�ѳɹ�ɾ�����û�');");
		}else{
			out.println("alert('ɾ�����û�ʧ��');");
		}
		out.println("location.href='" + this.getServletContext().getContextPath() + "/showManageUsers.do'");
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
