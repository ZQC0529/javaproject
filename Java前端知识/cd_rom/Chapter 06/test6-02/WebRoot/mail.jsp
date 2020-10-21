<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="javax.mail.*, javax.mail.internet.*"%> 
<%@ page import="javax.activation.*,java.util.*"%> 
<%
try {
	String strHost = "smtp.tom.com";
	int nPort = 0;
	String strUserName = "shizhiguo";
	String strPassWord ="userpasword";
	String strFrom = "shizhiguo@tom.com";
	String strToList = "shizhiguo@tom.com";
	String strCCList ="";
	String strBCCList = "";
	String strSubject = "jsp mail!";
	String strMessage = "test mail body!";
	//创建邮件的属性
	Properties props = new Properties();
	props.put("mail.smtp.host", strHost);
	props.put("mail.smtp.auth", "true");
	Session MailSession = Session.getDefaultInstance(props, null);
	MailSession.setDebug(true);
	//创建一个消息
	Message msg = new MimeMessage(MailSession);
	//发件人地址
	InternetAddress from = new InternetAddress(strFrom);
	msg.setFrom(from);
	//目标地址
	if (strToList != null && strToList.length() > 0) {
		InternetAddress[] to = { new InternetAddress(strToList)};
		msg.setRecipients(Message.RecipientType.TO, to);
	} else {
		throw new Exception("No Recipient");		
		}
	//抄送
	if (strCCList != null && strCCList.length() > 0) {
		InternetAddress[] cc = { new InternetAddress(strCCList)};
		msg.setRecipients(Message.RecipientType.CC, cc);
		}
	//密送
	if (strBCCList != null && strBCCList.length() > 0) {
		InternetAddress[] bcc = { new InternetAddress(strBCCList)};
		msg.setRecipients(Message.RecipientType.BCC, bcc);
		}
	//添加邮件的主题
	if (strSubject != null) {
		msg.setSubject(strSubject);
	}
		//添加邮件的日期
	msg.setSentDate(new Date());
	//添加邮件的内容
	if (strMessage != null && strMessage.trim().length() > 0) {
		msg.setText(strMessage);
	} else
		msg.setText("No message to be sent!");
	msg.saveChanges();
	//发送邮件
	int nMailPort = -1;
	if (nPort > 0)
		nMailPort = nPort;
	Transport transport = MailSession.getTransport("smtp");
	transport.connect(strHost, nMailPort, strUserName, strPassWord);
	transport.sendMessage(msg, msg.getAllRecipients());
	transport.close();
	out.print("邮件发送成功！");
} catch (AuthenticationFailedException ae) {
	ae.printStackTrace();
} catch (SendFailedException sf) {
	Address[] invalid = sf.getInvalidAddresses();
	Address[] valid = sf.getValidSentAddresses();
	Address[] unsend = sf.getValidUnsentAddresses();
	sf.printStackTrace();
} catch (Exception e) {
	e.printStackTrace();
}
%>
