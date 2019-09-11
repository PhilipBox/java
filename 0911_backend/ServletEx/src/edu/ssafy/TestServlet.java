package edu.ssafy;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cnt;

	/*
	 * ó�� �ѹ��� ����Ǵ� ��.(������ ó���ö�ö� ó���Ǵ� ��)
	 */
	@Override 
	public void init(ServletConfig config) throws ServletException {
		// ���� init�� ���ϴ��� ���ݾ�. �������̵��ϴϱ� ������ init����
		super.init(config);
		cnt++;
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.service(req, res);
		cnt++;
		System.out.println("cnt : " + cnt);
	}
	
	public void destroy() {
		super.destroy();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet.....");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("end");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost.....");
		doGet(request, response);
	}

}
