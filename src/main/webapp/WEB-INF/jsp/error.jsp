<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Web Notepad Error</title>
    <link rel="stylesheet" type="text/css" href="css/wn.css">
</head>
<body class="errorPage">
<%@include file="header.jspf"%>
<section class="errorPage">
    <h1>${error}</h1>
    <a href=".">Go to main page</a>
</section>
<br>
<%@include file="footer.jspf"%>
</body>
</html>
