<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Quên mật khẩu</title>
        <%@include file="/templates/fragments/header.jspf"%>
    </head>
    <body>
    	
    	<%@include file="/templates/fragments/navigation.jspf" %>
    	
        <!-- đặt lại mật khẩu -->
        <div class="container my-5 p-0">
            <div class="row">
                <div class="col-11 col-sm-8 col-lg-6 col-xl-5 m-auto">
                    <form action="${ pageContext.request.contextPath }/customers/reset-password" method="POST" class="px-sm-5 px-4 py-5 mx-2 bg-white shadow-lg needs-validation form-card" id="resetPwdForm" novalidate>
                        <h2 class="form-header pb-2">
                            Đặt lại mật khẩu
                        </h2>
						
						<!-- old pwd -->
                        <div class="mb-3 w-100">
                            <label for="old_password" class="form-label">Mật khẩu hiện tại</label>
                            <input name="oldPassword" type="password" class="${errorMessage != null ? 'bg-light rounded-pill form-control is-invalid' : 'bg-light rounded-pill form-control'}" id="old_password" placeholder="Current password" required minlength="1" maxlength="20" />
                            <c:if test="${ not empty errorMessage }">
                            	<div id="passwordFeedback" class="invalid-feedback">
                                	${ errorMessage }
                            	</div>
                            </c:if>
                            <c:if test="">
                            	<div id="passwordFeedback" class="invalid-feedback">
                                	Mật khẩu hiện tại không hợp lệ !
                            	</div>
                            </c:if>
                        </div>
                        
                        <!-- pwd -->
                        <div class="mb-3 w-100">
                            <label for="password" class="form-label">Mật khẩu mới( ít nhất 6 kí tự , không quá 20 kí tự )</label>
                            <input name="password" type="password" class="bg-light rounded-pill form-control" id="password" placeholder="Password" required minlength="6" maxlength="20" />
                            <div id="passwordFeedback" class="invalid-feedback">
                                Mật khẩu không hợp lệ !
                            </div>
                        </div>
                        <!-- pwd confirm -->
                        <div class="mb-3 w-100">
                            <label for="password" class="form-label">Nhập lại mật khẩu</label>
                            <input type="password" class="bg-light rounded-pill form-control" id="confirm_password" placeholder="Confirm password" required minlength="6" maxlength="20" />
                            <div id="err" class="invalid-feedback">Mật khẩu không khớp !</div>
                        </div>

                        <button id="btnReset" type="submit" class="btn btn-custom text-center m-auto rounded-pill px-5 w-100">
                            Đặt lại
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </body>
    
    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>
    
    <script>
        //   validate cornfirm pwd
        const password = document.getElementById("password");
        const confirm_password = document.getElementById("confirm_password");
        const error = document.getElementById("err");
        const resetForm = document.getElementById("resetPwdForm");
        const resetBtn = document.getElementById("btnReset");

        function validatePassword() {
            if (password.value !== confirm_password.value) {
                //   show err
                console.warn("err");
                error.classList.remove("d-none");
                confirm_password.classList.add("is-invalid");
                confirm_password.classList.remove("is-valid");
                confirm_password.style.backgroundImage = `url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e")`;
                resetBtn.disabled = true;
                return false;
            }
            if (password.value == confirm_password.value) {
                console.log("OK");
                error.classList.add("d-none");
                confirm_password.classList.add("is-valid");
                confirm_password.classList.remove("is-invalid");
                confirm_password.style.backgroundImage = `url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%23198754' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e")`;
                resetBtn.disabled = false;
                return true;
            }
        }

        password.onchange = validatePassword;
        confirm_password.onkeyup = validatePassword;
        (function () {
            "use strict";

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll(".needs-validation");

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms).forEach(function (form) {
                form.addEventListener(
                    "submit",
                    function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        if (!validatePassword()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add("was-validated");
                        resetBtn.disabled = true;
                    },
                    false
                );
            });
        })();
    </script>
    
    
</html>
