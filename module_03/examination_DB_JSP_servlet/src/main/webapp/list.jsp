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
                <form class="d-flex" method="post" action="/product?action=search-product" style="position: relative">
                    <input class="form-control rounded-pill w-75" name="productName" id="demo-2" type="search" placeholder="Search product name" aria-label="Search" style="width: 100px; height: 30px; margin-left: 100px; margin-top: 15px">
                    <input class="form-control rounded-pill w-75" name="productPrice" value="0" id="demo-3" type="search" placeholder="Search product price" aria-label="Search" style="width: 100px; height: 30px; margin-left: 100px; margin-top: 15px">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <h2>
                    <a href="/product?action=create-product">Add New Product</a>
                    <caption><h2>List of Product</h2></caption>
                    <p>
                        <c:if test='${requestScope["msg"] != null}'>
                            <span class="message" style="color: red; font-style: italic; font-size: 20px">${requestScope["msg"]}</span>
                        </c:if>
                    </p>
                </h2>
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <caption>Product management</caption>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Amount</th>
                            <th>Color</th>
                            <th>Description</th>
                            <th>Catelogy</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${productList}">
                            <tr>
                                <td><c:out value="${product.idProduct}"></c:out></td>
                                <td><c:out value="${product.nameProduct}"></c:out></td>
                                <td><c:out value="${product.price}"></c:out></td>
                                <td><c:out value="${product.amount}"></c:out></td>
                                <td><c:out value="${product.colorProduct}"></c:out></td>
                                <td><c:out value="${product.description}"></c:out></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${product.idCatelogy == 1}">Phone</c:when>
                                        <c:when test="${product.idCatelogy == 2}">Tivi</c:when>
                                        <c:when test="${product.idCatelogy == 3}">Tủ lạnh</c:when>
                                        <c:otherwise>Máy giặt</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <button style="background-color: rgba(182,201,170,0.82); width: 70px" type="button" class="btn rounded-pill"><a href="/product?action=edit-product&id=${product.idProduct}">Edit</a></button>
                                    <button style="background-color: rgba(188,49,55,0.92)" onclick="onDelete('${product.idProduct}', '${product.nameProduct}')" type="button" class="btn rounded-pill" data-toggle="modal" data-target="#modelId">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirm delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form>
                    <input type="hidden" name="action" value="delete-product">
                    <input type="hidden" name="id" value="" id="idProductDelete">
                    <div class="modal-body">
                        Are you sure deleting this product? <input style="border: none; outline: none; font-weight: bold" id="nameProductDelete" readonly>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

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
    <script>
        function onDelete(id, name) {
            document.getElementById("idProductDelete").value = id;
            console.log(name)
            document.getElementById("nameProductDelete").value = name;
        }
    </script>
</body>
</html>
