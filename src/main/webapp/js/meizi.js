var indexApp = angular.module('indexApp', []);
indexApp.controller('indexController',['$scope', '$http', function ($scope, $http) {

    $scope.category = 'qingxin';
    $scope.pageNum = 0;
    $scope.images = [];
    $scope.changeCategory = function () {
        $(".content-set").html('');
        $scope.pageNum = 0;
        alert('ss');
    };
    $scope.loadImages = function () {

        console.log($scope.category);
        $http({
            url: 'queryServlet',
            method: 'GET',
            params: {category: $scope.category, pageNum: $scope.pageNum}
        }).success(function (data) {
            for (var i = 0; i < data.length; i++) {
                 //$scope.images.push(data[i]);
                var img = '';
                img += "<div class='grid''><div class='imgholder'><a class='lightbox' href='"
                img += data[i].originUrl;
                img += "'>";
                img += "<img class='lazy' width='200'";
                img += "src='static/images/pixel.gif' data-original='";
                img += data[i].shortUrl;
                img += "'/></a></div><strong>";
                img += data[i].title;
                img += "</strong><div class='meta'><a href='";
                img += data[i].originUrl;
                img += "' class='lightbox'>高清无码原图</a></div></div>";
                $(".content-set").append(img);
            }
            $scope.pageNum = $scope.pageNum + 1;
            $("a.lightbox").lightBox();
            
            // 瀑布流
            var browserWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
            if (browserWidth < 500) {
                $(".content-set").BlocksIt({
                    numOfCol: 1
                });
            } else if (browserWidth >= 1000) {
                $(".content-set").BlocksIt({
                    numOfCol: 4
                });
            }

            // 图片延迟加载
            $("img.lazy").lazyload();
        }).error(function () {
            console.log('http请求失败!');
        });
    }
    $(window).scroll(function () {
        if ($(document).height() - $(this).scrollTop() - $(this).height() < 50) {
            $scope.loadImages();
        }
    });
}]);
