<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/template/hor-navigation.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/recaptcha_ajax.js">
<!--Captcha JS-->
</script>
<div class="container" onload="return reloadRecaptcha();">
	<div class="row">
		<h3 class="header">Your Cart</h3>
	</div>
	<div class="row">
		<form id="form_order">
			<div class="row">
				<div class="row hide">
					<div class="input-field">
						<input name="user_id" id="txt_userId" readonly="readonly"
							value="${tbl_user.user_id}">
					</div>
				</div>
				<div class="row">
					<div class="input-field col m6 s12">
						<input placeholder="Customer Name" name="customer_name"
							id="txt_customerName" type="text" required="required"
							value="${tbl_user.user_name}"> <label
							for="txt_customerName">Customer Name</label>
					</div>
					<div class="input-field col m6 s12">
						<input placeholder="Customer Address" name="customer_address"
							id="txt_customerAddress" type="text" required="required"
							value="${tbl_user.user_address}"> <label
							for="txt_customerAddress">Address</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<input placeholder="Customer Email" name="customer_email"
							id="txt_customerEmail" type="text" required="required"
							value="${tbl_user.user_email}"> <label
							for="txt_customerEmail">Customer Email</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<input placeholder="Customer Phone" name="customer_phone"
							id="txt_customerPhone" type="text" required="required"
							value="${tbl_user.user_phone }"> <label
							for="txt_customerPhone">Phone</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<textarea rows="3" class="materialize-textarea"
							placeholder="Comment" name="customer_comment"
							id="txt_customerComment"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="input-field col m4 s12">
						<i class="fa fa-usd prefix"></i> <input placeholder="Total"
							name="order_total" id="txt_orderTotal" type="number"
							readonly="readonly"> <label for="txt_orderTotal">Total</label>
					</div>
				</div>
				<div class="row">
					<h5>List Order Detail</h5>
				</div>
				<div class="row" id="orderDetail_Holder">
					<table class="table-hover" id="table_listItem">
						<thead>
							<tr>
								<th>#</th>
								<th>Item-Deal</th>
								<th>Amount</th>
								<th>Price</th>
								<th>total</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cart}" var="c">
								<tr>
									<td></td>
									<td>${c.deal.tbl_item.item_name}</td>
									<td>${c.amount }</td>
									<td>${c.deal.deal_price }</td>
									<td>${c.deal.deal_price * c.amount}</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<button type="submit" class="btn wave-effect wave-light">
					Submit<i class="material-icons right">send</i>
				</button>
				<button type="reset"
					class="btn wave-effect wave-light yellow darken-4">
					Reset <i class="material-icons right">replay</i>
				</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/checkout.js">
<!--check out js-->
	var remoteIp = "<%=request.getRemoteAddr()%>";
</script>
<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>