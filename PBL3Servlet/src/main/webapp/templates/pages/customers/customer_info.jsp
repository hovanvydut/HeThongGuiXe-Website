<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <title>User</title>
      <%@include file="/templates/fragments/header.jspf"%>
   </head>
   
  <style>
  .enableEdit {
   		    border-width: 2px !important;
    border-color: rgb(89, 196, 192) !important;
   	}
    .header {
      font-size: 3vw;
      color: var(--main-color);
    }
    .registered-packet .header {
      font-size: 2vw;
    }
    .registered-packet {
      background: #007991; /* fallback for old browsers */
      background: -webkit-linear-gradient(
        to right,
        #78ffd6,
        #007991
      ); /* Chrome 10-25, Safari 5.1-6 */
      background: linear-gradient(
        to right,
        #78ffd6,
        #007991
      ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

      border-top-left-radius: 15px !important;
      border-bottom-left-radius: 15px !important;
    }
    .btn-custom {
      background-color: var(--main-color);
      font-size: 125%;
    }
    .btn-custom-2 {
      border: 1px solid var(--main-color-2);
    }
    .fa-gift {
      font-size: 9vw;
    }
    @media (max-width: 768px) {
      .registered-packet {
        border-radius: 15px !important;
      }
      .fa-gift {
        font-size: 18vw;
      }
      .header {
        font-size: 5vw;
      }
      .registered-packet .header {
        font-size: 5vw;
      }
    }
  </style>
   <body>
      <!-- import navigation fragment -->
      <%@include file="/templates/fragments/navigation.jspf"%>
      
      
      <div class="container my-5">
         <div class="row border mx-3" style="border-radius: 15px">
         	<c:if test="${ not empty currentPayment }">
            <div
               class="
               registered-packet
               col-md-6 col-xl-4
               p-4
               border-end
               rounded-0
               d-flex
               flex-column
               align-items-center
               justify-content-center">
               <i class="fas fa-gift text-white"></i>
               <div class="header my-2 border-0 bg-transparent text-white">
                  Bạn có 1 gói
               </div>
               <button class="btn btn-custom-2 my-3 px-4 rounded-pill text-white"
                  data-bs-toggle="modal" data-bs-target="#detailPacket" style="
    border: 1px solid white !important;">Xem
               chi tiết</button>
            </div>
            </c:if>
            
            <c:if test="${ empty currentPayment }">
            <div
          class="
            registered-packet
            col-md-6 col-xl-4
            p-4
            border-end
            rounded-0
            d-flex
            flex-column
            align-items-center
            justify-content-center
          "
        >
          <i class="fas fa-gift text-white"></i>
          <div class="header my-2 border-0 bg-transparent text-white ">
           Bạn chưa đăng kí gói
          </div>
          <p class="text-white text-center">"Nhanh tay đăng kí gói để tiết kiệm chi phí  ! "</p>

          <a href="${ pageContext.request.contextPath }/parking-package/list"
            class="btn btn-custom-2 my-3 px-4 rounded-pill text-white see-packet font-weight-bold"
            style="
    border: 1px solid white !important;"
            data-bs-target="#detailPacket"
          >
            Xem các gói ngay
          </a>
        </div>
            </c:if>
            
            <div class="col-md-6 col-xl-8">
               <div class="card pt-4 border-0">
                  <div class="card-header header border-0 bg-white m-auto">
                     Thông tin tài khoản
                  </div>
                  <div class="card-body">
                     <form id="form" class="needs-validation" method="POST" action="${ pageContext.request.contextPath }/customers/update" novalidate>
                        <div class="row mb-3">
                           <div class="col-10 form-floating offset-1 mb-3 px-0">
                              <input name="fullname" type="text" class="form-control bg-white" 
                              		data-originvalue="${loggedInCustomer.fullname}"
                                 id="inputFullname" value="${loggedInCustomer.fullname}" minlength=2 maxlength=40
                                 disabled required />
                              <div id="inputFullnameFeedback" class="invalid-feedback">
                                 Tên tài khoản không hợp lệ !
                              </div>
                              <label for="inputFullname">Họ tên</label>
                           </div>
                        </div>
                        <div class="row mb-3">
                           <div class="col-10 form-floating offset-1 mb-3 px-0">
                              <input type="text" class="form-control bg-white"
                                 id="inputStudentId" value="${loggedInCustomer.student_id}"
                                 disabled /> <label for="inputStudentId">Mã số Sinh
                              viên</label>
                           </div>
                        </div>
                        <div class="row mb-3">
                           <div class="col-10 form-floating offset-1 mb-3 px-0">
                              <input type="text" class="form-control bg-white"
                                 id="inputUsername" value="${loggedInCustomer.username}"
                                 disabled /> <label for="inputUsername">Tên tài khoản</label>
                           </div>
                        </div>
                        <div class="row mb-3">
                           <div class="col-10 form-floating offset-1 mb-3 px-0">
                              <input name="email" type="email" class="form-control bg-white"
                              	data-originvalue="${loggedInCustomer.email}"
                                 id="inputEmail" value="${loggedInCustomer.email}" disabled
                                 pattern="^[\w][a-z0-9_\.]{4,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,10}$"
                                  />
                              <div id="inputEmailFeedback" class="invalid-feedback">
                                 Email không hợp lệ !
                              </div>
                              <label for="inputEmail">Email</label>
                           </div>
                        </div>
                        <div class="row mb-3">
                           <div class="col-10 form-floating offset-1 mb-3 px-0">
                              <input name="phone" type="text" class="form-control bg-white"
                              	data-originvalue="${loggedInCustomer.phone}"
                                 id="inputPhonenumber" value="${loggedInCustomer.phone}"
                                 pattern="^((\+84|84|0)[35789])\d{8}$" minlength="10"
                                 maxlength="12" disabled />
                              <div id="inputPhonenumberFeedback" class="invalid-feedback">
                                 Số điện thoại không hợp lệ !
                              </div>
                              <label for="inputPhonenumber">Số điện thoại</label>
                           </div>
                        </div>
                        
                        <fmt:parseDate value="${ loggedInCustomer.created_at }"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTimeCreatedAt"
										type="both" />
                        <div class="row mb-3">
                           <div class="col-10 form-floating offset-1 mb-3 px-0">
                              <input type="text" class="form-control bg-white"
                                 id="inputCreatedAt" value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCreatedAt }" />"
                                 disabled /> <label for="inputCreatedAt">Ngày tham gia</label>
                           </div>
                        </div>
                        <div class="row mb-3">
                           <div
                              class="
                              action
                              col-10
                              offset-1
                              d-flex
                              flex-wrap
                              justify-content-around
                              ">
                              <button
                              	type="button"
                                 class="btn px-3 btn-custom my-3 rounded-pill text-white"
                                 id="btnEdit" onclick="edit(this)">
                              Chỉnh sửa <i class="far fa-edit text-white"></i>
                              </button>
                              <a
                              	href="${ pageContext.request.contextPath }/customers/reset-password"
                                 class="btn px-3 btn-custom my-3 rounded-pill text-white"
                                 id="btnResetPwd">
                              Reset password <i class="fas fa-lock-open text-white"></i>
                              </a>
                              <button type="button"
                                 class="btn px-3 btn-custom my-3 rounded-pill text-white d-none"
                                 id="btnCancel" onclick="cancel()">
                              Hủy tác vụ <i class="far fa-times-circle text-white"></i>
                              </button>
                              <button
                                 class="btn px-3 btn-custom my-3 rounded-pill text-white d-none"
                                 id="btnSave" type="submit" onclick="save()">
                              Lưu thay đổi <i class="far fa-check-circle text-white"></i>
                              </button>
                           </div>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- 
         modal xem chi tiết
         -->
         <c:if test="${ not empty currentPayment }">
         
         <fmt:parseDate value="${ currentPayment.start_date }" pattern="yyyy-MM-dd"
								var="parsedDateTimeStartDate" type="both" />
							<fmt:parseDate value="${ currentPayment.end_date }" pattern="yyyy-MM-dd"
								var="parsedDateTimeEndDate" type="both" />
	
	<!-- Modal -->
    <div class="modal fade" id="detailPacket" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered ">
            <div class="modal-content packet  text-center position-relative">
                <div class="modal-header border-0 text-center">

                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center ">
                    <p class=" rounded-circle bg-white position-absolute start-50 translate-middle" style="top: -50px;">
                        <img class="bg-transparent shadow-sm rounded-circle p-3 " height="100px" src="${ pageContext.request.contextPath }/static/img/chuong.png"
                            alt="" srcset="">
                    </p>
                    <h3 class="title mb-3"> Thông tin chi tiết </h3>
                    <p class="font-weight-bold border-top pt-3 mb-0 packet-color packet-price">
                       GIÁ GÓI :  ${currentPayment.price } VND
                      </p>
                      <div class="py-2 border-bottom">
                        <p class="text-wrap">Ngày bắt đầu : <b> <fmt:formatDate pattern="dd/MM/yyyy"
										value="${ parsedDateTimeStartDate }" /> </b></p>
                        <p class="text-wrap">Ngày kết thúc : <b> <fmt:formatDate pattern="dd/MM/yyyy"
										value="${ parsedDateTimeEndDate }" /> </b></p>
                       
                        <small class="fw-light fst-italic my-2">${ currentPayment.description }</small>
                      </div>
                  
                </div>
                <div class="modal-footer row border-0 justify-content-around">
                    <button type="button" class="col-11 col-sm-7  btn btn-primary-change mx-0 rounded-pill"
                        data-bs-dismiss="modal"> Thoát </button>
                   
                </div>
            </div>
        </div>
    </div>
    
      
      </c:if>
      <!-- Welcome Toast after login successfully -->
      <%@include file="/templates/fragments/welcome_login_toast.jspf"%>
   </body>
   <%@include file="/templates/fragments/script_bootstrap5.jspf"%>
   <script
    src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"
  ></script>
   <script>
      const inputEmail = document.getElementById('inputEmail');
      const inputPhonenumber = document.getElementById('inputPhonenumber');
      const inputFullname = document.getElementById('inputFullname');
      const btnEdit = document.getElementById('btnEdit');
      const btnCancel = document.getElementById('btnCancel');
      const btnSave = document.getElementById('btnSave');
      const btnResetPwd = document.getElementById('btnResetPwd');
      const form = document.getElementById('form');
      
      function edit() {
      	inputEmail.disabled = false;
      	inputEmail.classList.add('enableEdit');
      	
      	inputPhonenumber.disabled = false;
      	inputPhonenumber.classList.add('enableEdit');
      	
      	inputFullname.disabled = false;
      	inputFullname.classList.add('enableEdit');
      	
      	btnEdit.classList.add('d-none');
      	btnResetPwd.classList.add('d-none');
      	btnSave.classList.remove('d-none');
      	btnCancel.classList.remove('d-none');
      	
      }
      
      function cancel() {
    	  inputEmail.value = inputEmail.dataset.originvalue;
    	  inputEmail.classList.remove('enableEdit');
    	  
    	  inputPhonenumber.value = inputPhonenumber.dataset.originvalue;
    	  inputPhonenumber.classList.remove('enableEdit');
    	  
    	  inputFullname.value = inputFullname.dataset.originvalue;
    	  inputFullname.classList.remove('enableEdit');
    	  
    	  	btnEdit.classList.remove('d-none');
    	  	btnResetPwd.classList.remove('d-none');
    	  	btnSave.classList.add('d-none');
          	btnCancel.classList.add('d-none');
          	form.classList.remove('was-validated')
      }
      
      function save() {
    	  
      }
      
      (function() {
      	'use strict';
      
      	// Fetch all the forms we want to apply custom Bootstrap validation styles to
      	var forms = document.querySelectorAll('.needs-validation');
      
      	// Loop over them and prevent submission
      	Array.prototype.slice.call(forms).forEach(function(form) {
      		form.addEventListener('submit', function(event) {
      			if (!form.checkValidity()) {
      				event.preventDefault();
      				event.stopPropagation();
      			}
      
      			form.classList.add('was-validated');
      		}, false);
      	});
      })();
   </script>
</html>