<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script type="text/javascript" >
		function showDetail()
		{
			var elm = document.getElementById('detail_system_error_msg');
			if(elm.style.display == '') {
				elm.style.display = 'none';
			}else {
				elm.style.display = '';
			}
		}
		$(document).ready(function() {
		});
	</script>
</head>

<body>
<div class="g-doc">
	<%@ include file="/WEB-INF/views/commons/menu.jsp"%>
	<%
		//Exception from JSP didn't log yet ,should log it here.
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		LogFactory.getLog(requestUri).error(exception.getMessage(), exception);
	%>
<!-- div id="content">	
	<h3>
	对不起,发生系统内部错误,不能处理你的请求<br />
	</h3>
	<b>错误信息:</b> <%=exception.getMessage()%>
</div-->

<div class="g-mn">
			<div class="g-rst f-pt110">
				<div class="g-err" style="padding:0px">
					<div class="m-500">
						<h2 >500错误</h2>
						<p class="f-ff1">对不起,发生系统内部错误,不能处理你的请求</p>
						<a href="${ctx}welcome.do">由此返回首页</a><a href="javascript:void(0);" onclick="showDetail();">查看详细错误消息</a>
						<div class="msg" id="detail_system_error_msg" style="display:none;height:270px">
							<pre style="overflow:auto;height:270px" ><%exception.printStackTrace(new java.io.PrintWriter(out));%></pre>
						</div>
					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>