<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet"
			href="<%=request.getContextPath()%>/resources/style.css" />
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/1.4.5/numeral.min.js"></script>
<jsp:include page="/WEB-INF/jsp/template/hor-navigation.jsp"></jsp:include>
<div class="container">
<div id="preloading">

	<div id="loader-wrapper">
		<div id="loader"></div>
		<div class="loader-section section-left"></div>
    	<div class="loader-section section-right"></div>
	</div>
	<div id="content">
		<div class="row">
			<button class="btn_edit hide" type="submit" value="${dealId}">
		    </button>
			<div class="col s5">
				<div class="card-panel">
					<div class="slider">
						<ul class="responsive-img slides" id="image_item">
							
						</ul>
					</div>
				</div>
			</div>
			
			
			<div class="col s5">
				<div class="card-panel">
					<h5 id="item_name"></h5>
					Mã sản phẩm: ${dealId}
					<div class="point_rate">
						
					</div>
					<label id="lbl_point_rate"></label>
				</div>
				<div class="card-panel">
					<div class="col s4">
						<h6>Giá tham chiếu: </h6>
						<h6>Giá mua: </h6>
					</div>
					<div class="col s8">
						<h6 class="value_reference"></h6>
						<h6 class="value_buy"></h6>
					</div>
					<br></br>
				</div>
				<div class="card-panel">
					<div>
						<h5>Nổi bật</h5>
						<h6 class="item_desciption"></h6>
					</div>
					<div>
						<h5>Thông tin thêm</h5>
						<h6 class="item_descibe"></h6>
					</div>
				</div>
			</div>
			
			<div class="col s2">
				<div class="col s12 card-panel" align="center">
					<h6><b>Giao phiếu điện tử 24h</b></h6>
					Đổi trả trước HSD
					<br></br>
					
					<button class="btn wave-effect wave-light yellow darken-4 btn_buy" value="${dealId}" type="submit">
						<label><font color="white">Mua ngay</font></label><i class="material-icons left">shopping_cart</i>
		      		</button>
		      		<br>
		      		<label>Đặt mua hàng online</label>
		      		<br>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col s10">
				<div class="card-panel">
					<h5>Khách hàng đánh giá</h5>
					<div class="rating">
			
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col s10">
				<div class="card-panel">
					<h5>Hỏi đáp/Bình luận</h5>
					<div class="row">
					    <form class="col s12" id="form_comment">
					      <div class="row">
					        <div class="input-field col s9">
					          <i class="material-icons prefix">mode_edit</i>
					          <textarea id="comment_content" class="materialize-textarea" name="comment_content"></textarea>
					          <label for="comment_content"><%=session.getAttribute("userName") != null ? session.getAttribute("userName") : "Khách hàng"  %></label>
					        </div>
					        <div>
					        	<button class="btn wave-effect wave-light" type="submit">
								Gửi <i class="material-icons right">send</i>
								</button>
					        </div>
					      </div>
					    </form>
					</div>
					<div class="row" id="comment_content_area">
						
					</div>
				</div>
			</div>
		</div>
		<div class="col s10 card-panel teal lighten-2" id="piechart" 
			style="width: 500px; height: 250px; position: absolute">
		</div>
	</div>
</div>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/dealdetail.js">

</script>

<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>