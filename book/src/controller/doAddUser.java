package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.user;
import service.userService;

/**
 * Servlet implementation class doAddUser
 */
@WebServlet("/doAddUser.do")
public class doAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddUser() {
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
		
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		String trueName=request.getParameter("trueName");
		String phone=request.getParameter("phone");
		
		userService service=new userService();
		user user=new user();
		
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setTrueName(trueName);
		user.setPhone(phone);
		
		boolean isSuccess=service.addUser(user);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('添加成功');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/showManageUsers.do'");
		}else{
			out.print("alert('添加失败');");
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
