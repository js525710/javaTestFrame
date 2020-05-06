package LoginPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testing.loginsample.LoginSample;



/**
 * Servlet implementation class LoginClass
 */
@WebServlet("/LoginClass")
public class LoginClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	//构造方法
    public LoginClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginSample ls=new LoginSample();
		boolean loginResult = ls.login(username,password);
		String ResultMessage="{\"msg\":";
		if(loginResult) {
			ResultMessage+="\"恭喜您登陆成功！\"}";
		}else {
			ResultMessage+="\"登录失败，用户名密码错误！\"}";
		}
		
//		System.out.println(username+password);
		response.getWriter().append("get方法").append(ResultMessage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginSample ls=new LoginSample();
		boolean loginResult = ls.login(username,password);
		String ResultMessage="{\"msg\":";
		if(loginResult) {
			ResultMessage+="\"恭喜您登陆成功！\"}";
		}else {
			ResultMessage+="\"登录失败，用户名密码错误！\"}";
		}
		
//		System.out.println(username+password);
		response.getWriter().append("post方法").append(ResultMessage);
	}

}
