<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/template/hor-navigation.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<h3 class="header">Your Cart</h3>
	</div>
	<div class="row">
		<form id="form_cart">
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

				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<button class="btn wave-effect wave-light" type="submit">
								Check-Out <i class="material-icons right">send</i>
							</button>
							<button class="btn wave-effect wave-light blue" type="button" id="btn_save">
								Save <i class="fa fa-floppy-o right"></i>
							</button>
							<button class="btn wave-effect wave-light red" type="button" id="btn_clear">
								clear<i class="fa fa-trash right"></i>
							</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</div>
	
</script>
<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>