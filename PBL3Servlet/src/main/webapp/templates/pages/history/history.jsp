<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Tra cứu</title>
        <%@include file="/templates/fragments/header.jspf" %>
    </head>

    <style>
        * {
            font-family: var(--main-font);
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        a {
            text-decoration: none;
        }

        button {
            background-color: var(--main-color);
        }

        .btn-packet {
            background-color: var(--main-color);
            color: white;
        }

        .check_month {
            border: 1px solid var(--main-color);
            color: var(--main-color);
        }

        .far {
            color: var(--main-color);
        }
    </style>

    <body>

        <!-- import navigation fragment -->
        <%@include file="/templates/fragments/navigation.jspf" %>

        <div class="container mt-5">
            <div class="row">
                <div class="col text-center">
                    <h2 class="font-weight-bold text-uppercase header my-3">Tra Cứu</h2>
                </div>
            </div>
            <div class="row bg-white shadow-lg rounded px-md-5 px-2 py-3 py-md-5 mb-5">
                <div class="col-lg-6 col-12 p-2">
                    <div class="px-2">
                        <h3 class="text-left header">Tra cứu chi tiết</h3>

                        <form class="needs-validation w-100 " novalidate>
                            <div class="form-row m-auto">
                                <div class=" col-12 mb-3 ">
                                    <label for="validationCustom01">Từ ngày</label>
                                    <input class="form-control" id="validationCustom01" type="date" value="2011-08-19"
                                           id="example-date-input" required>
                                    <div class="valid-feedback">
                                        Looks good!
                                    </div>
                                </div>
                                <div class=" col-12 mb-3">
                                    <label for="validationCustom02">Đến ngày</label>
                                    <input class="form-control" id="validationCustom02" type="date" value="2011-08-19"
                                           id="example-date-input" required>
                                    <div class="valid-feedback">
                                        Looks good!
                                    </div>
                                </div>

                            </div>
                            <button class="btn btn-packet mt-2" type="submit">Tra cứu</button>
                        </form>

                    </div>
                </div>

                <div class="col-lg-6 col-12 p-2">
                    <h3 class="header px-2 px-lg-0">Lịch sử</h3>
                    <ul class="list-group my-3 px-2 px-lg-0">
                        <c:forEach items="${history}" var="item">
                            <li class="list-group-item mb-md-2 mb-1 rounded border-1">
                                <div class="d-flex  flex-wrap justify-content-between">
                                    <fmt:parseDate value="${ item.check_out_at }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTimeCheckOut" type="both" />
                                    <i class="far fa-clock"> Checkout</i>
                                    <span><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCheckOut }" /></span>
                                </div>
                                <div class="d-flex flex-wrap justify-content-between">
                                    <i class="far fa-clock"> Checkin</i>
                                    <fmt:parseDate value="${ item.check_in_at }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTimeCheckIn" type="both" />
                                    <span><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCheckIn }" />
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Welcome Toast after login successfully -->
        <%@include file="/templates/fragments/welcome_login_toast.jspf" %>
    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>
</html>
