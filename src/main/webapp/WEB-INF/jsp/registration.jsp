<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Website CSS style -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Website Font style -->
    <link rel="icon" href="/resources/images/icon.png">
    <link rel="stylesheet" href="/resources/signin/signin.css">
    <title>Registration</title>
</head>
<body>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Sign up. All fields are required.</h3>
                    <div class="text-center">
                        <c:if test="${not empty error}">
                            <div class="error" style="color: red">${error}</div>
                        </c:if>
                    </div>
                    <div class="panel-body">
                        <form:form action="registration" modelAttribute="user">
                            <div class="form-group">
                                <label for="firstNameInput">First Name </label>
                                <form:input path="firstName" id="firstNameInput"/>
                                <br/>
                            </div>
                            <div class="form-group">
                                <label for="lastNameInput">Last Name </label>
                                <form:input path="lastName" id="lastNameInput"/>
                                <br/>
                            </div>
                            <div class="form-group">
                                <label for="emailInput">Email </label>
                                <form:input path="email" id="emailInput"/>
                                <br/>
                            </div>
                            <div class="form-group">
                                <label for="phoneNumberInput">Phone Number </label>
                                <form:input path="phoneNumber" id="phoneNumberInput"/>
                                <br/>
                            </div>
                            <div class="form-group">
                                <label for="passwordInput">Password </label>
                                <form:input path="password" id="passwordInput"/>
                                <br/>
                            </div>
                            <div class="form-group">
                                <label for="passwordConfirmInput">Confirm Pass</label>
                                <input name="confirmPassword" id="passwordConfirmInput"/>
                                <br/>
                            </div>
                            <input type="submit" value="Register" class="btn btn-info btn-block">
                        </form:form>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>