<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tra cứu chi tiết</title>
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
    
    <!-- import navigation fragment -->
    <%@include file="/templates/fragments/navigation.jspf" %>
    
    <div
        class="vw-100 d-flex flex-column justify-content-center align-items-center main-container px-md-5 px-2 py-md-5 py-2">
        <h2 class="font-weight-bold text-uppercase header my-3">Tra Cứu Chi Tiết</h2>
        <div
            class="card w-75 px-md-5 px-4 py-5 mb-5 bg-white d-flex flex-wrap flex-row justify-content-center align-items-start shadow-lg rounded">
            <form class="needs-validation w-100 " novalidate>
                <div class="form-row m-auto">
                    <div class=" col-12 mb-3 ">
                        <label for="validationCustom01">Ngày Gửi Xe</label>
                        <input class="form-control" id="validationCustom01" type="date" value="2011-08-19"
                            id="example-date-input" required>
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                    <div class=" col-12 mb-3">
                        <label for="validationCustom02">Ngày Lấy Xe</label>
                        <input class="form-control" id="validationCustom02" type="date" value="2011-08-19"
                            id="example-date-input" required>

                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>

                </div>

                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                        <label class="form-check-label" for="invalidCheck">
                            Agree to terms and conditions
                        </label>
                        <div class="invalid-feedback">
                            You must agree before submitting.
                        </div>
                    </div>
                </div>
                <button class="btn btn-packet mt-2" type="submit">Tra cứu</button>
            </form>


        </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
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

</html>