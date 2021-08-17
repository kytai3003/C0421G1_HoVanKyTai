<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    DataTables 1.10.21 support bootstrap <= 4.1.3--%>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Date of birth</th>
                            <th>Year</th>
                            <th>Class</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${studentList}">
                            <tr>
                                <td><c:out value="${student.studentId}"></c:out></td>
                                <td><c:out value="${student.studentName}"></c:out></td>
                                <td><c:out value="${student.address}"></c:out></td>
                                <td><c:out value="${student.dayOfBirth}"></c:out></td>
                                <td><c:out value="${student.year}"></c:out></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${student.classId == 1}">C01</c:when>
                                        <c:when test="${student.classId == 2}">C02</c:when>
                                        <c:when test="${student.classId == 3}">C03</c:when>
                                        <c:otherwise>C04</c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="jquery/popper.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap4.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#tableStudent').dataTable( {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 4
            } );
        } );
    </script>
</body>
</html>
