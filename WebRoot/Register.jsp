<jsp:include page="head.jsp"></jsp:include>

<!--         <s:textfield name="user.username" label="用户名"></s:textfield> -->
<!--         <s:password name="user.password" label="密码"></s:password> -->
<%--         <s:select list="${1:'男', 0:'女'}" listKey="key" listValue="value"
<%--             name="user.gender" label="性别" value="1"></s:select> --%>
<!--         <s:submit value="注册"></s:submit> -->
    <form action="login" method="post">
    	用户名<input type="text" name="userName"/><br>
    	密码    <input type="text" name="password"/><br>
    	<input type="submit" value="登录"/>
    </form>
<jsp:include page="foot.jsp"></jsp:include>