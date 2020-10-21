<form action="" method="post">
	id:<input type=text name="id"><br>
	nickname:<input type=text name="nickname"><br>
	<input type=submit value="submit"/>
</form>
	<jsp:useBean id="st" class="std.FormBean"/>
	<jsp:setProperty name="st"  property="*"/>
	<hr/>
	<jsp:getProperty name="st" property="id"/><br>
	<jsp:getProperty name="st" property="nickname"/>
