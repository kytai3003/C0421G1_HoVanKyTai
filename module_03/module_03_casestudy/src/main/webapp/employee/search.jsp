<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style>
        #name:hover {
            color: #523e02;
        }
        input {
            outline: none;
        }
        input[type=search] {
            -webkit-appearance: textfield;
            -webkit-box-sizing: content-box;
            font-family: inherit;
            font-size: 100%;
        }
        input::-webkit-search-decoration,
        input::-webkit-search-cancel-button {
            display: none;
        }

        input[type=search] {
            background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
            border: solid 1px #ccc;
            padding: 9px 10px 9px 32px;
            width: 55px;

            -webkit-border-radius: 10em;
            -moz-border-radius: 10em;
            border-radius: 10em;

            -webkit-transition: all .5s;
            -moz-transition: all .5s;
            transition: all .5s;
        }
        input[type=search]:focus {
            width: 130px;
            background-color: #fff;
            border-color: #66CC75;

            -webkit-box-shadow: 0 0 5px rgba(109,207,246,.5);
            -moz-box-shadow: 0 0 5px rgba(109,207,246,.5);
            box-shadow: 0 0 5px rgba(109,207,246,.5);
        }


        input:-moz-placeholder {
            color: #999;
        }
        input::-webkit-input-placeholder {
            color: #999;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: rgba(217,215,210,0.94)">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img width="200px" height="60px" src="/img/logo.png"></a>
        <span style="float: right; font-size: 25px"><a href="#" id="name" style="text-decoration: none"> Hồ Văn Kỳ Tài - C0421G1 </a></span>
    </div>
</nav>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top" style="margin: 5px">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item mx-3 hover-item">
                    <a class="nav-link" href="/" style="font-size: 30px; margin-left: 80px">Home</a>
                </li>
                <li class="nav-item hover-item">
                    <a class="nav-link " href="/furama?action=list-employee" style="font-size: 30px; padding-left: 30px">Employee</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama?action=list-customer" style="font-size: 30px; padding-left: 30px">Customer</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama?action=list-service" style="font-size: 30px; padding-left: 30px">Service</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama?action=list-contract" style="font-size: 30px; padding-left: 30px">Contract</a>
                </li>
            </ul>
            <form class="d-flex" style="position: relative">
                <input class="form-control rounded-pill" id="demo-2" type="search" placeholder="Search" aria-label="Search" style="width: 300px; height: 30px; margin-left: 100px; margin-top: 15px">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2" style=" background-color: rgba(121,120,118,0.25)">
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="/furama?action=meeting-info" style="text-decoration: none; font-size: 25px">MEETINGS</a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="/furama?action=culinary" style="text-decoration: none; font-size: 25px">CULINARY</a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="/furama?action=spa" style="text-decoration: none; font-size: 25px">SPA & FITNESS</a>
                </div>
            </div>
        </div>
        <div class="col-lg-10" style="background-image: url('https://hoaidoan.vn/wp-content/uploads/2021/03/background-dep-2.png')">
            <input type="hidden" name="action" value="">
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="text-align: center">List of Result</h1>
                    <center>
                        <form style="alignment: center">
                            <input type="hidden" name="action" value="search-employee">
                            <table border="1" cellpadding="5">
                                <p>
                                    <c:if test='${requestScope["msg"] != null}'>
                                        <span class="message" style="color: green">${requestScope["msg"]}</span>
                                    </c:if>
                                </p>
                                <tr style="text-align: center">
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Day of birth</th>
                                    <th>ID Card</th>
                                    <th>Salary</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Position</th>
                                    <th>Education Degree</th>
                                    <th>Division</th>
                                    <th>Username</th>
                                </tr>
                                <c:forEach var="employee" items="${employeeList}">
                                    <tr>
                                        <td><c:out value="${employee.employeeId}"/></td>
                                        <td><c:out value="${employee.employeeName}"/></td>
                                        <td><c:out value="${employee.employeeBirthday}"/></td>
                                        <td><c:out value="${employee.employeeIdCard}"/></td>
                                        <td><c:out value="${employee.employeeSalary}"/></td>
                                        <td><c:out value="${employee.employeePhone}"/></td>
                                        <td><c:out value="${employee.employeeEmail}"/></td>
                                        <td><c:out value="${employee.employeeAddress}"/></td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${employee.positionId == 1}">Front Office</c:when>
                                                <c:when test="${employee.positionId == 2}">Server</c:when>
                                                <c:when test="${employee.positionId == 3}">Specialist</c:when>
                                                <c:when test="${employee.positionId == 4}">Supervisor</c:when>
                                                <c:when test="${employee.positionId == 5}">Manager</c:when>
                                                <c:otherwise>Executive Manager</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${employee.educationDegreeId == 1}">Intermediate</c:when>
                                                <c:when test="${employee.educationDegreeId == 2}">College</c:when>
                                                <c:when test="${employee.educationDegreeId == 3}">University</c:when>
                                                <c:otherwise>Postgraduate</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${employee.divisionId == 1}">Sale – Marketing</c:when>
                                                <c:when test="${employee.divisionId == 2}">Administration</c:when>
                                                <c:when test="${employee.divisionId == 3}">Service Department</c:when>
                                                <c:otherwise>Management Department</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><c:out value="${employee.username}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                    </center>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row text-center" style="background-color: rgba(100,188,170,0.92)">
        <div class="col-lg-12">
            <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center; font-weight: bold; font-size: 20px;
               width: 100%; margin-top: 15px">Contact US</p>
            <p style=" display: flex; flex-direction: column; justify-content: center; text-align: center;
               width: 100%"> 103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
        </div>
    </div>
</div>
</body>
</html>

