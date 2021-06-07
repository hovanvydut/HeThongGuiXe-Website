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

.list-packet:hover .title::before {
	width: 100%;
}

.history {
	background: rgb(35, 144, 136);
	background: linear-gradient(90deg, rgba(35, 144, 136, 1) 4%,
		rgba(49, 180, 170, 1) 59%, rgba(33, 212, 212, 1) 89%);
	border-radius: 15px !important;
	color: white;
	padding: 5%;
}

.btn-packet {
	background-color: var(- -main-color);
	color: white;
}

.carousel-item {
	width: 100% !important;
	border: none;
}

.carousel-item:hover {
	box-shadow: 2px 2px 4px #9c9999;
}

.packet {
	border-radius: 15px !important;
}

.packet-name {
	color: var(- -main-color);
	font-size: 150%;
	font-weight: 300;
}

.packet-price {
	color: var(- -main-color-bolder);
	font-size: 180%;
	font-weight: 900;
}
</style>

<body>

	<!-- import navigation  -->
	<%@include file="/templates/fragments/navigation.jspf"%>

	<div class="container my-4 my-md-5 px-md-5  px-2">
		<div class="row list-packet">
			<div class="col-12 mb-5">
				<h3 class="text-center text-wrap title m-auto">Tất cả các gói</h3>
			</div>
			<div class=" d-flex justify-content-center flex-wrap row m-auto gx-5">

				<!-- Loop through all objects of List<ParkingPackage> -->
				<c:forEach items="${parkingPackages}" var="parkingPackage">
					<div
						class="
              packet
              text-secondary
              btn
              rounded
             col-11 col-sm-8 col-md-5 col-xl-3
              pb-2
              px-4
              mx-2 mx-md-4
              my-5
              shadow-lg
              position-relative
            ">
						<div style="transform: translateY(-50%)">
							<img class="rounded-circle" width="35%" height="35%"
								src="${ pageContext.request.contextPath }/static/img/xemay.jpg"
								alt="" srcset="" />
						</div>
						<div style="transform: translateY(-10%)">
							<h3 class="text-wrap packet-name border-bottom pb-2 pt-3">
								${parkingPackage.name}</h3>
							<div class="py-2 border-bottom">
								<p class="text-wrap">${parkingPackage.description}</p>
								<p class="text-wrap">
									HSD : <b> ${parkingPackage.duration} ngày </b>
								</p>
								<p class="font-weight-bold mb-0 packet-color packet-price">
									${parkingPackage.price} VND</p>
							</div>

							<div class="d-flex flex-wrap justify-content-around pt-3">
								<button class="btn btn-success my-1 px-4 "
									data-packageName="${parkingPackage.name}"
									data-parkingpackageid="${parkingPackage.ID_package}"
									onclick="showModal(this)">Đăng kí</button>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
		<div class="row list-packet mt-5 mx-2  history">
			<div class="col-12 mb-5">
				<h3 class="text-center text-wrap title m-auto">Lịch sử các gói
					đã đăng kí</h3>
			</div>
			<div class="col-12 table-responsive">
				<table class="table  table-borderless table-hover">
					<thead class="table text-white text-center">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Ngày bắt đầu</th>
							<th scope="col">Ngày kết thúc</th>
							<th scope="col">Giá gói</th>
							<th scope="col">Đã thanh toán</th>
						</tr>
					</thead>
					<tbody class="text-center text-white">
						<c:forEach items="${payments}" var="item" varStatus="loop">
							<fmt:parseDate value="${ item.start_date }" pattern="yyyy-MM-dd"
								var="parsedDateTimeStartDate" type="both" />
							<fmt:parseDate value="${ item.end_date }" pattern="yyyy-MM-dd"
								var="parsedDateTimeEndDate" type="both" />

							<tr>
								<th scope="row">${loop.index + 1}</th>

								<td data-label="Ngày bắt đầu"><fmt:formatDate pattern="dd/MM/yyyy"
										value="${ parsedDateTimeStartDate }" /></td>

								<td data-label="Ngày kết thúc"><fmt:formatDate pattern="dd/MM/yyyy"
										value="${ parsedDateTimeEndDate }" /></td>

								<td data-label="Giá gói">${item.price}</td>

								<c:if test="${ item.paid_at != null }">
									<td data-label="Đã thanh toán"><i class="fas fa-check" style="color: #37b89a;"></i></td>
								</c:if>

								<c:if test="${ item.paid_at == null }">
									<td data-label="Đã thanh toán"><i class="far fa-question-circle"
										style="color: orange;"></i></td>
								</c:if>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	
	
	<!-- Confirm Modal -->
    <div id="confirmModal" class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered ">
            <div class="modal-content packet  text-center position-relative">
                <div class="modal-header border-0 text-center">

                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <p class=" rounded-circle bg-white position-absolute start-50 translate-middle" style="top: -50px;">
                        <img class="bg-transparent shadow-sm rounded-circle p-3" height="100px" src="${ pageContext.request.contextPath }/static/img/notice1.svg"
                            alt="" srcset="">
                    </p>
                    <h3 class="title my-3"> Xác nhận</h3>
                    <p id="modalTitle" class="">
                        Đăng kí gói : SV30                         
                    </p>
                    <small class="fw-light fst-italic my-2"> - Bấm đăng kí để xác nhận đăng kí hoặc hủy để hoàn tác đăng kí - </small>
                </div>
                <div class="modal-footer row border-0 justify-content-around">
                    <button type="button" class="col-11 col-sm-5   btn btn-primary-change mx-0 rounded-pill"
                    data-bs-dismiss="modal"> Hủy </button>
                    <button onclick="submitForm(this)" id="submitBtn" type="button" class="col-11 col-sm-5   btn btn-success-change mx-0 rounded-pill"
                        data-bs-dismiss="modal"> Đăng kí </button>
                   
                </div>
            </div>
        </div>
    </div>
    
    <!-- Notify Modal -->
    <div id="notifyModal" class="modal fade" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered ">
            <div class="modal-content packet  text-center position-relative">
                <div class="modal-header border-0 text-center">

                    <button onclick="closeNotifyModal(this)" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <p class=" rounded-circle bg-white position-absolute start-50 translate-middle" style="top: -50px;">
                        <img class="bg-transparent shadow-sm rounded-circle p-3" height="100px" src="${ pageContext.request.contextPath }/static/img/chuong.png"
                            alt="" srcset="">
                    </p>
                    <h3 class="title my-3"> Thông báo !</h3>
                    <p class="">
                       ⏳ Bạn hiện đã đăng kí một gói vẫn đang trong thời hạn sử dụng.
                    </p>
                    <small class="fw-light fst-italic my-2"> - Bấm để chuyển xem chi tiết gói bạn đã đăng kí - </small>
                </div>
                <div class="modal-footer row border-0 justify-content-around">
                    <a href="${ pageContext.request.contextPath }/customers/info" type="button" class="col-11 col-sm-7   btn btn-primary-change mx-0 rounded-pill"
                        >Xem thông tin </a>
                   
                </div>
            </div>
        </div>
    </div>
    
    <div id="notifyModalUnpaid" class="modal fade" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered ">
            <div class="modal-content packet  text-center position-relative">
                <div class="modal-header border-0 text-center">

                    <button onclick="closeNotifyModal(this)" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <p class=" rounded-circle bg-white position-absolute start-50 translate-middle" style="top: -50px;">
                        <img class="bg-transparent shadow-sm rounded-circle p-3" height="100px" src="${ pageContext.request.contextPath }/static/img/chuong.png"
                            alt="" srcset="">
                    </p>
                    <h3 class="title my-3"> Thông báo !</h3>
                    <p class="">
                        💲Bạn hiện chưa thanh toán những gói đã đăng kí trước đó.
                    </p>
                    <small class="fw-light fst-italic my-2"> - Để đăng kí gói mới, bạn vui lòng thanh toán các gói chưa thanh toán. - </small>
                </div>
            </div>
        </div>
    </div>
    
    <div id="notifyModalSuccess" class="modal fade" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered ">
            <div class="modal-content packet  text-center position-relative">
                <div class="modal-header border-0 text-center">

                    <button onclick="closeNotifyModal(this)" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <p class=" rounded-circle bg-white position-absolute start-50 translate-middle" style="top: -50px;">
                        <img class="bg-transparent shadow-sm rounded-circle p-3" height="100px" src="${ pageContext.request.contextPath }/static/img/chuong.png"
                            alt="" srcset="">
                    </p>
                    <h3 class="title my-3"> Thông báo !</h3>
                    <p class="">
                        🎉 Bạn đẵ đăng kí thành công!
                    </p>
                    <small class="fw-light fst-italic my-2"> - Bạn vui lòng thanh toán các gói đăng kí sớm nhất có thể nhé - </small>
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

<c:if test="${ param.unpaidPayment }">
	<script>
		let modal = new bootstrap.Modal(document.getElementById('notifyModalUnpaid'));
		modal.show();
	</script>
</c:if>

<c:if test="${ param.registerSuccessful }">
	<script>
		let modal = new bootstrap.Modal(document.getElementById('notifyModalSuccess'));
		modal.show();
	</script>
</c:if>

</html>
