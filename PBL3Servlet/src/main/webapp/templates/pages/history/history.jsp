<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Tra cứu</title>
        <%@include file="/templates/fragments/header.jspf" %>
    </head>

    <style>
        
    </style>

    <body>

        <!-- import navigation fragment -->
        <%@include file="/templates/fragments/navigation.jspf" %>
    
        <!-- ==================================== -->
        
        <div class="container bg-transparent overflow-hidden">
        <div class="row list gy-5">
            <div class="col-12 mb-3 mb-sm-5">
                <h3 class="text-center text-wrap title m-auto">Tra cứu thông tin lịch sử gửi xe</h3>
            </div>
           
            <div class="col-12 d-flex justify-content-center flex-wrap row m-auto ">
                <div class="
                  packet
                  text-primary
                  btn
                  rounded
                  col-11 col-sm-8 col-md-4
                  pb-md-4 pb-2
                  px-4
                  mx-2 mx-md-4
                  my-5
                  shadow-lg
                  position-relative
                ">
                    <div style="transform: translateY(-50%)">
                        <img class="rounded-circle" width="35%" height="35%" src="${ pageContext.request.contextPath }/static/img/moto.jpg" alt="" srcset="" />
                    </div>

                    <form action="${pageContext.request.contextPath}/history" method="POST" class="w-100 needs-validation" novalidate style="transform: translateY(-10%)">
                        <h3 class="text-wrap packet-name pb-3">
                            Nhập thông tin tra cứu
                        </h3>
                        <div class="form m-auto my-4">
                            <div class="mb-3 ">
                                <label for="fromDate">Ngày bắt đầu</label>
                                
                                <c:if test="${not empty requestScope.fromDate}">
                                    <input name="fromDate" id="fromDate" class="form-control" type="date" value="${requestScope.fromDate}"
                                           required>
                                </c:if>
                                <c:if test="${empty requestScope.fromDate}">
                                    <input name="fromDate" id="fromDate" class="form-control" type="date" value=""
                                           required>
                                </c:if>
                                
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="toDate">Ngày kết thúc</label>
                                
								<c:if test="${requestScope.toDate != null}">
                                    <input name="toDate" id="toDate" class="form-control" value="${requestScope.toDate}" type="date" 
                                           required>
                                </c:if>
                                <c:if test="${requestScope.toDate == null}">
                                    <input name="toDate" id="toDate" class="form-control" value="" type="date" 
                                           required>
                                </c:if>
                                
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>

                        </div>


                        <button class="btn btn-success mt-2" type="submit">Tra cứu</button>
                    </form>
                </div>
                <b class="col-12 col-md-1 align-self-center text-center " style="transform: translateY(-100%);"> Hoặc</b>
                <div class="
                packet
                text-primary
                btn
                rounded
                col-11 col-sm-8 col-md-4
                pb-md-4 pb-2
                px-4
                mx-2 mx-md-4
                my-5
                shadow-lg
                position-relative
              ">
                  <div style="transform: translateY(-50%)">
                      <img class="rounded-circle" width="35%" height="35%" src="${ pageContext.request.contextPath }/static/img/moto.png" alt="" srcset="" />
                  </div>

                  <div class=" w-100 "  style="transform: translateY(-10%)">
                      <h3 class="text-wrap packet-name pb-3">
                          Tra cứu theo tháng 
                      </h3>
                      <div class="form m-auto my-4">
                        <ul id="list_month" class=" d-flex flex-wrap justify-content-around p-0 my-3">
                            
                          </ul>
                      </div>
                  </div>
              </div>
            </div>
        </div>
        <div class="row list d-flex justify-content-center align-items-center my-5 bg-history "  >
            <div class="col-12 mb-3 mb-sm-5">
                <h3 class="text-center text-wrap title m-auto">
                    Lịch sử thời gian gửi xe
                </h3>
            </div>
            <div class="col-12 table-responsive d-flex justify-content-center align-items-center ">
                <table class="table  table-borderless table-hover">
                    <thead class="table text-white text-center">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Giờ gửi xe <i class="far fa-clock"> </i> </th>
                            <th scope="col">Giờ lấy xe <i class="far fa-clock"> </th>
                            <th scope="col">Biển số xe <i class="fas fa-barcode"></i></th>
                            <th scope="col">Giá lần gửi <i class="fas fa-money-check-alt"></i></th>
                        </tr>
                    </thead>
                    <tbody class="text-center text-white">
                    
                    	<c:forEach items="${history}" var="item">
                    		<fmt:parseDate value="${ item.check_out_at }" pattern="yyyy-MM-dd'T'HH:mm"
                                var="parsedDateTimeCheckOut" type="both" />
                            <fmt:parseDate value="${ item.check_in_at }" pattern="yyyy-MM-dd'T'HH:mm"
                                var="parsedDateTimeCheckIn" type="both" />
	                    	<tr>
	                            <th scope="row">#${loop.index + 1}</th>
	                            <td data-label="Giờ gửi xe">
	                            	<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCheckIn }" />
	                            </td>
	                            <td data-label="Giờ lấy xe">
	                            	<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTimeCheckOut }" />
	                            </td>
	                            <td data-label="Biển số xe">${item.license_plate}</td>
	                            <td data-label="Giá lần gửi">${item.price}</td>
	
	                        </tr>
                    	</c:forEach>
                        
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <ul id="list_form" class="visually-hidden" >
                            
    </ul>

        <!-- Welcome Toast after login successfully -->
        <%@include file="/templates/fragments/welcome_login_toast.jspf" %>
    </body>

    <%@include file="/templates/fragments/script_bootstrap5.jspf" %>
    
    <script>
    	(function() {
    		let dateObj = new Date();
    		let month = dateObj.getUTCMonth() + 1; //months from 1-12
    		let day = dateObj.getUTCDate();
    		let year = dateObj.getUTCFullYear();

    		newdate = year + "-" + (month.length > 1 ? month : '0' + month) + "-" + day;
    		if (document.getElementById("fromDate").getAttribute("value") == "") {
    			document.getElementById("fromDate").setAttribute("value", newdate);
        		document.getElementById("toDate").setAttribute("value", newdate);	
    		}
    		
    	})();
    </script>
    
    <script>
	    // validate
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
	
	    window.addEventListener('load', function() {
	    	(function() {
	    		renderViewMonthButton();
		    })();
	    })
	    
	    function renderViewMonthButton() {
		    	// genring month
			    let ul_list_month = document.getElementById("list_month");
			    let ul_list_form = document.getElementById("list_form");
			    
			    // get now month
			    let month = new Date().getMonth() ;
			    //  genre
			    let i = 0;
			    function genreMonth() {
			        for( i = 0 ; i <= 5 ; i++)
			        {
			            // get previous month
			            let genring_day = new Date();
			            genring_day.setMonth(month - i);
			            let genring_month = genring_day.getMonth() + 1;
			
			            // get first and last day  of month
			            y = genring_day.getFullYear(), m = genring_day.getMonth();
			            let firstDay = new Date(y, m, 1);
			            let firstDayStr = firstDay.getFullYear() + "-" + (  formatMonthORDay(firstDay.getMonth() + 1) ) + "-" + formatMonthORDay(firstDay.getDate());
			            let lastDay = new Date(y, m + 1, 0);
			            let lastDayStr = lastDay.getFullYear() + "-" + (  formatMonthORDay(lastDay.getMonth() + 1) ) + "-" + formatMonthORDay(lastDay.getDate());
			            // add to html
			            ul_list_month.innerHTML += '<button type="submit" form="formMonth' + genring_month + '"  class="btn btn-primary rounded-pill m-1 ">' +   genring_month + "/" + genring_day.getFullYear() + '</button>' ;
			            ul_list_form.innerHTML += '<form id="formMonth' + genring_month + '" action="${ pageContext.request.contextPath }/history" method="POST"><input type="hidden" name="fromDate" type="date" value=' + firstDayStr + ' /><input type="hidden" name="toDate" type="date" value=' + lastDayStr + ' /></form>';
			        }
			    }
			    
			    genreMonth();
		    }
	    
	    function formatMonthORDay(month) {
	    	if (month < 10) {
	    		return "0" + month;
	    	}
	    	return month;
	    }
	</script>	
</html>
