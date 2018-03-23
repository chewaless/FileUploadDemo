<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style type="text/css">
.uploaded {
	background-color: #DDFFDD;
	border: 1px solid #009900;
	width: 700px;
}

.welcome li {
	list-style: none;
}

table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Successful</title>
<s:head />
</head>
<body>
	<h3>Sending Email Demo application</h3>

	<%-- <div class="uploaded">
		File Name :
		<s:property value="uploadDocFileName"></s:property>
		<br /> Content type:
		<s:property value="uploadDocContentType"></s:property>
		<br /> User file :
		<s:property value="uploadDoc"></s:property>
	</div> 
	
	<s:if test="mList !=null && mList.size() > 0"> --%>
		<div style="margin-top: 40px; margin-right: 150px; margin-left: 150px;">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Sr No</th>
						<th>MOBILE</th>
					</tr>
				</thead>
				<s:iterator value="mList">
					<tr>
					    <td><s:property value="id" />1</td>
						<td><s:property value="mobileNumber" />Santosh</td>
					</tr>
				</s:iterator>
				<s:iterator  value="mList">  
					<fieldset>  
					<s:property value="id"/><br/>  
					<s:property value="mobileNumber"/><br/>  
					</fieldset>  
				</s:iterator>
				 <s:iterator value="mList" var="i">
				       <tr>
				          <td>${i.id}</td>
				         <td>${i.mobileNumber}</td>
				        </tr>
       			 </s:iterator>
			</table>
		</div>
	<%-- </s:if> --%>
	
</body>
</html>