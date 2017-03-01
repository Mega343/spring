<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="User Update">
    <jsp:attribute name="error">${error}</jsp:attribute>
<jsp:attribute name="table">
<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="update" method="post">

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">User ID</label>
                    <input class="form-control input-md" type="text" name="user_id" value="${user.userID}"
                           id="user_id" readonly>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label>User Role</label>
                        <select class="form-control" name="user_role" id="user_role">
                            <option ${user.role.userRole.equals("Guest")?"selected":""}>Guest</option>
                            <option ${user.role.userRole.equals("Reader")?"selected":""}>Reader</option>
                            <option ${user.role.userRole.equals("Librarian")?"selected":""}>Librarian</option>
                            <option ${user.role.userRole.equals("Admin")?"selected":""}>Admin</option>
                        </select>
                    </fieldset>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">First Name</label>
                    <input class="form-control input-md" type="text" name="first_name" value="${user.firstName}"
                           id="first_name">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Last Name</label>
                    <input class="form-control input-md" type="text" name="last_name" value="${user.lastName}"
                           id="last_name">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Email</label>
                    <input class="form-control input-md" type="email" name="email" value="${user.email}"
                           id="email">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Phone</label>
                    <input class="form-control input-md" type="text" name="phone_number"
                           value="${user.phoneNumber}" id="phone_number">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Password</label>
                    <input class="form-control input-md" type="password" name="password" value="${user.password}"
                           id="password">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Confirm Password</label>
                    <input class="form-control input-md" type="password" name="confirm_password"
                           value="${user.password}" id="confirm_password">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">City</label>
                    <input class="form-control input-md" type="text" name="city_name" value="${user.address.cityName}"
                           id="city_name">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Street</label>
                    <input class="form-control input-md" type="text" name="street_name"
                           value="${user.address.streetName}" id="street_name">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">House Number</label>
                    <input class="form-control input-md" type="text" name="house_number"
                           value="${user.address.houseNumber}" id="house_number">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Flat Number</label>
                    <input class="form-control input-md" type="text" name="flat_number"
                           value="${user.address.flatNumber}" id="flat_number">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <input type="hidden" class="form-control input-md" name="address_id"
                           value="${user.address.addressID}" id="address_id">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <input class="form-control input-md" type="hidden" name="document_id"
                           value="${user.document.documentID}" id="document_id">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md4">
                <div class="form-group row">
                    <input class="form-control input-md" type="hidden" name="document_type_id"
                           value="${user.document.documentTypeID}" id="document_type_id">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label>Document Type</label>
                        <select class="form-control" name="document_type" id="document_type">
                            <option ${user.document.documentType.documentType.equals("Passport")?"selected":""}>
                                Passport
                            </option>
                            <option ${user.document.documentType.documentType.equals("Driver licence")?"selected":""}>
                                Driver
                                licence
                            </option>
                        </select>
                    </fieldset>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Series</label>
                    <input class="form-control input-md" type="text" name="series" value="${user.document.series}"
                           id="series">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Number</label>
                    <input class="form-control input-md" type="text" name="number" value="${user.document.number}"
                           id="number">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Issued By</label>
                    <input class="form-control input-md" type="text" name="issued_by" value="${user.document.issuedBy}"
                           id="issued_by">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Data Of Issue</label>
                    <input class="form-control input-md" type="text" name="date_of_issue"
                           value="${user.document.dateOfIssue}" id="date_of_issue">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">User Karma</label>
                    <input class="form-control input-md" type="text" name="karma" value="${user.karma}" id="karma">
                </div>
            </div>
        </div>

        <div class="form-group row">
            <button class="btn btn-lg btn-primary btn-block" type="submit" style="WIDTH: 235px; HEIGHT: 51px">Update
            </button>
        </div>
    </form>
</div>
</jsp:attribute>
    <jsp:attribute name="action">admin</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>