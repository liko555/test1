package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.record;
import service.bookService;
import service.recordService;

/**
 * Servlet implementation class UserDoSelRecord
 */
@WebServlet("/UserDoSelRecord.do")
public class UserDoSelRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDoSelRecord() {
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
		//获取servlet的上下文
		ServletContext context=this.getServletContext();
		//获取根路径
		String path=context.getContextPath();
		HttpSession session=request.getSession();
		//定义产生out对象
		PrintWriter out = response.getWriter();
		
		String strUserId=request.getParameter("userId");
		if(strUserId==null) {
			System.out.println("strUserId未接到");
			request.getRequestDispatcher("/UserSelBook.do").forward(request, response);
		}
		int userId=Integer.parseInt(strUserId);
		
		String sel=request.getParameter("sel");
		if(sel==null) {
			System.out.println("sel未接到");
			sel="0";
		}
		
		String condition=request.getParameter("condition");
//		System.out.println("condition"+condition);
		if(condition==null) {
			System.out.println("condition未接到值");
		}
		int IntCondition=0;
		
		recordService service=new recordService();
		record record=new record();
		
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
		int count=1;
		
		List<record> list=new ArrayList<record>();
		if(sel.equals("0")) {
			list=service.getUserId(userId, bPageNo, bPageSize);
			count=service.getUserIdLine(userId);
		}else if(sel.equals("1")) {
			list=service.getUserNotTime(userId, bPageNo, bPageSize);
//			System.out.println("list"+list);
			count=service.getUserNotTimeLine(userId);
		}else if(sel.equals("2")) {
			list=service.getUserHavaTime(userId, bPageNo, bPageSize);
			count=service.getUserHavaTimeLine(userId);
		}else if(sel.equals("3")) {
			int bookId=Integer.parseInt(condition);
			list=service.getUserBookId(bookId, userId, bPageNo, bPageSize);
			count=service.getUserBookIdLine(bookId, userId);
		}else if(sel.equals("4")) {
			bookService bs=new bookService();
			int bookId=bs.getBookId(condition);
			list=service.getUserBookId(bookId, userId, bPageNo, bPageSize);
			count=service.getUserBookIdLine(bookId, userId);
		}else if(sel.equals("5")) {
			list=service.getUserExceedTime(userId, bPageNo, bPageSize);
//			System.out.println("list"+list);
			count=service.getUseExceedTimeLine(userId);
		}
		
		if(count%bPageSize==0) {
			bPageCount=count/bPageSize;
		}else {
			bPageCount=count/bPageSize+1;
		}	
		if(list==null) {
			out.println("<script language='JavaScript'>");
			out.println("alert('无该漫画');");
			String loc="location.href='"+path+"/index.jsp';";
			out.println(loc);
			out.println("</script>");
		}
		
		session.setAttribute("pageRecord", list);
		request.setAttribute("bPageNo", bPageNo);
		request.setAttribute("bPageCount",bPageCount);
		session.setAttribute("bcPageSize",bPageSize);
		request.setAttribute("sel", sel);
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
