<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <%@include file="/templates/fragments/header.jspf"%>
    </head>
    <style>
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
        <div
            class="
            container
            my-5
            d-flex
            justify-content-center
            align-items-center
            px-0
            ">
            <div class="row w-100 h-100 border position-relative mx-3"
                style="border-radius: 15px">
                <a class=" navbar-brand d-flex align-items-center position-absolute"
                    href="#"> <img
                    src="${pageContext.request.contextPath}/static/img/logo.png"
                    width="30" height="30" alt="S-PBL" /> <b
                    class="text-white"> S-PBL</b>
                </a>
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
                    ">
                    <i class="fas fa-motorcycle fa-7x mt-2 text-white"></i>
                    <div class="header my-2 border-0 bg-transparent text-white">
                        XIN CHÀO,
                    </div>
                    <p class="text-white text-center">Đăng nhập để tra cứu !</p>
                </div>
                <div class="col-md-6 col-xl-8 align-self-center">
                    <div class="card pt-4 border-0">
                        <div class="card-header header border-0 bg-white m-auto">
                            Đăng nhập
                        </div>
                        <div class="">
                            <form name="loginForm" id="loginForm" class="needs-validation" novalidate action="${pageContext.request.contextPath}/login" method="POST">
                                <c:if test="${param.from != null}">
                                    <input name="from" type="hidden" value="${param.from}" />
                                </c:if>
                                <div class="row mb-3">
                                    <div class="col-10 form-floating offset-1 mb-3 px-0">
                                        <input name="username" type="text" class="${errorMessage != null ? 'form-control is-invalid bg-white' : 'form-control bg-white'}"
                                            id="inputUsername" value="${ username }" required />
                                        <c:if test="${errorMessage != null}">
                                            <div id="inputEmailFeedback" class="invalid-feedback">${errorMessage}</div>
                                        </c:if>
                                        <c:if test="${ empty errorMessage}">
                                            <div id="inputEmailFeedback" class="invalid-feedback">Username không hợp lệ !</div>
                                        </c:if>
                                        <label for="inputUsername">Username</label>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-10 form-floating offset-1 mb-3 px-0">
                                        <input name="password" type="password" class="${errorMessage != null ? 'form-control is-invalid bg-white' : 'form-control bg-white'}"
                                            id="inputPwd" required minlength="6" maxlength="20" disable />
                                        <c:if test="${errorMessage != null}">
                                            <div id="inputPasswordFeedback" class="invalid-feedback">${errorMessage}</div>
                                        </c:if>
                                        <c:if test="${ empty errorMessage}">
                                            <div id="inputPasswordFeedback" class="invalid-feedback">Mật
                                                khẩu không hợp lệ !
                                            </div>
                                        </c:if>
                                        <label for="inputPwd">Mật Khẩu</label>
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
                                        <div class="mb-3 w-100">
                                            <div class="text-center p-t-12">
                                                <small class="txt1">Bạn chưa có tài khoản ?</small> <br /> <small
                                                    class="txt1"> Chuyển sang <a class="txt2"
                                                    href="${ pageContext.request.contextPath }/sign-up"> Đăng kí </a></small>
                                            </div>
                                        </div>
                                        <button
                                            class="
                                            btn
                                            w-100
                                            btn-custom
                                            my-3
                                            rounded-pill
                                            text-white
                                            "
                                            id="btnSubmit" type="submit">
                                        Đăng nhập</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="/templates/fragments/script_bootstrap5.jspf"%>
    <script>
        (function () {
            'use strict';
        
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation');
        
            // Loop over them and prevent submission
            Array.prototype.slice.call(forms).forEach(function (form) {
              form.addEventListener(
                'submit',
                function (event) {
                  if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                  }
        
                  form.classList.add('was-validated');
                },
                false
              );
            });
          })();
        
        
        document.getElementById("loginForm").addEventListener("submit", function (event) {
            document.getElementById("btnSubmit").disabled = true;
        });
    </script>
</html>