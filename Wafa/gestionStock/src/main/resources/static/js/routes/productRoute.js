/**
 * Product route
 */

angular.module('gestionStock').config(function($routeProvider) {

	$routeProvider.when('/tousLesProduits', {
		templateUrl : 'templates/produit/tousLesProduits.html',	
	})
	.when('/ajouterProduit', {
		templateUrl : 'templates/produit/ajouterProduitForm.html',	
	})
	.when('/trouverProduit', {
		templateUrl : 'templates/produit/trouverProduit.html',	
	})
	.when('/', {
		templateUrl : 'home.html',	
	})
	.otherwise({ redirectTo: '/'});
});
