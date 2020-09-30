package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.record;
import service.recordService;

/**
 * Servlet implementation class showBorrowBook
 */
@WebServlet("/UserShowBorrowBook.do")
public class UserShowBorrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserShowBorrowBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session= request.getSession();
		
		//当前页码
		int bPageNo=1;
		String strPageNo = request.getParameter("bPageNo");
		if(strPageNo !=null) {//通过单击“下一页/上一页”传递了参数，就能接到，不为null
			bPageNo=Integer.parseInt(strPageNo);
		}
		
		//一页显示多少行
		int bPageSize=7;
		String strPageSize=request.getParameter("bPageSize");
		if(strPageSize!=null) {
			bPageSize=Integer.parseInt(strPageSize);
		}else {
			Object objPageSize=session.getAttribute("bPageSize");
			if(objPageSize!=null) {
				bPageSize=((Integer)objPageSize).intValue();
			}
		}
		//总页码
		int bPageCount=1;
		
		String strUserId=request.getParameter("userId");
		if(strUserId==null) {
			System.out.println("strUserId未接到");
			request.getRequestDispatcher("/UserSelBook.do").forward(request, response);
		}
		int userId=Integer.parseInt(strUserId);
		
		recordService service=new recordService();
		List<record> list=service.getUserId(userId, bPageNo, bPageSize);
//		System.out.println(list);
		int count=service.getUserIdLine(userId);
//		System.out.println(count);
		if(count%bPageSize==0) {
			bPageCount=count/bPageSize;
		}else {
			bPageCount=count/bPageSize+1;
		}
		
		request.setAttribute("userId", userId);
		session.setAttribute("pageRecord",list);
		request.setAttribute("bPageNo", bPageNo);
		request.setAttribute("bPageCount",bPageCount);
		session.setAttribute("bcPageSize",bPageSize);
		request.getRequestDispatcher("/user/showBorrowBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
