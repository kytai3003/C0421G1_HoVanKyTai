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
                    <a class="nav-link" href="#" style="font-size: 30px; margin-left: 80px">Home</a>
                </li>
                <li class="nav-item hover-item">
                    <a class="nav-link " href="" style="font-size: 30px; padding-left: 30px">Employee</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="/furama?action=list-customer" style="font-size: 30px; padding-left: 30px">Customer</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="#" style="font-size: 30px; padding-left: 30px">Service</a>
                </li>
                <li class="nav-item hover-item" >
                    <a class="nav-link " href="#" style="font-size: 30px; padding-left: 30px">Contract</a>
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
                    <a href="#" style="text-decoration: none; font-size: 25px">Item one</a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="#" style="text-decoration: none; font-size: 25px">Item two</a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 my-lg-1 mx-3">
                    <a href="#" style="text-decoration: none; font-size: 25px">Item three</a>
                </div>
            </div>
        </div>
        <div class="col-lg-10">
            <input type="hidden" name="action" value="">
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="text-align: center">Create New Customer</h1>
                    <center>
                    <p>
                        <c:if test='${requestScope["msg"] != null}'>
                            <span class="message" style="color: blue; font-weight: bold; text-align: center">${requestScope["msg"]}</span>
                        </c:if>
                    </p>
                    <form method="post" style="alignment: center">
                        <input type="hidden" name="action" value="create-customer">
                        <table align="center">
                            <tr>
                                <td>Code: </td>
                                <td>
                                    <input type="text" name="code">
                                </td>
                            </tr>
                            <tr>
                                <td>Type ID:</td>
                                <td>
                                    <select name="type" style="width: 182px">
                                        <c:forEach var="customerType" items="${typeList}">
                                            <option value='${customerType.customerTypeId}' >${customerType.customerTypeName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Name:</td>
                                <td>
                                    <input type="text" name="name">
                                </td>
                            </tr>
                            <tr>
                                <td>Day of birth:</td>
                                <td>
                                    <input type="text" name="dob">
                                </td>
                            </tr>
                            <tr>
                                <td>Gender:</td>
                                <td>
                                    <select name="gender" style="width: 182px">
                                        <option selected>Choose one</option>
                                        <option value="0">Male</option>
                                        <option value="1">Female</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>ID Card:</td>
                                <td>
                                    <input type="text" name="card">
                                </td>
                            </tr>
                            <tr>
                                <td>Phone number:</td>
                                <td>
                                    <input type="text" name="phone">
                                </td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>
                                    <input type="text" name="email">
                                </td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td>
                                    <input type="text" name="address">
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
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
