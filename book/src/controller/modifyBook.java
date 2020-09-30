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
 * Servlet implementation class modifyBook
 */
@WebServlet("/modifyBook.do")
public class modifyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyBook() {
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
		
		String strBookId=request.getParameter("bookId");
		int bookId=0;
		if(strBookId==null) {
			System.out.println("strbookId未接到值");
		}
		bookId=Integer.parseInt(strBookId);
		
		bookService  service= new bookService();
		book b=service.getBook(bookId);
		request.setAttribute("book", b);
		
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
		
		request.getRequestDispatcher("/admin/modifyBook.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
