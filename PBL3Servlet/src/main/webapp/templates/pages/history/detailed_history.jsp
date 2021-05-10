<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Tra cứu chi tiết</title>
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
                    <h2 class="font-weight-bold text-uppercase header my-3">Tra Cứu Chi Tiết</h2>
                </div>
            </div>

            <div class="row bg-white shadow-lg rounded px-md-5 px-2 py-3 py-md-5 mb-5">
                <div class="col-12">
                    <form class="needs-validation w-100 " novalidate>
                        <div class="form-row m-auto">
                            <div class=" col-12 mb-3 ">
                                <label for="fromDate">Ngày Gửi Xe</label>
                                <c:if test="${requestScope.fromDate != null}">
                                    <input id="fromDate" class="form-control" type="date" value="${fromDate}"
                                           required>
                                </c:if>
                                <c:if test="${requestScope.fromDate == null}">
                                    <input id="fromDate" class="form-control" type="date" value=""
                                           required>
                                </c:if>
                            </div>
                            <div class=" col-12 mb-3">
                                <label for="toDate">Ngày Lấy Xe</label>
                                <c:if test="${requestScope.toDate != null}">
                                    <input id="toDate" class="form-control" value="${toDate}" type="date" 
                                           required>
                                </c:if>
                                <c:if test="${requestScope.toDate == null}">
                                    <input id="toDate" class="form-control" value="" type="date" 
                                           required>
                                </c:if>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>

                        </div>

                        <button class="btn btn-packet mt-2" type="submit">Tra cứu</button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col text-center">
                    <h2 class="font-weight-bold text-uppercase header my-3">Lịch sử chi tiết</h2>
                </div>
            </div>
            <div class="row bg-white shadow-lg rounded px-md-5 px-2 py-3 py-md-5 mb-5">
                <div class="col-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Plate number</th>
                                <th scope="col">Check out</th>
                                <th scope="col">Check in</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${history}" var="item" varStatus="loop">
                                <fmt:parseDate value="${ item.check_out_at }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTimeCheckOut" type="both" />
                                <fmt:parseDate value="${ item.check_in_at }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTimeCheckIn" type="both" />
                                <tr>
                                    <th scope="row">${loop.index}</th>
                                    <td>${item.license_plate}</td>

                                    <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCheckOut }" /></td>
                                    <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCheckIn }" /></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="col-12">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <!-- Welcome Toast after login successfully -->
        <%@include file="/templates/fragments/welcome_login_toast.jspf" %>

    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>

    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';
            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</html>
