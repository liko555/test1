package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.bookTypeService;

/**
 * Servlet implementation class doDelBookType
 */
@WebServlet("/doDelBookType.do")
public class doDelBookType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDelBookType() {
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
		
		String strTypeId=request.getParameter("typeId");
		int typeId=0;
		if(strTypeId==null) {
			System.out.println("strTypeId未接到");
		}
		typeId=Integer.parseInt(strTypeId);
		
		bookTypeService service=new bookTypeService();
		boolean isSuccess =service.removeType(typeId);
		//根据删除结果，提示相应的内容
		out.println("<script type='text/javascript'>");
		if(isSuccess){
			out.println("alert('已成功删除该类型');");
		}else{
			out.println("alert('删除该漫画类型失败');");
		}
		out.println("location.href='" + this.getServletContext().getContextPath() + "/showBookType.do'");
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
