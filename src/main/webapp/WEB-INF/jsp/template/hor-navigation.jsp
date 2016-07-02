<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.context.annotation.Import"%>
<%@page import="com.csc.service.TypeService"%>
<%@page import="org.springframework.beans.factory.annotation.Qualifier"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row teal darken-2">
	<div class="container">
		<div class="row">
			<div class="col m2">
				<div class="input-field">
					<a href="<%=request.getContextPath()%>"> <img style="height: 50px;width: 80px;" class="col m12"
						src="<%=request.getContextPath()%>/resources/img-res/logo.png" />
					</a>
				</div>
			</div>
			<div class="col m6 offset-m1">
				<form id="form_search"
					action="<%=request.getContextPath()%>/search/" method="get">
					<div class="input-field">
						<input class="col m10"
							placeholder="Item Name, Categories, Provider..."
							name="search_content">

						<button class="btn wave-effect wave-light col m2" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</form>
			</div>

			<div class="col m3 user-tool">
				<div class="col m6 div_cart">
					<div class="input-field center">
						<a class='dropdown-button btn teal darken-2'
							data-beloworigin="true" href='<%=request.getContextPath()%>/cart'
							data-activates='dropDownCart'> <i class="fa fa-shopping-cart"></i><span
							class="badge red darken-2" id="span_badgeSize">0</span>
						</a>

						<!-- Dropdown Structure -->
						<ul id='dropDownCart' class='dropdown-content'>
							<li><a href="#!">Item in cart:<span id="span_cartSize"></span> </a></li>
							<li><a href="#!">Total: <span id="span_cartTotal"></span></a></li>
							<li class="divider"></li>
							<li><a href="<%=request.getContextPath() %>/api/cart/clear" ><i class="fa fa-eraser"></i>Clear</a></li>
						</ul>
					</div>
				</div>
				<div class="col m6 div_user">
					<div class="input-field center">
						<!-- Dropdown Trigger -->
						<a class='dropdown-button btn teal darken-2'
							data-beloworigin="true" href='<%=request.getContextPath() %>/login' data-activates='dropDownUser'>
							<i class="fa fa-user"></i>
						</a>

						<!-- Dropdown Structure -->
						<ul id='dropDownUser' class='dropdown-content'>
							<li><a href="#!" id="register"><i class="fa fa-cog"></i>Register</a></li>
							<li class="divider"></li>
							<%if(request.getSession().getAttribute("userId") != null){ %>
							<li><a href="#!" class="btn_logout"><i class="fa fa-sign-out"></i>sign-out</a></li>
							<%} %>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="container">
		<div class="col m3 menu">
			<ul class="collapsible" data-collapsible="accordion">
				<%-- 				<c:forEach items="${listType}" var="type"> --%>
				<!-- 					<li> -->
				<!-- 						<div class="collapsible-header"> -->
				<%-- 							<i class="${type.type_icon}"></i>${type.type_name} --%>
				<!-- 						</div> -->
				<!-- 						<div class="collapsible-body"> -->
				<%-- 							<p>${type.type_description}</p> --%>
				<!-- 						</div> -->
				<!-- 					</li> -->
				<%-- 				</c:forEach> --%>

			</ul>
		</div>
		<div class="col m9">
			<div class="slider">
				<ul class="responsive-img slides">
					<li>
					<img src="/orm/resources/image/19/237448-tranh-3d.jpg"> <!-- random image -->
						<div class="caption center-align">
<!-- 							<h3>This is our big Tagline!</h3> -->
<!-- 							<h5 class="light grey-text text-lighten-3">Here's our small -->
<!-- 								slogan.</h5> -->
						</div>
					</li>
					<li><img src="/orm/resources/image/28/224325-hongkong-town-sc-vivo-citdy-buffet-toi-lau-hai-san-bo-my.jpg"> <!-- random image -->
						<div class="caption center-align">
<!-- 							<h3>This is our big Tagline!</h3> -->
<!-- 							<h5 class="light grey-text text-lighten-3">Here's our small -->
<!-- 								slogan.</h5> -->
						</div>
					</li>
					<li><img src="/orm/resources/image/14/200273-tay-cam-choi-game-bluetooth-ipega-9037.jpg"> <!-- random image -->
						<div class="caption center-align">
<!-- 							<h3>This is our big Tagline!</h3> -->
<!-- 							<h5 class="light grey-text text-lighten-3">Here's our small -->
<!-- 								slogan.</h5> -->
						</div>
					</li>
					<li><img src="/orm/resources/image/20/240889-phu-quoc-tour-lan-binh-khi-ngam-san-ho-nam-dao-phu-quoc-1-ngay-danh-cho-01-nguoi.jpg"> <!-- random image -->
						<div class="caption center-align">
<!-- 							<h3>This is our big Tagline!</h3> -->
<!-- 							<h5 class="light grey-text text-lighten-3">Here's our small -->
<!-- 								slogan.</h5> -->
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>