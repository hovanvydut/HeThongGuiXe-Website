<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header">
                            Thông tin tài khoản
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="row mb-3">
                                    <label for="inputFullname" class="col-sm-2 col-form-label">Full name</label>
                                    <div class="col-sm-10">
                                        <input disabled type="text" class="form-control" id="inputFullname"
                                               value="${loggedInCustomer.fullname}">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputStudentId" class="col-sm-2 col-form-label">Student ID</label>
                                    <div class="col-sm-10">
                                        <input disabled type="text" class="form-control" id="inputStudentId"
                                               value="${loggedInCustomer.student_id}">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputUsername" class="col-sm-2 col-form-label">Username</label>
                                    <div class="col-sm-10">
                                        <input disabled type="text" class="form-control" id="inputUsername" value="${loggedInCustomer.username}">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                                    <div class="col-sm-10">
                                        <input disabled type="text" class="form-control" id="inputEmail"
                                               value="${loggedInCustomer.email}">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPhonenumber" class="col-sm-2 col-form-label">Phone</label>
                                    <div class="col-sm-10">
                                        <input disabled type="text" class="form-control" id="inputPhonenumber"
                                               value="${loggedInCustomer.phone}">
                                    </div>
                                </div>
                                   <div class="row mb-3">
                                    <label for="inputCreatedAt" class="col-sm-2 col-form-label">Created at</label>
                                    <div class="col-sm-10">
                                        <fmt:parseDate value="${ loggedInCustomer.created_at }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTimeCreatedAt" type="both" />
                                        <input disabled type="text" class="form-control" id="inputCreatedAt"
                                               value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCreatedAt }" />">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- Welcome Toast after login successfully -->
        <%@include file="/templates/fragments/welcome_login_toast.jspf" %>

    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>

</html>