<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Chi tiết gói gửi xe</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
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
                    <div class="carousel-item active" data-bs-interval="2000">
                        <div class=" btn rounded px-lg-5 px-2 py-2 w-100">
                            <a href="">
                                <h5 class="px-4  text-wraps">GÓI THÁNG : SV20K2</h5>
                            </a>
                            <p class="px-4 px-lg-5  text-wrap">
                                Giá gói 20k áp dụng cho các bạn SV Bách Khoa, 30 ngày kể từ
                                ngày đăng kí gói.
                            </p>
                            <button class="btn btn-danger my-3">Đăng kí</button>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                        <div class=" btn rounded px-lg-5 px-2 py-2 w-100">
                            <a href="">
                                <h5 class="px-4  text-wrap">GÓI THÁNG : SV20K2</h5>
                            </a>
                            <p class="px-4 px-lg-5  text-wrap">
                                Giá gói 20k áp dụng cho các bạn SV Bách Khoa, 30 ngày kể từ
                                ngày đăng kí gói.
                            </p>
                            <button class="btn btn-danger my-3">Đăng kí</button>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class=" btn rounded px-lg-5 px-2 py-2 w-100">
                            <a href="">
                                <h5 class="px-4  text-wrap">GÓI THÁNG : SV20K2</h5>
                            </a>
                            <p class="px-4 px-lg-5  text-wrap">
                                Giá gói 20k áp dụng cho các bạn SV Bách Khoa, 30 ngày kể từ
                                ngày đăng kí gói.
                            </p>
                            <button class="btn btn-danger my-3">Đăng kí</button>
                        </div>
                    </div>
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
            <div class="caption btn rounded col-12 col-sm-5 col-xl-3 py-md-4 py-3 mx-2 my-3 shadow-lg">
                <a href="
         ">
                    <h5 class=" text-wrap">GÓI THÁNG : SV20K2</h5>
                </a>
                <p class=" text-wrap">
                    Giá gói 20k áp dụng cho các bạn SV Bách Khoa, 30 ngày kể từ ngày
                    đăng kí gói.
                </p>
                <button class="btn btn-danger my-1">Đăng kí</button>
            </div>
            <div class="caption btn rounded col-12 col-sm-5 col-xl-3 py-md-4 py-3 mx-2 my-3 shadow-lg">
                <a href="
         ">
                    <h5 class=" text-wrap">GÓI THÁNG : SV20K2</h5>
                </a>
                <p class=" text-wrap">
                    Giá gói 20k áp dụng cho các bạn SV Bách Khoa, 30 ngày kể từ ngày
                    đăng kí gói.
                </p>
                <button class="btn btn-danger my-1">Đăng kí</button>
            </div>
            <div class="caption btn rounded col-12 col-sm-5 col-xl-3 py-md-4 py-3 mx-2 my-3 shadow-lg">
                <a href="
         ">
                    <h5 class=" text-wrap">GÓI THÁNG : SV20K2</h5>
                </a>
                <p class=" text-wrap">
                    Giá gói 20k áp dụng cho các bạn SV Bách Khoa, 30 ngày kể từ ngày
                    đăng kí gói.
                </p>
                <button class="btn btn-danger my-1">Đăng kí</button>
            </div>
        </div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
    integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
    integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
    crossorigin="anonymous"></script>
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
