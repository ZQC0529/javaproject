import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.jspsmart.upload.*;

public class servletUpload extends HttpServlet {
	private ServletConfig config;
	//初始化Servlet
	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	//处理GET请求
	public void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("The method of the HTML form must be POST.");
	}
	//响应POST请求
	protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 变量定义
		int count=0;
		SmartUpload mySmartUpload = new SmartUpload();
		try {
			// 初始化
			mySmartUpload.initialize(config,request,response);
			// 上载
			mySmartUpload.upload();
			// 保存上载文件到指定目录
			// PATH为form表单提交过来的
	count = mySmartUpload.save(mySmartUpload.getRequest().getParameter("PATH"));
			// 显示处理结果
			out.println(count + " file uploaded.");
		} catch (Exception e){
			out.println("Unable to upload the file.<br>");
			out.println("Error : " + e.toString());
		}
    }
}
