package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.user;
import service.userService;

/**
 * Servlet implementation class doModifyUser
 */
@WebServlet("/doModifyUser.do")
public class doModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doModifyUser() {
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
		HttpSession session=request.getSession();
		//�������out����
		PrintWriter out = response.getWriter();
		
		String strUserId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		String trueName=request.getParameter("trueName");
		String phone=request.getParameter("phone");
		if(strUserId==null) {
			System.out.println("usrIdδ�ӵ�ֵ");
		}
		int userId=Integer.parseInt(strUserId);
		
		userService service=new userService();
		user user=new user();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setTrueName(trueName);
		user.setPhone(phone);
		
		boolean isSuccess=service.modifyUser(user);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('�޸ĳɹ�');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showManageUsers.do'");
		}else{
			out.print("alert('�޸�ʧ��');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showManageUsers.do'");
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
