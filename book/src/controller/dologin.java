package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.admin;
import entity.user;
import service.adminService;
import service.userService;

/**
 * Servlet implementation class dologin
 */
@WebServlet("/dologin.do")
public class dologin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dologin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�ύ�ͻ����ύ�Ĳ�����Ϣ
		//�����������ı���
		request.setCharacterEncoding("utf-8");
		//������Ӧ����ı���
		response.setContentType("text/html; charset=UTF-8");
		
		String uname=request.getParameter("uname");
		if(uname==null) {
			uname="";
		}
		
		String upwd=request.getParameter("upwd");
		if(upwd==null) {
			upwd="";
		}
		
		String type=request.getParameter("type");
		if(type==null) {
			type="";
		}
		
		HttpSession session=request.getSession();
		//�������out����
		PrintWriter out = response.getWriter();
		//��ȡservlet��������
		ServletContext context=this.getServletContext();
		//��ȡ��·��
		String path=context.getContextPath();
		
		if(type.equals("0")) {
			userService UService=new userService();
			user user=UService.login(uname, upwd);
			
			//ҳ����ת
			if(user!=null) {
				session.setAttribute("userObj", user);
				request.getRequestDispatcher("/user/userIndex.jsp").forward(request, response);
			}else {
				out.print("<script language='JavaScript'>");
				out.print("alert('�û��������벻��ȷ');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/login.do'");
				out.print("</script>");
			}
		}else if(type.equals("1")) {
			adminService AService=new adminService();
			admin admin=AService.login(uname, upwd);
			if(admin!=null) {
				session.setAttribute("adminObj", admin);
				request.getRequestDispatcher("/admin/adminIndex.jsp").forward(request, response);
			}else {
				out.print("<script language='JavaScript'>");
				out.print("alert('�û��������벻��ȷ');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/login.do'");
				out.print("</script>");
			}
		}else {
			out.println("<script language='JavaScript'>");
			out.println("alert('����˵�����ǻ�Ա���ǹ���Ա');");
			String loc="location.href='"+path+"/login.do';";
			out.println(loc);
			out.println("</script>");
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
