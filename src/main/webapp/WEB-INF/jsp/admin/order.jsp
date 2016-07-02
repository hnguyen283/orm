
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>

<div class="row">
	<div class="col s10 offset-s2">
		<h3 class="header">${title}</h3>

		<div class="row">
			<form id="form_tableOrder">
				<div class="row">
					<table class="highlight" id="table_order">
						<thead>
							<tr>
								<th>#</th>
								<th>Order No</th>
								<th>Customer Name</th>
								<th>Total</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listOrder}" var="order">
								<tr>
									<td>
										<div class="input-field">
											<input type="checkbox" id="cb_${order.order_id}"
												name="listOrderId" value="${order.order_id}"> <label
												for="cb_${order.order_id}"></label>
										</div>
									</td>
									<td>${order.order_date}</td>
									<td>${order.customer_name}</td>
									<td>${order.customer_phone}</td>
									<td>${order.order_total}</td>
									<td>
										<button class="btn wave-effect wave-light btn-edit"
											value="${order.order_id}">
											Edit <i class="material-icons left">settings</i>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5">
									<button class="btn wave-effect wave-light" id="btn_add">Add</button>
									<button class="btn wave-effect wave-light red darken-4"
										type="submit" id="btn_submit">
										Delete <i class="material-icons right">send</i>
									</button>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</form>
		</div>
	</div>
</div>


<div id="modal_order" class="modal modal-fixed-footer fade">
	<form class="table-hover" id="form_order">
		<div class="modal-content">
			<h4>Create Order Form</h4>
			<div class="row hide">
				<div class="input-field">
					<input name="order_id" id="txt_orderId">
				</div>
			</div>
			<div class="row">
				<div class="input-field col m6 s12">
					<input placeholder="Customer Name" name="customer_name"
						id="txt_customerName" type="text" required="required"> <label
						for="txt_customerName">Customer Name</label>
				</div>
				<div class="input-field col m6 s12">
					<input placeholder="Customer Address" name="customer_address"
						id="txt_customerAddress" type="text" required="required">
					<label for="txt_customerAddress">Address</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field">
					<input placeholder="Customer Email" name="customer_email"
						id="txt_customerEmail" type="text" required="required"> <label
						for="txt_customerEmail">Customer Email</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field">
					<input placeholder="Customer Phone" name="customer_phone"
						id="txt_customerPhone" type="text" required="required"> <label
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
				    <i class="fa fa-usd prefix"></i>
					<input placeholder="Total" name="order_total" id="txt_orderTotal"
						type="number" readonly="readonly"> <label
						for="txt_orderTotal">Total</label>
				</div>
				<div class="input-field col m4 s12">
				    <i class="fa fa-usd prefix"></i>
					<input placeholder="Money Received" name="order_money_receive"
						id="txt_moneyReceived" type="number"> <label
						for="txt_moneyReceived">Money Received</label>
				</div>
				<div class="input-field col m4 s12">
				    <i class="fa fa-usd prefix"></i>
					<input placeholder="Money chances" name="order_money_chance"
						id="txt_moneyChances" type="number" readonly="readonly"> <label
						for="txt_moneyChances">Chance Money</label>
				</div>
			</div>
			<div class="row">
			     <h5>List Order Detail</h5>			
			
				<button type="button" class="btn wave-effect wave-light right"
					id="btn_addOrderDetail">
					<i class="material-icons">playlist-add</i>
				</button>
			</div>
			<div class="row" id="orderDetail_Holder">
				
			</div>
		</div>
		<div class="modal-footer">
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

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/OrderManagement.js">
<!--Order Management-->
	
</script>

<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>