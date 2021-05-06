<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>User</title>
        <%@include file="/templates/fragments/header.jspf" %>
    </head>
    <style>

    </style>

    <body>

        <!-- import navigation fragment -->
        <%@include file="/templates/fragments/navigation.jspf" %>

        <div class=" container my-5">
            <div class="card col-lg-5 col-md-8 col-12 bg-white d-flex m-auto shadow-sm rounded">
                <img class="card-img-top"
                     src="https://kenh14cdn.com/Images/Uploaded/Share/2012/03/09/120309kptinhtinh04.jpg"
                     alt="user profile image" />
                <div class="card-body text-left">
                    <h5 class="card-title">Tên : Trần Thị Phượng </h5>
                    <p class="card-text">
                        MSSV : 102190184
                    </p>
                    <p class="card-text">
                        Khóa : K19
                    </p>

                </div>

            </div>
        </div>
        
        <!-- Welcome Toast after login successfully -->
        <%@include file="/templates/fragments/welcome_login_toast.jspf" %>
        
    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>

</html>