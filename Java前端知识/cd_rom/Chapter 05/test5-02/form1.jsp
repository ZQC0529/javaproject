<form action="" method="post">
	myid:<input type=text name="myid"><br>
	mynickname:<input type=text name="mynickname"><br>
<input type=submit value="submit"/>
</form>
	<jsp:useBean id="st" class="std.FormBean"/>
	<jsp:setProperty name="st"  property="id" param="myid"/>
	<jsp:setProperty name="st"  property="nickname" param="mynickname"/>
<hr/>
	<jsp:getProperty name="st" property="id"/><br>
	<jsp:getProperty name="st" property="nickname"/>
