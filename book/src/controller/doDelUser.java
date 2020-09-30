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
		//设置请求对象的编码
		request.setCharacterEncoding("utf-8");
		//设置响应对象的编码
		response.setContentType("text/html; charset=UTF-8");
		//定义产生out对象
		PrintWriter out = response.getWriter();
		
		String strUserId=request.getParameter("userId");
		int userId=0;
		if(strUserId==null) {
			System.out.println("strUserId未接到");
		}
		userId=Integer.parseInt(strUserId);
		
		userService service=new userService();
		boolean isSuccess =service.removeUser(userId);
		//根据删除结果，提示相应的内容
		out.println("<script type='text/javascript'>");
		if(isSuccess){
			out.println("alert('已成功删除该用户');");
		}else{
			out.println("alert('删除该用户失败');");
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
