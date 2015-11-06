<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html ng-app="indexApp">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="抓取,图片抓取,爬虫">
    <meta name="description" content="网页图片抓取系统，获取网页中的图片">
    <title>妹子图片</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/meizi.css">
    <link rel="stylesheet" href="static/css/jquery.lightbox-0.5.css">
    <script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="static/js/angular.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.lazyload.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.lightbox-0.5.min.js"></script>
    <script type="text/javascript" src="static/js/blocksit.min.js"></script>
    <script type="text/javascript" src="js/meizi.js"></script>
</head>
<body ng-controller="indexController">
    <div class="container">
        <div class="head-set">
            <select class="form-control" ng-model="category">
                <option name="qingxin" value="qingxin">清新</option>
                <option name="meitui" value="meitui">美腿</option>
            </select>
            <button type="button" ng-click="loadImages()" class="btn btn-success">&nbsp;获取图片&nbsp;</button>
        </div>
        <div id="wrapper">
            <div class="content-set">

                <div class="grid" ng-repeat="image in images">
                    <div class="imgholder">
                        <a class="lightbox" href="{{image.originUrl}}">
                            <img class="lazy" src="static/images/pixel.gif" data-original="{{image.shortUrl}}"
                             width="200">
                        </a>
                    </div>
                    <strong>{{image.title}}</strong>
                    <div class="meta">
                        <a class="lightbox" href="{{image.originUrl}}">高清无码原图</a>
                    </div>
                </div>


            </div>
        </div>
    </div>
</body>

</html>
