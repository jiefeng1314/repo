<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
</head>
<body>
<div class="g-doc">
<%@ include file="/WEB-INF/views/commons/menu.jsp"%>
<div class="g-mn">
			<div class="g-rst f-pt110">
				<div class="g-err">
					<div class="m-ltd m-btn1  m-btn2">
						<p class="f-ff1">Sorry！您无权限访问此内容。</p>
						<button type="button" onclick='location.href="${ctx}welcome.do"'>返回首页</button>
					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>