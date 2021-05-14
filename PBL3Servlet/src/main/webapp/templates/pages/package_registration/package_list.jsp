<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Chi tiết gói gửi xe</title>
<%@include file="/templates/fragments/header.jspf"%>
</head>
<style>
.btn-packet {
	background-color: var(- -main-color);
	color: white;
}

.caption {
	border: 1px solid var(- -main-color);
	color: var(- -main-color);
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
	<%@include file="/templates/fragments/navigation.jspf"%>

	<div class="container my-4 my-md-5 px-md-5 px-sm-0">
		<div class="row">
			<div class="col-12 col-xl-9 my-4 my-md-5 m-auto">
				<div class="d-flex justify-content-center flex-wrap">
					<h3 class="header col-12 px-3 text-center  text-wrap">Tất cả
						các gói</h3>
					<!-- Loop through all objects of List<ParkingPackage> -->
					<c:forEach items="${parkingPackages}" var="parkingPackage">
						<div
							class="caption btn rounded col-12 col-sm-5 col-xl-3 py-md-4 py-3 mx-2 my-3 shadow-lg">
							<a href="">
								<h5 class=" text-wrap">${parkingPackage.name}</h5>
							</a>
							<p class=" text-wrap">${parkingPackage.description}</p>
							<button type="button" data-packageName="${parkingPackage.name}"
								data-parkingpackageid="${parkingPackage.ID_package}"
								onclick="showModal(this)" class="btn btn-danger my-1">Đăng
								kí</button>
						</div>
					</c:forEach>

				</div>
			</div>





			<div
				class="col-12 col-xl-9 my-4 my-md-5 bg-white shadow-lg rounded m-auto">
				<h3
					class="header p-2 p-md-3 text-center border-bottom  border-info border-2  text-wrap">
					Các gói đã đăng kí</h3>

				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Start</th>
							<th scope="col">End</th>
							<th scope="col">Price</th>
							<th scope="col">Paid</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${payments}" var="item" varStatus="loop">
							<fmt:parseDate value="${ item.start_date }" pattern="yyyy-MM-dd"
								var="parsedDateTimeStartDate" type="both" />
							<fmt:parseDate value="${ item.end_date }" pattern="yyyy-MM-dd"
								var="parsedDateTimeEndDate" type="both" />

							<tr>
								<th scope="row">${loop.index + 1}</th>

								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${ parsedDateTimeStartDate }" /></td>

								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${ parsedDateTimeEndDate }" /></td>

								<td>${item.price}</td>

								<c:if test="${ item.paid_at != null }">
									<td><i class="fas fa-check" style="color: #37b89a;"></i></td>
								</c:if>

								<c:if test="${ item.paid_at == null }">
									<td><i class="far fa-question-circle"
										style="color: orange;"></i></td>
								</c:if>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

		</div>
	</div>


	<div id="confirmModal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Thông báo</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p id="modalTitle"></p>
				</div>
				<div class="modal-footer">
					<button onclick="submitForm(this)" id="submitBtn" type="button"
						class="btn btn-primary">Đồng ý</button>

					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Không</button>
				</div>
			</div>
		</div>
	</div>


	<div id="notifyModal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Thông báo</h5>
					<button onclick="closeNotifyModal(this)" type="button"
						class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Bạn hiện đang đăng kí một gói khác vẫn còn thời hạn</p>
					<p>Truy cập trang thông tin cá nhân để biết thêm chi tiét</p>
				</div>
				<div class="modal-footer">
					<a href="${ pageContext.request.contextPath }/customers/info"
						type="button" class="btn btn-info">Thông tin cá nhân</a>
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>


	<form id="registerForm"
		action="${pageContext.request.contextPath}/parking-package/register"
		method="POST">
		<input id="parkingPackageIdInput" name="parkingPackageId"
			type="hidden" value="" />
	</form>
	<!-- Welcome Toast after login successfully -->
	<%@include file="/templates/fragments/welcome_login_toast.jspf"%>

</body>

<%@include file="/templates/fragments/script_bootstrap5.jspf"%>

<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
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

<script>
	function showModal(event) {
		let parkingPackageId = event.dataset.parkingpackageid;
		let myModal = new bootstrap.Modal(document
				.getElementById('confirmModal'))
		let modalTitle = document.getElementById("modalTitle");

		document.getElementById("parkingPackageIdInput").value = parkingPackageId;
		modalTitle.innerText = "Đăng kí gói: " + event.dataset.packagename;
		myModal.show();

		return;
	}

	function submitForm() {
		let myModal = new bootstrap.Modal(document
				.getElementById('confirmModal'))
		myModal.hide();
		let form = document.getElementById("registerForm");
		form.submit();
	}
</script>


<c:if test="${ param.currentPayment }">
	<script>
		let modal = new bootstrap.Modal(document.getElementById('notifyModal'));
		modal.show();
	</script>
</c:if>
</html>
