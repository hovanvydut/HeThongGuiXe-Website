<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Trang chủ</title>
        <%@include file="/templates/fragments/header.jspf" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/animate.css" />
    </head>



    <body>
        <%@include file="/templates/fragments/navigation.jspf" %>
        
        <div
    class="container-fluid background m-0 home-container d-flex justify-content-between align-items-center overflow-hidden" style="z-index: 10;">
    <div class="row w-100 bg-transparent my-5 mx-0 mx-sm-5 gy-5  " >
      <div class="
            col-12 col-md-9 col-lg-6
            d-flex
            flex-column
            justify-content-center
            align-items-start
            text-white
          ">
        <h1 class="my-3 home-title text-left">HỆ THỐNG TRA CỨU LỊCH SỬ & ĐĂNG KÍ GÓI GỬI XE </h1>

        <ul class="w-100 py-3 px-0 home-content" >
          <li class="my-2 home-content fw-bolder"><i class="fas fa-check "></i> Tra cứu dễ dàng và nhanh chóng !</li>
          <li class="my-2 home-content fw-bolder"><i class="fas fa-check "></i>Tiết kiệm thời gian thanh toán tại chỗ !</li>
          <li class="my-2 home-content fw-bolder"><i class="fas fa-check "></i>Tiết kiệm chi phí với các gói chỉ từ 10K</li>
        </ul>
        <a href="${pageContext.request.contextPath}/parking-package/list" class="btn home-button  px-5 py-3 m-auto m-sm-2  border-2 fs-5 see-packet rounded-pill "> Xem các
          gói ngay</a>
       

      </div>
      <div class="
            col-12 col-lg-6
            d-none d-lg-flex
            flex-column
            justify-content-center
            align-items-center 
          " style="z-index: 5;">
          <img class="img-time h-100" style="object-fit: contain;" src="${pageContext.request.contextPath}/static/img/home_background.png" alt="" />
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

