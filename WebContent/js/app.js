var app = angular.module('app',['ngRoute']);

app.config(['$routeProvider',function($routeProvider){
	$routeProvider.
	when('/lista',{controller:'listUsuarios', templateUrl:'pages/listar-usuarios.html'}).
	when('/cadastrar',{controller:'cadastrarUsuarios', templateUrl:'pages/cadastrar-usuarios.html'}).otherwise({redirectTo:'/'});
}]);

app.run(['$rootScope',function($rootScope){
	$rootScope.usuarios = []; 
	console.log('app.run');
}]);

app.controller('listUsuarios',function ($scope, $http) {
	console.log('listUsuarios');
	$http({
    	url: "/CadastroDeUsuarios/mvc", 
		method: "POST",
		params: {
			"cmd": "listar"
		}
	}).then(function mySuccess(response) {
		console.log(response);
		console.log("success : "+response.status+" "+response.data);
        $scope.usuarios = response.data.usuarios;
        console.log($scope.usuarios);
	}, function myError(response) {
		console.log(response.statusText);
	});
});

app.controller('cadastrarUsuarios',function ($scope,$location,$http) {
	console.log('cadastrarUsuarios');
	$scope.name = "";
	$scope.save = function(){
		$http({
	    	url: "/CadastroDeUsuarios/mvc", 
			method: "POST",
			params: {
				"cmd": "cadastrar",
				"name": $scope.name 
			}
		}).then(function mySuccess(response) {
			console.log(response);
			console.log("success : "+response.status);
	        $scope.usuarios = response.data.usuarios;
	        console.log($scope.usuarios);
	        $location.path('/lista');
		}, function myError(response) {
			console.log(response.statusText);
		});
	}
});
