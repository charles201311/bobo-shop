<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resource/mystyles.css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript">
 $(function(){
	
	 //获取所有商品
	 $.get("/selectsGoods",function(goods){
		  for(var i in goods){
				 $("#my").append("<input type='checkbox' name='gids' value='"+goods[i].id+"'  >"+goods[i].name)  
			};
			
			//让复选框选中
			 //条件
			 var params ='${gids}';
			var str =params.split(",");
			for(var j in str){
			$("[name='gids'][value='"+str[j]+"']").prop("checked",true)
			}
	 })
 })
 
 //
    function add(){
		 //去增加页面
		 location.href="/add";
	 }
	 
	 //全选
	 function chkAll(){
	   $("[name='sids']").each(function(){
		   $(this).prop("checked",!$(this).prop("checked"));
	   })	 
		 
	 }//全不选
	 function chkNone(){
		 $("[name='sids']").each(function(){
			   $(this).prop("checked",false);
		   })	 
	 }
	 //批量删除
	 function deletePatch(){
	   //定一个数组用来存放选中的ID
	   var  sids = new Array();
	   $("[name='sids']:checked").each(function(index){
		  sids[index] =$(this).val();  //
		  
	   })
	  
	   $.post("/deletePatch",{sids:sids},function(flag){
		   if(flag){
			   alert("删除成功");
			   location.href="/selects";
		   }else{
			   alert("删除成功"); 
		   }
	   })
		 
		 
	 }
</script>

</head>
<body>
	<form action="/selects" method="post">
		商品名称: <span id="my"></span> <br> 店面名称:<input type="text"
			name="name" value="${name}"> <input type="submit" value="查询">
			<input type="button" value="增加" onclick="add()">
			<input type="button" value="批量删" onclick="deletePatch()">

	</form>
	<br>

	<table>
		<tr>
		   <td><input type="checkbox" onclick="chkAll()">全选
		   <input type="checkbox" onclick="chkNone()">全不选
		   </td>
			<td>编号</td>
			<td>名称</td>
			<td>日期</td>
			<td>商品</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${shops}" var="s">
			<tr>
			    <td><input type="checkbox" name="sids" value="${s.id }"></td>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.created }</td>
				<td>${s.gnames }</td>
				<td>修改|<a href="/shopDetail?id=${s.id}">详情</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="6">${page }</td>
		</tr>
	</table>
</body>
</html>