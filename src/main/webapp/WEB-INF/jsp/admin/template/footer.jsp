<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="modalCommitDelete" style="width: 380px" class="modal">

	<div class="modal-content">
		<h4>Confirm</h4>
		<div class="row">
			<p class="red-text center">Are you sure delete these</p>
		</div>
	</div>
	<div class="modal-footer">
		<div style="padding-right: 40px">
			<button
				class="modal-action waves-effect waves-green btn right modal-close"
				type="submit" name="action" id="bt_submitDelete">
				Yes <i class="material-icons right">done</i>
			</button>
		</div>
		<div style="padding-left: 40px">
			<button
				class="btn wave-effect wave-light red darken-4 left modal-close"
				type="submit">
				No <i class="material-icons right">not_interested</i>
			</button>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/materialize.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript">
<!--collapse mobile navbar-->
	$(document).ready(function() {
		$('.modal-trigger').leanModal();
		$(".button-collapse").sideNav();
		$('select').material_select();
		$(".dropdown-button").dropdown();
		$('.datepicker').pickadate({
			selectMonths : true, // Creates a dropdown to control month
			selectYears : 15
		// Creates a dropdown of 15 years to control year
		});
	});

	function alertMessage(content) {
		Materialize.toast(content, 3000);
	}
</script>
</body>
</html>