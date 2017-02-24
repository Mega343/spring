<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin title="Book Update">
    <jsp:attribute name="error">${error}</jsp:attribute>
<jsp:attribute name="table">
<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="update_book" method="post">
        <p style="color: red">${error}</p>
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book ID</label>
                    <input class="form-control input-md" type="text" name="book_id" value="${book.bookID}"
                           id="book_id" readonly>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book Name</label>
                    <input class="form-control input-md" type="text" name="book_name" value="${book.bookName}"
                           id="book_name">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-8 col-sm-8 col-md-8">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Author</label>
                    <input class="form-control input-md" type="text" name="author"
                           value="${book.author.firstName} ${book.author.lastName} ${book.author.patronymic}"
                           id="author">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Publishing House</label>
                    <input class="form-control input-md" type="text" name="ph_name"
                           value="${book.ph.publishingHouseName}"
                           id="ph_name">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Genre</label>
                    <input class="form-control input-md" type="text" name="genre" value="${book.genre.genre}"
                           id="genre">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Year of Issue</label>
                    <input class="form-control input-md" type="text" name="year_of_issue" value="${book.yearOfIssue}"
                           id="year_of_issue">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Language</label>
                    <input class="form-control input-md" type="text" name="language"
                           value="${book.language.language}" id="language">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book quantity</label>
                    <input class="form-control input-md" type="text" name="book_quantity" value="${book.bookQuantity}"
                           id="book_quantity">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book in Warehouse</label>
                    <input class="form-control input-md" type="text" name="book_in_warehouse"
                           value="${book.bookInWarehouse}" id="book_in_warehouse">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Shelf</label>
                    <input class="form-control input-md" type="text" name="shelf_number"
                           value="${book.shelf.shelfNumber}"
                           id="shelf_number">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Shelf ID</label>
                    <input class="form-control input-md" type="text" name="shelf_id"
                           value="${book.shelfID}" id="shelf_id" readonly>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book Rate</label>
                    <input class="form-control input-md" type="text" name="book_rate"
                           value="${book.bookRate}" id="book_rate">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Number of Readings</label>
                    <input class="form-control input-md" type="text" name="number_of_readings"
                           value="${book.numberOfReadings}" id="number_of_readings">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-8 col-sm-8 col-md-8">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Book Description</label>
                    <input class="form-control input-md" type="text" name="book_description"
                           value="${book.bookDescription}" id="book_description">
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
    <jsp:attribute name="action">books</jsp:attribute>
    <jsp:attribute name="actionDescription">Back</jsp:attribute>
</t:admin>