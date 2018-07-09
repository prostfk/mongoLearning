<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>--%>
</head>
<body>
<h1>Person List</h1>

<br/><br/>
<div>



    <form method="post" action="/auth">

        <input type="text" placeholder="name">
        <input type="password" placeholder="password">
        <input type="submit">

    </form>

</div>
</body>

</html>