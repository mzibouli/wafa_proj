var app = angular.module('gestionStock', ['ngRoute']);

app.controller("MainController", function($scope, $http) {
	$scope.init = function() {
		$scope.produits = null;
		$http.get('produit/tousLesProduits').success(function(data) {
			$scope.produits = data;
		});
	};
});