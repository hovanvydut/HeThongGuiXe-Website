<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light px-lg-5 px-4">
    <a class="navbar-brand d-flex align-items-center" href="#">
        <img src="https://sgroupvn.org/_nuxt/img/sgr_logo-symbol.0ce37a9.png" width="30" height="30" alt="S-PBL" />
        <b> S-PBL</b>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Trang Chủ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/history">Tra Cứu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/package-list">Gói gửi xe</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0 flex-grow-1 d-flex justify-content-start justify-content-lg-end">
            <a class="rounded-circle" height="40px" width="40px" href="${pageContext.request.contextPath}/customers/info">
                <i class="fas fa-user"></i>
            </a>
        </form>
    </div>
</nav>