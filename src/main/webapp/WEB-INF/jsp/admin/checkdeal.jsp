<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#colorover {
		color:silver !important;
	}
	#coloremer
	{
		color:red !important;
	}
	#colordanger
	{
		color:aqua !important;
	}
</style>



<div class="row">

	<div class="col m10 s12 offset-m2">
		<h3 class="header">Deal Management</h3>
		<form id="form_deal">
			<div class="row">
				<table id="table_deal">
					<thead>
						<tr>
							<th>#</th>
							<th>Deal Owner</th>
							<th>Deal End</th>
							<th>Deal Discount</th>
							<th> Deal Amount</th> 
	  						<th>Deal Acceptable</th>
							<th>Deal Description</th>
							<th>Deal Status</th>	
							<th>	</th>
							
						</tr>
					</thead>
					<tbody>
					<%--  	<c:forEach items="${deal}" var="deal">
									<jsp:useBean id="now" class = "java.util.Date" scope= "request"  ></jsp:useBean>
									<c:set var="dealtime" value="${deal.deal_end}" />

											<fmt:parseDate value="${dealtime}" var="date" 
                              					pattern="yyyy-MM-dd" />
									<c:set  var="otherDays" 
							    		 value="${ (date.time - now.time) / (1000*60*60*24) }"> </c:set>
									<fmt:formatNumber type="number" 
            							maxFractionDigits="0" value="${otherDays}" var = "nam"  />
										<fmt:parseNumber var="i" type="number" value="${nam}" />
										<c:choose>
    									<c:when test="${nam lt 1}">
    										<tr id="colorover">			
    													<td> ${deal.deal_id}</td>
						
														<td>${deal.deal_owner}</td>
														<td>${deal.deal_end} </td>
														<td>${deal.deal_discount}</td>
														<td>${deal.deal_amount} </td>
														<td>${deal.deal_acceptable} </td>
														<td>${deal.deal_description} </td>
														<td>${deal.deal_status} </td>
														<c:if test="${deal.deal_status eq 'ACTIVE'} ">
															<td><button class="waves-effect waves-light btn"
																id="btn_cancel" value="${deal.deal_id}">Cancel</button>
															</td>
														</c:if>
												</tr>
    									</c:when>
   										 <c:when test="${nam eq 1}">
   										 <tr id="coloremer">			
    													<td> ${deal.deal_id}</td>
						
														<td>${deal.deal_owner}</td>
														<td>${deal.deal_end} </td>
														<td>${deal.deal_discount}</td>
														<td>${deal.deal_amount} </td>
														<td>${deal.deal_acceptable} </td>
														<td>${deal.deal_description} </td>
														<td>${deal.deal_status} </td>
														<td><button class="waves-effect waves-light btn"
																id="btn_addtime" value="${deal.deal_id}">Cancel</button>
														</td>
														<td><button class="waves-effect waves-light btn"
																id="btn_cancel" value="${deal.deal_id}">Cancel</button>
														</td>
												</tr>
   										 </c:when>
   										 <c:when test="${ (nam lt 5) and (nam gt 1) }">
   										 		<tr id="colordanger">			
    													<td> ${deal.deal_id}</td>
						
														<td>${deal.deal_owner}</td>
														<td>${deal.deal_end} </td>
														<td>${deal.deal_discount}</td>
														<td>${deal.deal_amount} </td>
														<td>${deal.deal_acceptable} </td>
														<td>${deal.deal_description} </td>
														<td>${deal.deal_status} </td>
														<td><button class="waves-effect waves-light btn"
																id="btn_cancel" value="${deal.deal_id}">Cancel</button>
														</td>
												</tr>
   										 </c:when>
   										 <c:otherwise> 
   										 		<tr>			
    													<td> ${deal.deal_id}</td>
						
														<td>${deal.deal_owner}</td>
														<td>${deal.deal_end} </td>
														<td>${deal.deal_discount}</td>
														<td>${deal.deal_amount} </td>
														<td>${deal.deal_acceptable} </td>
														<td>${deal.deal_description} </td>
														<td>${deal.deal_status} </td>
														<td><button class="waves-effect waves-light btn"
																id="btn_cancel" value="${deal.deal_id}">Cancel</button>
														</td>
												</tr>
   										  </c:otherwise>
   										</c:choose>
								
							
						</c:forEach> --%>
					</tbody>
					
				</table>
				
				
			</div>
		</form>
		
<div id="editdeal" class="modal modal-fixed-footer fade">
	<form id="dealForm" accept-charset="UTF-8">
		<div class="modal-content">
			<h4 id = "h4_form" align = "center">  </h4>

			<div class="row hide">
				<div class="input-field">
					<input name="deal_id" id="deal_id" type="text">
					<label for="deal_id"></label>
				</div>
			</div>
			<div class="row">
				<div class="input-field">
						<label for=""></label> <input placeholder="deal end date"
							id="txt_dealEnd" name="deal_end" type="date"
							class="validated datepicker">
					</div>
					
					
					<div class="input-field col s6">
   				 		<select id = "deal_status" name = "deal_status">
     					 <option value="CANCEL" disabled selected>Choose status of deal</option>
      						<option value="CANCLE">Cancel</option>
      						<option value="ACTIVE">Active</option>
      						
      					
    					</select>
    					<label>Deal Status</label>
					</div>
			</div>
			
		</div>

		<div class="modal-footer">
			<button
				class="modal-close btn wave-effect wave-light"
				type="submit" name="action" id="bt_submitAddType">
				Submit <i class="material-icons right">send</i>
			</button>
			<button
				class="modal-action waves-effect waves-green btn-flat yellow darken-4"
				id="bt_cancel" type="reset">
				Reset <i class="material-icons right">close </i>
			</button>

		</div>
		<div id="erroraddType" style="color: red; text-align: center"></div>

	</form>
</div>
	</div>
</div>
<div class="row" align="center">
	<ul class="pagination">
		   
	</ul>
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/DealReportManagement.js">
</script>

		



<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>