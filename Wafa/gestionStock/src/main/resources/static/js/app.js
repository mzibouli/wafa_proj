var app = angular.module("gestionStock", []);

app.controller("MainController", function($scope, $http) {
	$scope.getAllProduits = function() {
		$http.get('produit/tousLesProduits').success(function(data) {
			$scope.produits = data;
			alert($scope.produits);
		});
	}
});

app.controller("ProduitController", function($scope, $http) {

});

app.controller("ClientController", function($scope, $http) {

});

app.controller("FournisseurController", function($scope, $http) {

});
