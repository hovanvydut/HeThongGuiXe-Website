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

        <c:if test="${param.loginSuccessfulMsg != null}">
            <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 5">
                <div class="toast fade show align-items-center text-white bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="d-flex">
                        <div class="toast-body">
                            Welcome <c:out value="${sessionScope.loggedInUser.username}" />!
                        </div>
                        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>
                </div>
            </div>
        </c:if>
    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>

</html>

