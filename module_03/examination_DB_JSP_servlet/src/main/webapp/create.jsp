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
<div class="container-fluid">
        <div class="col-lg-12" style="background-image: url('http://2.bp.blogspot.com/-wPdpM8-5oVI/UzgtBY0RUFI/AAAAAAAAXPI/h_2cxixYgo0/s1600/background-don-gian-cho-windows+(2).jpg')">
            <input type="hidden" name="action" value="">
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="text-align: center">Create New Product</h1>
                    <center>
                        <a href="/product?action=">Back to list</a>
                        <p>
                            <c:if test='${requestScope["msg"] != null}'>
                                <span class="message" style="color: blue; font-weight: bold; text-align: center">${requestScope["msg"]}</span>
                            </c:if>
                        </p>
                        <form method="post" style="alignment: center">
                            <input type="hidden" name="action" value="create-product">
                            <table align="center">
                                <tr>
                                    <td>Name: </td>
                                    <td class="rounded-pill">
                                        <input type="text" name="name" value="${newCustomer.getCustomerCode()}">
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td style="color: #a71d2a"  class="rounded-pill">
                                        <c:if test="${map.get('code') != null}">
                                            <small>${map.get('code')}</small>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Price:</td>
                                    <td  class="rounded-pill">
                                        <input type="number" name="price">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Amount:</td>
                                    <td  class="rounded-pill">
                                        <input type="number" name="amount">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Color:</td>
                                    <td  class="rounded-pill">
                                        <input type="text" name="color">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Desciption:</td>
                                    <td  class="rounded-pill">
                                        <input type="text" name="description">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Catelogy:</td>
                                    <td  class="rounded-pill">
                                        <select name="catelogy" style="width: 182px">
                                            <c:forEach var="catelogy" items="${catelogyList}">
                                                <option value='${catelogy.idCatelogy}' >${catelogy.nameCatelogy}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td class="rounded-pill">
                                        <button class="rounded-pill my-lg-1" type="submit" style="width: 160px; height: 35px">Create</button>
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
