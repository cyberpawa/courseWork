<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Your WEB Notepad</title>
    <link href="css/wn.css" rel="stylesheet" type="text/css" >
</head>
<body class="main_screen">
<%@include file="header.jspf" %>
<h1> Write your thoughts </h1>
<h2> <c:out value="${note.getTitle()}"></c:out></h2>
<form action="save" method="post" >
            <textarea class="input" name="noteText" rows="30" cols="100">  ${note.getText()}
            </textarea>
    <input type="hidden" name="noteName" value="${note.getTitle()}">
    <input type="submit" class="button" value="Save changes">
</form>
<%@include file="footer.jspf" %>
</body>
</html>
