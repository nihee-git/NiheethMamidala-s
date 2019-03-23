<%@include file="Header.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<center>
					<b><h2 style="font-size: 350%; color: RGB(26, 92, 183);">Sign
							Up</h2></b>
				</center>
				<br>
				
				<form:form method="post" modelAttribute="user" action="addus">
				<div class="form-group">
						<label for="email">Email</label>
						<form:input type="email" path="emailid" name="emailid"
							class="form-control" required="required" />
						<form:errors path="emailid"></form:errors>
					</div>
					<div class="form-group">
						<label for="username">User Name</label>
						<form:input path="username" class="form-control" name="username"
							required="required" />
						<form:errors path="username"></form:errors>
					</div>
					<div class="form-group">
					<label for="firstname">FirstName</label>
					<form:input path="firstname" class="form-control" name="firstname" required="required"/>
						<form:errors path="firstname"></form:errors>
						</div>
					<div class="form-group">
					<label for="lastname">LastName</label>
					<form:input path="lastname" class="form-control" name="lastname" required="required"/>
						<form:errors path="lastname"></form:errors>
						</div>
					
					
					
					
					<div class="form-group">
						<label for="password">Password</label>
						<form:password path="password" class="form-control"
							name="password" required="required" />
						<form:errors path="password"></form:errors>
					</div>
					<div class="form-group">
						<label for="password">Re Enter Password</label>
						<form:password path="cpassword" class="form-control"
							name="cpassword" required="required" />
						<form:errors path="cpassword"></form:errors>
					</div>
					<center>
						<input type="submit" name="_eventId_submit"
							class="btn btn-primary" value="SUBMIT">&nbsp;&nbsp;<input
							type="reset" name="_eventId_cancel" value="CANCEL"
							class="btn btn-danger" />
					</center>
				</form:form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</div>

