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
        <div class="col-lg-12"  style="background-image: url('https://hoaidoan.vn/wp-content/uploads/2021/03/background-dep-2.png')">
            <input type="hidden" name="action" value="">
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="text-align: center">Editing Product</h1>
                    <a href="/product?action=">Back to list</a>
                    <center>
                        <p>
                            <c:if test='${requestScope["msg"] != null}'>
                                <span class="message" style="color: blue; font-weight: bold; text-align: center">${requestScope["msg"]}</span>
                            </c:if>
                        </p>
                        <form method="post" style="alignment: center">
                            <input type="hidden" name="action" value="edit-product">
                            <table border="1" cellpadding="5">
                                <c:if test="${product != null}">
                                    <input type="hidden" name="id" value="<c:out value='${product.idProduct}' />"/>
                                </c:if>
                                <tr>
                                    <th>Name:</th>
                                    <td>
                                        <input type="text" name="name"
                                               value="<c:out value='${product.nameProduct}' />"
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Price:</th>
                                    <td>
                                        <input type="number" name="price"
                                               value="<c:out value='${product.price}' />"
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <th>amount:</th>
                                    <td>
                                        <input type="number" name="amount"
                                               value="<c:out value='${product.amount}' />"
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <th>color:</th>
                                    <td>
                                        <input type="text" name="color"
                                               value="<c:out value='${product.colorProduct}' />"
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <th>description:</th>
                                    <td>
                                        <input type="text" name="description"
                                               value="<c:out value='${product.description}' />"
                                        />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Catelogy:</th>
                                    <td>
                                        <select name="catelogy" style="width: 182px">
                                            <c:forEach var="catelogy" items="${catelogyList}">
                                                <option value='${catelogy.idCatelogy}' >${catelogy.nameCatelogy}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td align="center" class="rounded-pill" style="width: 150px">
                                        <input class="rounded-pill" style="width: 100px" type="submit" value="Save"/>
                                    </td>
                                </tr>
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

