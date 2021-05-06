<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Chi tiết gói gửi xe</title>
        <%@include file="/templates/fragments/header.jspf" %>
    </head>
    <style>
        .btn-packet {
            background-color: var(--main-color);
            color: white;
        }

        .caption {
            border: 1px solid var(--main-color);
            color: var(--main-color);

        }

        .carousel-item {
            width: 100% !important;
            border: none;
        }

        .carousel-item:hover {
            box-shadow: 2px 2px 4px #9c9999;
        }
    </style>

    <body>

        <!-- import navigation  -->
        <%@include file="/templates/fragments/navigation.jspf" %>

        <div class="container my-4 my-md-5 px-5 px-sm-0">

            <div class="col-12 col-xl-9 my-4 my-md-5 bg-white shadow-lg rounded m-auto">
                <h3 class="header p-2 p-md-3 text-center border-bottom  border-info border-2  text-wrap">Các gói thịnh hành
                </h3>

                <div id="carouselExampleInterval" class="carousel slide col-12 " data-bs-ride="carousel">
                    <div class="carousel-inner">

                        <!-- Loop through all objects of List<ParkingPackage> -->
                        <c:forEach items="${parkingPackages}" var="parkingPackage" varStatus="loop">
                            <c:if test="${loop.index == 0}">
                                <div class="carousel-item active" data-bs-interval="2000">
                                </c:if>
                                <c:if test="${loop.index != 0}">
                                    <div class="carousel-item" data-bs-interval="2000">
                                    </c:if>

                                    <div class=" btn rounded px-lg-5 px-2 py-2 w-100">
                                        <a href="">
                                            <h5 class="px-4  text-wraps">${parkingPackage.name}</h5>
                                        </a>
                                        <p class="px-4 px-lg-5  text-wrap">
                                            ${parkingPackage.desciption}
                                        </p>
                                        <button class="btn btn-danger my-3">Đăng kí</button>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval"
                                data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval"
                                data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>

                </div>

                <h3 class="header col-12 px-3 text-center  text-wrap">Tất cả các gói</h3>

                <div class="d-flex justify-content-center flex-wrap">

                    <!-- Loop through all objects of List<ParkingPackage> -->
                    <c:forEach items="${parkingPackages}" var="parkingPackage">
                        <div class="caption btn rounded col-12 col-sm-5 col-xl-3 py-md-4 py-3 mx-2 my-3 shadow-lg">
                            <a href="">
                                <h5 class=" text-wrap">${parkingPackage.name}</h5>
                            </a>
                            <p class=" text-wrap">
                                ${parkingPackage.desciption}
                            </p>
                            <button class="btn btn-danger my-1">Đăng kí</button>
                        </div>
                    </c:forEach>

                </div>
            </div>
    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>

    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';
            window.addEventListener(
                    'load',
                    function () {
                        // Fetch all the forms we want to apply custom Bootstrap validation styles to
                        var forms = document.getElementsByClassName('needs-validation');
                        // Loop over them and prevent submission
                        var validation = Array.prototype.filter.call(forms, function (form) {
                            form.addEventListener(
                                    'submit',
                                    function (event) {
                                        if (form.checkValidity() === false) {
                                            event.preventDefault();
                                            event.stopPropagation();
                                        }
                                        form.classList.add('was-validated');
                                    },
                                    false
                                    );
                        });
                    },
                    false
                    );
        })();
    </script>

</html>
