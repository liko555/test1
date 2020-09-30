package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.user;
import service.userService;

/**
 * Servlet implementation class doselectUser
 */
@WebServlet("/doselectUser.do")
public class doselectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doselectUser() {
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
		HttpSession session= request.getSession();
		String condition=request.getParameter("condition");
		
		//当前页码
		int btPageNo=1;
		String strPageNo = request.getParameter("btPageNo");
		if(strPageNo !=null) {//通过单击“下一页/上一页”传递了参数，就能接到，不为null
			btPageNo=Integer.parseInt(strPageNo);
		}
		//一页显示多少行
		int btPageSize=7;
		String strPageSize=request.getParameter("btPageSize");
		if(strPageSize!=null) {
				btPageSize=Integer.parseInt(strPageSize);
		}else {
			Object objPageSize=session.getAttribute("btPageSize");
			if(objPageSize!=null) {
				btPageSize=((Integer)objPageSize).intValue();
			}
		}
		//总页码
		int btPageCount=1;
		
		userService service=new userService();
		List<user> list=service.getUser(condition);
		
		session.setAttribute("pageBookType", list);
		request.setAttribute("btPageNo", btPageNo);
		request.setAttribute("btPageCount",btPageCount);
		session.setAttribute("btPageSize",btPageSize);
		request.getRequestDispatcher("/admin/showManageUsers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
