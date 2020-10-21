package I18N;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;

public class Hello3 extends HttpServlet
{
	Locale locale; 
	DateFormat format;
	PrintWriter writer;	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
	{
		response.setContentType("text/html;charset=unicode");
		writer=response.getWriter();
		//获得请求的语种 
		String language=(String)request.getParameter("language"); 
		int lan=Integer.parseInt(language); 
		switch(lan) 
		{  
		  case 1:processEnglish();break; 
		  case 2:processChinese();break; 
		  case 3:processKorean();break; 
		  case 4:processRussian();break; 
		  case 5:processSpanish();break; 
		  case 6:processJapanese();break; 
		} 		
	}
	//英语 
	void processEnglish() 
	{ 
	locale=new Locale("en","US"); 
	format=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale); 
		writer.println("in English:"); 
		writer.println("<br>"); 
		writer.println("HelloWorld!"); 
	  	writer.println(format.format(new Date())); 
	 	writer.flush(); 
	} 
	//中文 
	void processChinese() 
	{ 
	 	 locale=new Locale("zh",""); 
format=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale); 
	 	 writer.println("in Chinese:"); 
	 	 writer.println("<br>"); 
	 	 writer.println("\u4f60\u597d\u4e16\u754c"); 
	   	 writer.println(format.format(new Date())); 
	 	 writer.flush(); 
	} 
	//韩国语 
	void processKorean()
	{ 
		 locale=new Locale("ko",""); 
format=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale); 
		 writer.println("in Korean:"); 
		 writer.println("<br>"); 
		 writer.println("\uc548\ud558\uc138\uc694\uc138\uacc4"); 
		 writer.println(format.format(new Date())); 
		 writer.flush(); 
	} 
	//俄语 
	void processRussian()
	{ 
		 locale=new Locale("ru",""); 
format=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale); 
		 writer.println("in Russian:"); 
		 writer.println("<br>"); 
		 writer.println("\u0417\u0434\u0440\u0430\u0432\u0441\u0442\u0432"+
		 				"\u0443\u0439,\u041c\u0438\u0440"); 
		 writer.println(format.format(new Date())); 
		 writer.flush(); 
	} 
	//西班牙语 
	void processSpanish()
	{ 
		 locale=new Locale("es",""); 
format=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale); 
		 writer.println("in Spanish:"); 
		 writer.println("<br>"); 
		 writer.println("En Espa\u00f1ol:"); 
		 writer.println("\u00a1Hola Mundo!"); 
		 writer.println(format.format(new Date())); 
		 writer.flush(); 
	} 
	//日语 
	void processJapanese()
	{ 
		 locale=new Locale("ja",""); 
format=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale); 
		 writer.println("in Japanese:");  
		 writer.println("<br>"); 
		 writer.println("\u4eca\u65e6\u306f\u4e16\u754c"); 
		 writer.println(format.format(new Date())); 
		 writer.flush(); 
	} 
}
