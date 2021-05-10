<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                                <label for="validationCustom01">Ngày Gửi Xe</label>
                                <input class="form-control" id="validationCustom01" type="date" value="2011-08-19"
                                       id="example-date-input" required>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class=" col-12 mb-3">
                                <label for="validationCustom02">Ngày Lấy Xe</label>
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
                                <th scope="col">Check in</th>
                                <th scope="col">Check out</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td colspan="2">Larry the Bird</td>
                                <td>@twitter</td>
                            </tr>
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
