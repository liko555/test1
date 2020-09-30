package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.admin;
import service.adminService;

/**
 * Servlet implementation class doModifyAdminCenter
 */
@WebServlet("/doModifyAdminCenter.do")
public class doModifyAdminCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doModifyAdminCenter() {
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
		
		String strAdminId=request.getParameter("adminId");
		String adminName=request.getParameter("adminName");
		String adminPwd=request.getParameter("adminPwd");
		String trueName=request.getParameter("trueName");
		String phone=request.getParameter("phone");
		
		if(strAdminId==null) {
			System.out.println("adminId为空");
			request.getRequestDispatcher("/admin/AdminCenter.do").forward(request, response);
		}
		int adminId=Integer.parseInt(strAdminId);
		
		adminService service=new adminService();
		admin admin=new admin();
		admin.setAdminId(adminId);
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);
		admin.setPhone(phone);
		admin.setTrueName(trueName);
		
		boolean isSuccess=service.modifyAdmin(admin);
		out.print("<script language='javaScript'>");
		if(isSuccess){
			out.print("alert('修改成功');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/AdminCenter.do?adminId="+adminId+"'");
		}else{
			out.print("alert('修改失败');");
			out.println("location.href='" + this.getServletContext().getContextPath() + "/AdminCenter.do?adminId="+adminId+"'");
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
