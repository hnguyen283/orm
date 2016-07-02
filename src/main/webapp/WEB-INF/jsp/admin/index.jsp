<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>
	
	<div class="row">
		<div class="container">
			<h3 class="header">${title}</h3>
			<div class="row col s12 m12 l6">
				<canvas id="myChart" width="400" height="400"></canvas>
			</div>
			<div class="row">
				<form id="form_tableItem">
					<table class="striped" id="itemTable">
						<thead>
							<tr>
								<td colspan="7"><h4 align="center">Report Item</h4></td>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
						<tfoot>
							
						</tfoot>
					</table>
				</form>
			</div>
		</div>
		
	</div>

	<div class="row" align="center">
	  	<ul class="pagination">
		   
	 	</ul>
  	</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/DashBoardManagement.js">
	
</script>
<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>