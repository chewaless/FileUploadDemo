<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>file upload page</title>
</head>
<body>
	<h3>Sending Email Demo application</h3>
	<s:form action="fileUpload" method="post" enctype="multipart/form-data">
	<s:file name="uploadDoc" label="Choose file to upload" />
	<s:iterator value="fieldErrors.uploadFile"><s:property/></s:iterator>
	<s:submit value="upload" align="center" />
</s:form>
</body>
</html>

