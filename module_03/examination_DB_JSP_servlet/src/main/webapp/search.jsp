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
        <div class="col-lg-12" style="background-image: url('http://2.bp.blogspot.com/-wPdpM8-5oVI/UzgtBY0RUFI/AAAAAAAAXPI/h_2cxixYgo0/s1600/background-don-gian-cho-windows+(2).jpg')">
            <input type="hidden" name="action" value="">
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="text-align: center">List of Result</h1>
                    <center>
                        <form style="alignment: center">
                            <input type="hidden" name="action" value="search-product">
                            <table border="1" cellpadding="5">
                                <p>
                                    <c:if test='${requestScope["msg"] != null}'>
                                        <span class="message" style="color: green">${requestScope["msg"]}</span>
                                    </c:if>
                                </p>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Amount</th>
                                    <th>Color</th>
                                    <th>Description</th>
                                    <th>Catelogy</th>
                                </tr>
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
</body>
</html>

