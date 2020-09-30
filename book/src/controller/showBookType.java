package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.bookType;
import service.bookTypeService;

/**
 * Servlet implementation class showBookType
 */
@WebServlet("/showBookType.do")
public class showBookType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showBookType() {
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
		
		//��ǰҳ��
		int btPageNo=1;
		String strPageNo = request.getParameter("btPageNo");
		if(strPageNo !=null) {//ͨ����������һҳ/��һҳ�������˲��������ܽӵ�����Ϊnull
			btPageNo=Integer.parseInt(strPageNo);
		}
		//һҳ��ʾ������
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
		//��ҳ��
		int btPageCount=1;
		//����ģ��
		bookTypeService service=new bookTypeService();
		//��ȡָ��ҳ�����һҳ����������
		List<bookType> list=service.getBookType(btPageNo, 7);
//		System.out.println(list);
		int count=service.getBookTypeLine();
		if(count%btPageSize==0) {
			btPageCount=count/btPageSize;
		}else {
			btPageCount=count/btPageSize+1;
		}
		
		session.setAttribute("pageBookType", list);
		request.setAttribute("btPageNo", btPageNo);
		request.setAttribute("btPageCount",btPageCount);
		session.setAttribute("btPageSize",btPageSize);
		request.getRequestDispatcher("/admin/showBookType.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
