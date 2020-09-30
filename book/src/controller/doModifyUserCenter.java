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
 * Servlet implementation class doModifyUserCenter
 */
@WebServlet("/doModifyUserCenter.do")
public class doModifyUserCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doModifyUserCenter() {
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
		HttpSession session=request.getSession();
		//定义产生out对象
		PrintWriter out = response.getWriter();
		
		String strUserId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		String trueName=request.getParameter("trueName");
		String phone=request.getParameter("phone");
		
		String strUsernId=request.getParameter("userId");
		if(strUsernId==null) {
			System.out.println("userId未接到");
		}
		int userId=Integer.parseInt(strUsernId);
		
/*		System.out.println(userId);
		System.out.println(userName);
		System.out.println(userPwd);
		System.out.println(trueName);
		System.out.println(phone);*/
		userService service=new userService();
		user user=new user();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setPhone(phone);
		user.setTrueName(trueName);
		
		boolean isSuccess=service.modifyUser(user);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('修改成功');");
//			out.println("location.href='logout.do'");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/UserCenter.do?userId="+userId+"'");
			out.print("</script>");		
//			request.getRequestDispatcher("/logout.do").forward(request,response);
//			out.println("location.href='" + this.getServletContext().getContextPath() + "/user/userIndex.jsp?userId="+userId+"'");
		}else{
			out.print("alert('修改失败');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/UserCenter.do?userId="+userId+"'");		
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
