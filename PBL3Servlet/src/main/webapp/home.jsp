<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Trang chủ</title>
        <%@include file="/templates/fragments/header.jspf" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/animate.css" />
        <style>
            /* .img-money {
              animation: shake 2s;
              animation-iteration-count: infinite;
            } */
            .img-time {
                animation-delay: 1s;
                animation: shake 2.4s;
                animation-iteration-count: infinite;
            }

            .see-packet {
                animation-delay: 1s;
                animation: shake 1s;
                animation-iteration-count: infinite;
            }

            @keyframes shake {
                0% {
                    transform: rotate(0);
                }

                15% {
                    transform: rotate(5deg);
                }

                30% {
                    transform: rotate(-5deg);
                }

                45% {
                    transform: rotate(4deg);
                }

                60% {
                    transform: rotate(-4deg);
                }

                75% {
                    transform: rotate(2deg);
                }

                85% {
                    transform: rotate(-2deg);
                }

                92% {
                    transform: rotate(1deg);
                }

                100% {
                    transform: rotate(0);
                }
            }
        </style>
    </head>



    <body>
        <%@include file="/templates/fragments/navigation.jspf" %>
        
        <div class="container bg-transparent overflow-hidden">
            <div class="row bg-transparent my-5 mx-3">
                <div class="
                     col-12 col-md-6
                     d-flex
                     flex-column
                     justify-content-center
                     align-items-start
                     ">
                    <h1 class="my-3">HỆ THỐNG TRA CỨU LỊCH SỬ</h1>
                    <h2>& ĐĂNG KÍ GÓI GỬI XE</h2>
                    <ul class="my-3">
                        <li class="my-2">Tra cứu dễ dàng và nhanh chóng !</li>
                        <li class="my-2">Tiết kiệm thời gian thanh toán tại chỗ !</li>
                        <li class="my-2">Tiết kiệm chi phí với các gói chỉ từ 10K</li>
                    </ul>
                    <a style="z-index:10;" href="${pageContext.request.contextPath}/parking-package/list" class="btn btn-primary see-packet">Xem các gói ngay</a>

                </div>
                <div class="
                     col-12 col-md-6
                     d-flex
                     flex-column
                     justify-content-center
                     align-items-center
                     ">
                    <img class="img-money" src="${pageContext.request.contextPath}/static/img/pig_save_money.png" alt="" />
                    <h2 class="">Tiết kiệm chi phí</h2>
                    <img class="img-time" src="${pageContext.request.contextPath}/static/img/pig_save_time.png" alt="" />
                    <h2 class="mt-3">Tiết kiệm thời gian</h2>
                </div>
            </div>
        </div>

        <div class="area">
            <ul class="circles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>

        <!-- Welcome Toast after login successfully -->
        <%@include file="/templates/fragments/welcome_login_toast.jspf" %>

    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>

</html>

