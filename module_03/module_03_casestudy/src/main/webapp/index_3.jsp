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
        <div class="col-lg-10" style="margin-bottom: 20px">
            <input type="hidden" name="action" value="">
            <div class="row">
                <div class="col-lg-12">
                    <p style="display: flex; flex-direction: column; justify-content: center; color: cadetblue; text-align: center; font-weight: bold; font-size: 30px; margin-top: 15px">
                        CULINARY
                    </p>
                    <p style="display: flex; flex-direction: column; justify-content: center; color: black; text-indent: 25px">
                        The resort’s culinary experience features a mixture of the authentic and locally inspired
                        Vietnamese, Asian, Italian and other European cuisines plus the best imported steaks.
                        The resort presents guests with varied gastronomic venues – the hip and breezy bar
                        overlooking the beach, the exclusive Lagoon pool surrounded by a tropical garden,
                        the true Italian flare offered at the Don Cipriani’s, the refined Asian touch at Café
                        Indochine or the authentic central Vietnam cuisine at the Danaksara.
                    </p>
                    <img src="img/culinary.jpg" style="width: 100%">
                    <p style="display: flex; flex-direction: column; justify-content: center; color: black; text-indent: 25px">
                        Enjoy all International cocktails, wines, and light snacks with nightly live Jazz and
                        lounge music in the truly sophisticated environment of Hai Van Lounge.
                        The views offer a variety of imaginations to the iconic Courtyard or the infinity pool
                        to the beach. Don’t miss out on our daily unique Afternoon Tea and Dessert Buffet with
                        a selection of 20 local herbal teas and nearly 25 different kinds of pastries.
                        <span style="font-weight: bold">Open: daily from 08:00 to 02:00 the next day</span>
                    </p>
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
