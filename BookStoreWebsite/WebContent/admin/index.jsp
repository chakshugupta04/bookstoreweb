<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>e-bookstore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
<div align="center">
<h2> Administrative Dashboard</h2>
</div>
<div align="center">
<hr width="95"/>
<h2>Quick Action</h2>
<b>
<a href="create_book">New Book</a> &nbsp;
<a href="create_User">New User</a> &nbsp;
<a href="create_category">New Category</a> &nbsp;
<a href="create_customer">New Customer</a> 
</b>
</div>
<div align="center">
<hr width="95"/>
<h2>Recent Sales:</h2>
</div>
<div align="center">
<hr width="95"/>
<h2>Recent Review:</h2>
</div>
<div align="center">
<hr width="95"/>
<h2>Statistics:</h2>
<hr width="95"/>
</div>
<jsp:directive.include file="footer.jsp"/>
</body>

</html>