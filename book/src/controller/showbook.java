package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class showbook
 */
@WebServlet("/showbook.do")
public class showbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showbook() {
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

		
		//2.调用模型
		bookService  service= new bookService();

		//获取指定页码的那一页的图书类型
		List<book> list = service.getBook(bPageNo, bPageSize);
//		System.out.println("list:"+list);
		int count=service.getBookLine();
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
		
		session.setAttribute("pageBook",list);
		request.setAttribute("bPageNo", bPageNo);
		request.setAttribute("bPageCount",bPageCount);
		session.setAttribute("bcPageSize",bPageSize);
		
		session.setAttribute("allTypes", typeList);
		session.setAttribute("allLanguages", languageList);
		session.setAttribute("allPublists", publishList);
		session.setAttribute("allBookracks", bookrackList);
		

		request.getRequestDispatcher("/admin/showBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
