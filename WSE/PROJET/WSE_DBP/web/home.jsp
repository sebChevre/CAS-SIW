<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet" type="text/css">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script src="http://d3js.org/d3.v3.min.js"></script>
	<script src="http://labratrevenge.com/d3-tip/javascripts/d3.tip.v0.6.3.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/home.js"></script>
</head>

<body>
	
	<div id="wrapper">
	
		<div id="populationBarVisu">
			
			<div id="filterForm">
				
				<fieldset>
					<legend>Filtre</legend>
					<div class="form-group">
						
						<select id="nombres_valeurs"  class="form-control" >
							<option value="10">les 10 valeurs</option>
							<option value="20">les 20 valeurs</option>
							<option value="30">les 30 valeurs</option>
							<option value="all">tout</option>
							
						</select>
					</div>
					<div class="form-group">
						
						<select id="sens_valeurs" class="form-control">
							<option value="+"> les plus hautes</option>
							<option value="-">les plus basses</option>
						</select>
					</div>
				</fieldset>
			</div>
			
			<div id="barChartZone"></div>
		</div>
	</div>
</body>
</html>