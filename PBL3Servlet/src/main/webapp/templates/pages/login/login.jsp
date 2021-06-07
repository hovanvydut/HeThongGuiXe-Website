<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <%@include file="/templates/fragments/header.jspf"%>
    </head>
    
    <body>
        <div
            class="container full-screen my-5 my-md-0">
            <div class="row w-100 border position-relative mx-3"
                style="border-radius: 15px">
                <a class=" navbar-brand d-flex align-items-center position-absolute"
                    href="#"> <img
                    src="${pageContext.request.contextPath}/static/img/logo.png"
                    width="30" height="30" /> <b
                    class="text-white"> Steam</b>
                </a>
                <div
                    class="
                    registered-packet
                    col-md-6 col-xl-4
                    p-4
                    border-end
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
                                        <c:if test="${ errorMessage == null}">
                                            <div id="inputEmailFeedback" class="invalid-feedback">Tên tài khoản không hợp lệ !</div>
                                        </c:if>
                                        <c:if test="${ param.enable == false }">
                                        	<small class="small">Tài khoản đang bị disable!</small>
                                        </c:if>
                                        <label for="inputUsername">Tài khoản</label>
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
                                                    class="txt1"> Chuyển sang <a class="text-theme"
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