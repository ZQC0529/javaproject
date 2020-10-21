package mypackage;
public class validate{
  final String user1="teacher";
  final String password1="teacher";
  final String user2="student";
  final String password2="student";
  private String username="";
  private String pwd="";
  public void setUsername(String username)  { 
	this.username = username;
  }
  public String getUsername()  { 
	return this.username;
  }
  public void setPwd(String password)  { 
	this.pwd = password;
  }
  public String getPwd()  {  
	return this.pwd;
  }
  public boolean uservalidate()  {
	boolean temp = false;
	if(username.equals(user1) && pwd.equals(password1)) {  
		temp=true;
     }
     else if(username.equals(user2) && pwd.equals(password2)) { 
		 temp=true;
     }
     else {  
		 temp=false;
     }
     return temp;
  }
}
