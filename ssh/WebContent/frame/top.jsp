<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.div1{ margin-top:23px; margin-left:600px; font-size:20px; color:green}
.div2{ margin-top:0px; margin-left:1250px; font-size:14px; color:green}
</style>
</head>
<body bgcolor="#0099FF">
<div class="div1">
欢迎您: ${sessionScope.username}

</div>
<div class="div2">
    <script language="javascript">
      function exit(){
      window.open('../index.jsp','_top')
        } 
     </script>
<input type="button" value="退出系统" onclick="exit();" />
</div>
</body>
</html>