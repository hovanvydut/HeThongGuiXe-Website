<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Trang chủ</title>
        <%@include file="/templates/fragments/header.jspf" %>
    </head>

    <body>
        <%@include file="/templates/fragments/navigation.jspf" %>

        <h1>Home page</h1>

        <!-- Welcome Toast after login successfully -->
        <%@include file="/templates/fragments/welcome_login_toast.jspf" %>
        
    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>

</html>

