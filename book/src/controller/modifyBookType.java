package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.bookType;
import service.bookTypeService;

/**
 * Servlet implementation class modifyBookType
 */
@WebServlet("/modifyBookType.do")
public class modifyBookType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyBookType() {
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
		
		String strTypeId=request.getParameter("typeId");
		int typeId=0;
		if(strTypeId==null) {
			System.out.println("strTypeId未接到值");
		}
		typeId=Integer.parseInt(strTypeId);
		
		bookTypeService service=new bookTypeService();
		bookType bookType=service.getbookType(typeId);
		request.setAttribute("bookType",bookType);
		request.getRequestDispatcher("/admin/modifyBookType.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
