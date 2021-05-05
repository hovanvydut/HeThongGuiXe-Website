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
    * {
        font-family: var(--main-font);
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    a {
        text-decoration: none;
    }

    button {
        background-color: var(--main-color);
    }

    .btn-packet {
        background-color: var(--main-color);
        color: white;
    }

    .check_month {
        border: 1px solid var(--main-color);
        color: var(--main-color);
    }

    .far {
        color: var(--main-color);
    }
</style>

<body>
    
    <!-- import navigation  -->
    <%@include file="/templates/fragments/navigation.jspf" %>
    
    <div
        class="vw-100 d-flex flex-column justify-content-center align-items-center main-container px-md-5 px-2 py-md-5 py-2">
        <div
            class="card w-75 px-md-5 px-2 py-5 mb-5 bg-white d-flex flex-column flex-wrap justify-content-center align-items-center shadow-lg rounded">
            <h3 class="header px-2 px-lg-0">Chi tiết gói</h3>
            <div class="col-lg-6 col-12 p-2">
                <ul class="list-group my-3 px-2 px-lg-0">
                    <li class="list-group-item mb-md-2 mb-1 rounded border-1">
                        <div>
                            <i class="fab fa-accusoft"> Tên gói :</i>
                            <span>KMTHANG1</span>
                        </div>
                    </li>
                    <li class="list-group-item mb-md-2 mb-1 rounded border-1">
                        <div>
                            <i class="fas fa-list-alt"> Loại gói : </i>
                            <span> Gói tháng </span>
                        </div>
                    </li>
                    <li class="list-group-item mb-md-2 mb-1 rounded border-1">
                        <div>
                            <i class="fas fa-money-check-alt"> Giá gói : </i>
                            <span>20.000VND </span>
                        </div>
                    </li>
                    <li class="list-group-item mb-md-2 mb-1 rounded border-1">
                        <div>
                            <i class="fas fa-info-circle"> Thời hạn : </i>
                            <span>30 ngày tính từ ngày đăng kí </span>
                        </div>
                    </li>
                    <li class="list-group-item mb-md-2 mb-1 rounded border-1">
                        <div>
                            <i class="fas fa-unlock"> Trạng thái : </i>
                            <span> Đang mở </span>
                        </div>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</html>