<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
<!--        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/reset-min.css">
        <link rel="stylesheet" href="css/algolia-min.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/docs.min.css">
        <link rel="stylesheet" href="css/index.css">-->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <title>Employee Management</title>
    </head>
    
    <body>
        <main>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!<!-- I want to check my session before showing any content to the user -->




    <jsp:include page="menu.jsp"></jsp:include>

    <div class="form-group"> 	<!--		Show Numbers Of Rows 		-->
        <h6 style="color:black"><b>Entries</b></h6>

        <select class  ="form-control" name="state" id="maxRows" style="width:80px; height: 40px; display: inline-flex">
            <option value="5000">Show ALL Rows</option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="20">20</option>
            <option value="50">50</option>
            <option value="70">70</option>
            <option value="100">100</option>
        </select>		 		
    </div>
<br>
                    <div class="table-body">
                        <table id="table-id" class="table table-bordered table-hover" style="margin-top: -9.5px;">
                            <thead>
                            <c:choose>
                                <c:when test = "${requestScope.noData != null}">
                                    <tr>
                                        <td colspan="5">
                                            <h2 style="border:2px solid rgb(255, 99, 71); background-color:rgba(255, 99, 71, 0.5); font-size:15px;">
                                                <c:out value="${requestScope.noData}"> </c:out>
                                                </h2>
                                            </td>
                                        </tr>
                                </c:when>
                            </c:choose>
                            <tr>
                                <th scope = "col">
                                    Employee Id
                                </th>
                                <th scope = "col">
                                    First Name
                                </th>
                                <th scope = "col">
                                    Last Name
                                </th>
                                <th scope = "col">
                                    Address
                                </th>
                                <th scope = "col">
                                    Phone
                                </th>
                                <th scope = "col">
                                    Gender
                                </th>
                                <th scope = "col">
                                    Age
                                </th>
                                <th scope = "col">
                                    Department
                                </th>
                                <th scope = "col">
                                    Role
                                </th>
                                <th scope = "col">
                                    Basic Salary
                                </th>
                                <th scope = "col">
                                    Car Allowance
                                </th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${empList}" var="emp">
                                <tr>
                                    <td>
                                        ${emp.getEmployeeId()}
                                    </td>
                                    <td>
                                        ${emp.getFirstName()}
                                    </td>
                                    <td>
                                        ${emp.getLastName()}
                                    </td>
                                    <td>
                                        ${emp.getAddress()}
                                    </td>
                                    <td>
                                        ${emp.getPhone()}
                                    </td>
                                    <td>
                                        ${emp.getGender()}
                                    </td>
                                    <td>
                                        ${emp.getAge()}
                                    </td>
                                    <td>
                                        ${emp.getDepartmentName()}
                                    </td>
                                    <td>
                                        ${emp.getRoleName()}
                                    </td>
                                    <td>
                                        ${emp.getBasicSalary()}
                                    </td>
                                    <td>
                                        ${emp.getCarAllowance()}
                                    </td>
                                    <td>
                                        <a href=EditEmployee?employeeId=${emp.employeeId}>
                                            <button class="btn-primary" style="color:blue">Edit</button>
                                            
                                        </a>
                                       
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <jsp:include page="pagination.jsp"></jsp:include>

                    <script src="tablepagination.js"></script>
        </div>

</main></body>
</html>
