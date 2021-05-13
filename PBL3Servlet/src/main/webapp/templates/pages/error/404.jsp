<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>404 not found</title>
	<%@include file="/templates/fragments/header.jspf"%>
	<style>
		.btn-custom {
			background-color: var(- -main-color);
		}
	</style>
</head>

<body>
	<!-- https://thumbs.dreamstime.com/b/warning-sign-23510325.jpg -->
	<!-- quên mật khẩu -->
	<div class="container vw-100 vh-100 ">
		<div class="row w-100 h-100 m-0">
			<div
				class="col-11 col-md-8 col-lg-6 col-xl-5 m-auto position-relative">
				<div class="card border-0 text-center">
					<h1 class="fw-bold" style="font-size: 133px">404</h1>
					<div class="card-body ">
						<h1 class="card-title fw-bold">OOPS ! SORRY !</h1>
						<p class="card-text my-3">Trang bạn tìm kiếm có vẻ như không
							tồn tại :(</p>
						<a href="${pageContext.request.contextPath}/home" style="width: fit-content; background: red;"
							class="btn btn-custom px-5 py-3 my-3 rounded-pill text-white">Về
							Trang Chủ</a>
					</div>
				</div>
				<img src="${pageContext.request.contextPath}/static/img/warning.jpg"
					class="card-img-top m-auto mt-5 mb-3 d-none d-sm-block position-absolute top-0 start-100"
					style="width: 20%" alt="...">
			</div>

		</div>
	</div>
</body>

</html>
