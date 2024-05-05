'use strict';
var app=angular.module('myApp',['ngRoute']);
app.config(['$routeProvider',function($routeProvider)
{
$routeProvider
.when('/',{
templateUrl:'home.html', controller:'HomeController' })
.when('/registration',{
templateUrl:'registration.html', controller:'RegiController' })
.when('/login',{
templateUrl:'login.html', controller:'LoginController' })
.otherwise({reditectTo:'/'});
}]);
app.controller('HomeController', ['$scope',function($scope){
$scope.message="Welcome to Home Page";
//$scope.logo='college.jpg';
$scope.logo='logo.jpg';
}]);
app.controller('RegiController', ['$scope',function($scope){
$scope.message="Please register !!!";
}]);
app.controller('LoginController', ['$scope',function($scope){
$scope.message="Please fill the login (for Existing user)";
}]);

