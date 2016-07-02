<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/template/hor-navigation.jsp"></jsp:include>
<!-- <div class="container"> -->
	<div class="row">
		<h3 class="header" style="margin-left: 100px;">Kết quả:</h3>
	</div>
	<div class="row">
		<c:forEach items="${images}" var="image">

			<div class="col s12 m3">
				<div class="card medium" id="card_${image.deal_id}">
					<img class="activator responsive-img"
						src="<%=request.getContextPath()%>/resources/image/${image.deal_id}/${image.image_name[0]}">
					<span class="card-title activator grey-text text-darken-4">
						${image.deal.tbl_item.item_name}<i class="material-icons right">more_vert</i>
					</span>
					<div class="card-content">
						<p>
							<a
								href="<%=request.getContextPath()%>/dealDetail/deal/${image.deal_id}">Xem
								chi tiết</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">
							${image.deal.tbl_item.item_name}<i class="material-icons right">close</i>
						</span>
						<p>${image.deal.deal_description}</p>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
	<div class="row">
		<h3 class="header" style="margin-left: 100px;">Mặt hàng khác</h3>
	</div>


	<div class="row">
		<div class="col s12">
			<ul class="tabs">

				<li class="tab col s3"><a class="active" href="#new">Mới
						nhất</a></li>
				<li class="tab col s3"><a href="#nearDeadLine">Gần hết hạn</a></li>
			</ul>
		</div>
		<div id="new" class="col s12">
			<div class='row'>
				<p id="bt_changeSortNew" class="btn waves-effect waves-light">
					Ngược lại <i class="small material-icons">swap_vert</i>
				</p>
			</div>
			<div class='row' id="bodyNew"></div>
		</div>
		<div id="nearDeadLine" class="col s12">
			<div class='row'>
				<p id="bt_changeSortNearDeadLine"
					class="btn waves-effect waves-light">
					Ngược lại <i class="small material-icons">swap_vert</i>
				</p>
			</div>
			<div class='row' id="bodyNearDeadline"></div>
		</div>
	</div>
<!-- </div> -->

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/index.js">
	
</script>
<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>