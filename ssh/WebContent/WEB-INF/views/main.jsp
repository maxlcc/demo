<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:1100px;
             } 
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<script type="text/javascript">
// 当前第几页数据
var currentPage = ${result.currentPage};

// 总页数
var totalPage = ${result.totalPage};

function submitForm(actionUrl){
	var formElement = document.getElementById("stuForm");
	formElement.action = actionUrl;
	formElement.submit();
}

// 第一页
function firstPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context %>/sublist/SublistServlet?pageNum=1");
		return true;
	}
}

// 下一页
function nextPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context %>/sublist/SublistServlet?pageNum=" + (currentPage+1));
		return true;
	}
}

// 上一页
function previousPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context %>/sublist/SublistServlet?pageNum=" + (currentPage-1));
		return true;
	}
}

// 尾页
function lastPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context %>/sublist/SublistServlet?pageNum=${result.totalPage}");
		return true;
	}
}
function initPage(){
	var genderRequest = "${gender}" ;
	var genderVal = 0;
	var genderElement = document.getElementById("gender");
	if(genderRequest != ""){
		genderVal = parseInt(genderRequest);
	}
	
	var options = genderElement.options;
	var i = 0;
	for(i = 0; i < options.length; i++){
		if(options[i].value == genderVal){
			options[i].selected=true;
			break;
		}
	}
	
}
</script>

<body>
<table border="0" width="1100px">
<tr>
<td align="center" style="font-size:24px; ; color:#666"> 人员管理</td>
</tr>
<!--<tr>-->
 <!--<td align="right" > <a href="${pageContext.request.contextPath}/person/addperson">添加</a></td> -->
<!--</tr>-->
</table>
<br/>
<table cellspacing="0" border="1" class="table1">
<thead>
   <tr>
   		<th width="36">序号</th>
    	<th width="100">姓名</th>
    	<th width="150">身份证号</th>
    	<th width="150">电话</th>
    	<th width="300">地址</th>
   		<th width="100">编辑</th>
   		<th width="100">删除</th>
   </tr>
</thead>
<tbody>

<c:forEach var="p" items="${requestScope.personlist }">
	<tr>
		<td align="center">${p.id} </td>
		<td align="center">${p.name }</td>
		<td align="center">${p.idCard }</td>
		<td align="center">${p.phone }</td>
		<td align="center">${p.address }</td>
		<td align="center">
			<a href="${pageContext.request.contextPath}/person/doupdate?id=${p.id}"><img src="<%=basePath %>images/modify01.gif"></a>
		</td>
		<td  align="center">
			<a href="${pageContext.request.contextPath}/person/deletePersonById?id=${p.id}" onclick='return confirm("确认要删除吗?")'><img src="<%=basePath %>images/delete01.gif"></a>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
<br> 
		
			共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
			<a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp; 
			<a href="#" onclick="nextPage();">下一页</a>&nbsp;&nbsp; 
			<a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
			<a href="#" onblur="lastPage();">尾页</a>	
			
<br/>


</body>
</html>