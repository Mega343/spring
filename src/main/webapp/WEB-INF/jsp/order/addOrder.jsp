<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Order Add">
    <jsp:attribute name="error">${error}</jsp:attribute>
<jsp:attribute name="table">
<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="add_order" method="post">
        <p style="color: red">${error}</p>
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Librarian</label>
                    <input class="form-control input-md" type="text" name="librarian_name"
                           value="${librarian.firstName} ${librarian.lastName}"
                           id="librarian_name" readonly>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label>Customer</label>
                        <select class="form-control" name="user_name" id="user_name">
                            <c:forEach var="user" items="${users}">
                                <option value="${user.userID}">${user.firstName} ${user.lastName}</option>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label>Book</label>
                        <select class="form-control" name="book_name" id="book_name">
                            <c:forEach var="book" items="${books}">
                                <option value="${book.bookID}">${book.bookName}</option>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <fieldset class="form-group">
                    <label>Order Type</label>
                    <select class="form-control" name="order_type" id="order_type">
                        <c:forEach var="orderType" items="${orderTypes}">
                            <option value="${orderType.orderTypeID}">${orderType.orderType}</option>
                        </c:forEach>
                    </select>
                </fieldset>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <input class="form-control input-md" type="hidden" name="librarian_id"
                           value="${librarian.userID}"
                           id="librarian_id">
                </div>
            </div>
        </div>


        <div class="form-group row">
            <button class="btn btn-lg btn-primary btn-block" type="submit" style="WIDTH: 235px; HEIGHT: 51px">Add Order
            </button>
        </div>
    </form>
</div>
</jsp:attribute>
    <jsp:attribute name="action">orders</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>