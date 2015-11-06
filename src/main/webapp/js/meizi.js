var indexApp = angular.module('indexApp', []);
indexApp.controller('indexController',['$scope', '$http', function ($scope, $http) {

    $scope.category = 'qingxin';
    $scope.pageNum = 0;
    $scope.images = [];
    $scope.loadImages = function () {

        console.log($scope.category);
        $http({
            url: 'queryServlet',
            method: 'GET',
            params: {category: $scope.category, pageNum: $scope.pageNum}
        }).success(function (data) {
            for (var i = 0; i < data.length; i++) {
                $scope.images.push(data[i]);
            }
            $scope.pageNum = $scope.pageNum + 1;
            $("a.lightbox").lightBox();
            // 流式布局
            $(".content-set").BlocksIt({
                numOfCol: 4
            });
            // 使每个图片都懒加载
            $("img.lazy").lazyload();
        }).error(function () {
            console.log('http请求异常!');
        });
    }
    $(window).scroll(function () {
        if ($(document).height() - $(this).scrollTop() - $(this).height() < 50) {
            $scope.loadImages();
        }
    });
}]);
