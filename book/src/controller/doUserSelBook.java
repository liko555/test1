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

import entity.book;
import entity.bookType;
import entity.bookrack;
import entity.language;
import entity.publish;
import service.bookService;
import service.bookTypeService;
import service.bookrackService;
import service.languageService;
import service.publishService;

/**
 * Servlet implementation class doselect
 */
@WebServlet("/doUserSelBook.do")
public class doUserSelBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doUserSelBook() {
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
		
		String selectName=request.getParameter("selectName");
		if(selectName==null) {
//			System.out.println("selectName无值,默认为0");
			selectName="0";
		}
		
		String condition=request.getParameter("condition");
		if(condition==null) {
//			System.out.println("condition未接到值,默认为0");
		}
		int IntCondition=0;
		
		HttpSession session=request.getSession();
		//定义产生out对象
		PrintWriter out = response.getWriter();
		bookService service=new bookService();
		book book=new book();
		
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
		
		List<book> list=new ArrayList<book>();
		if(selectName.equals("0")) {
			list = service.getBook(bPageNo, bPageSize);
			count=service.getBookLine();
		}else if(selectName.equals("1")){
			list =service.titlegetBook(condition,bPageNo, bPageSize);			
			count=service.getBookTitleLine(condition);
			if(condition.equals("")) {
				out.println("<script language='javaScript'>");
				out.println("alert('未输入值');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
				out.println("</script>");
			}else {
				list =service.titlegetBook(condition,bPageNo, bPageSize);			
				count=service.getBookTitleLine(condition);
			}		
		}else if(selectName.equals("2")){
			if(condition.equals("")) {
				out.println("<script language='javaScript'>");
				out.println("alert('未输入值');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
				out.println("</script>");
			}else {
				IntCondition=Integer.parseInt(condition);
				list =service.BookIdgetBook(IntCondition,bPageNo,bPageSize);
				count=service.getBookIdLine(IntCondition);
			}
		}else if(selectName.equals("3")) {
			if(condition.equals("")) {
				out.println("<script language='javaScript'>");
				out.println("alert('未输入值');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
				out.println("</script>");
			}else {
				list =service.authorgetBook(condition,bPageNo,bPageSize);
				count=service.getauthorLine(condition);
			}
		}else if(selectName.equals("4")) {
			if(condition.equals("")) {
				out.println("<script language='javaScript'>");
				out.println("alert('未输入值');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
				out.println("</script>");
			}else {
				publishService ps=new publishService();
				int publishId=ps.getPublishId(condition);
				if(publishId==0) {
					out.println("<script language='javaScript'>");
					out.println("alert('无该类型');");
					out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
					out.println("</script>");
				}
				list=service.publishNamegetBook(publishId,bPageNo,bPageSize);
				count=service.getpublishNameLine(publishId);
			}
		}else if(selectName.equals("5")) {
			if(condition.equals("")) {
				out.println("<script language='javaScript'>");
				out.println("alert('未输入值');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
				out.println("</script>");
			}else {
				bookTypeService bs=new bookTypeService();
				int typeId=bs.getName(condition);
				list=service.typeNamegetBook(typeId,bPageNo,bPageSize);
				count=service.getTypeNameLine(typeId);
			}
		}else if(selectName.equals("6")) {
			if(condition.equals("")) {
				out.println("<script language='javaScript'>");
				out.println("alert('未输入值');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
				out.println("</script>");
			}else {
				languageService ls=new languageService();
				int languageId=ls.getlanguageId(condition);
				list=service.languagegetBook(languageId,bPageNo,bPageSize);
				count=service.getlanguageLine(languageId);
			}
		}else if(selectName.equals("7")){
			if(condition.equals("")) {
				out.println("<script language='javaScript'>");
				out.println("alert('未输入值');");
				out.println("location.href='" + this.getServletContext().getContextPath() + "/showbook.do'");
				out.println("</script>");
			}else {
				bookrackService bs=new bookrackService();
				int bookrackId=bs.getbookrackId(condition);
				list=service.bookrackgetBook(bookrackId,bPageNo,bPageSize);
				count=service.getbookrackLine(bookrackId);
			}
		}
		
		if(count%bPageSize==0) {
			bPageCount=count/bPageSize;
		}else {
			bPageCount=count/bPageSize+1;
		}	
		//调用模型
		bookTypeService bs=new bookTypeService();
		List<bookType> typeList=bs.getbookTypes();
		
		languageService lS=new languageService();
		List<language> languageList=lS.getLanguages();
		
		publishService pS=new publishService();
		List<publish> publishList=pS.getPublishs();
		
		bookrackService RS=new bookrackService();
		List<bookrack> bookrackList=RS.getBookracks();
		session.setAttribute("allTypes", typeList);
		session.setAttribute("allLanguages", languageList);
		session.setAttribute("allPublists", publishList);
		session.setAttribute("allBookracks", bookrackList);
		session.setAttribute("pageBook", list);
		request.setAttribute("bPageNo", bPageNo);
		request.setAttribute("bPageCount",bPageCount);
		session.setAttribute("bcPageSize",bPageSize);
		request.getRequestDispatcher("/user/showBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
