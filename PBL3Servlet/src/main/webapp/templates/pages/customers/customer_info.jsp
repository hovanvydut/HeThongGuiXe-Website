<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
</head>
<style>

</style>

<body>
    
    <!-- import navigation fragment -->
    <%@include file="/templates/fragments/navigation.jspf" %>
    
    <div class=" container my-5">
        <div class="card col-lg-5 col-md-8 col-12 bg-white d-flex m-auto shadow-sm rounded">
            <img class="card-img-top"
                src="https://kenh14cdn.com/Images/Uploaded/Share/2012/03/09/120309kptinhtinh04.jpg"
                alt="user profile image" />
            <div class="card-body text-left">
                <h5 class="card-title">Tên : Trần Thị Phượng </h5>
                <p class="card-text">
                    MSSV : 102190184
                </p>
                <p class="card-text">
                    Khóa : K19
                </p>

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