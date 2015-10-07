<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration Form</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script src="scripts/register.js"></script>
</head>


<body>
	<div class="container">
		<h2>Registration form</h2>
		<div data-ng-app="registerApp"
			data-ng-controller="registerAppController">

			<form data-ng-submit="submit()" name="registerForm" data-role="form"
				id="registerForm">

				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" placeholder="Enter email"
						data-ng-model="pageData.email" name="email" required="required">
				</div>
				
				<div class="form-group">
					<label for="firstname">FirstName:</label> <input type="text"
						class="form-control" id="firstname" placeholder="Enter First Name"
						data-ng-model="pageData.firstname" name="firstname" required="required">
				</div>
				

				<button type="submit" class="btn btn-primary"
					data-ng-disabled="registerform.$invalid">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>