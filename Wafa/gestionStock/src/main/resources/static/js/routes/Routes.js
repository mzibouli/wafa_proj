/**
 * Stock Routes
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
	.when('/tousLesClients', {
		templateUrl : 'templates/client/tousLesClients.html',	
	})
	.when('/ajouterClient', {
		templateUrl : 'templates/client/ajouterClientForm.html',	
	})
	.when('/trouverClient', {
		templateUrl : 'templates/client/trouverClient.html',	
	})
	.when('/tousLesFournisseurs', {
		templateUrl : 'templates/fournisseur/tousLesFournisseurs.html',	
	})
	.when('/ajouterFournisseur', {
		templateUrl : 'templates/fournisseur/ajouterFournisseurForm.html',	
	})	
	.when('/trouverFournisseur', {
		templateUrl : 'templates/fournisseur/trouverFournisseur.html',	
	})	
	.when('/allTechniciens', {
		templateUrl : 'templates/technicien/allTechniciens.html',	
	})
	.when('/addTechniciens', {
		templateUrl : 'templates/technicien/addTechniciens.html',	
	})
	.when('/findTechniciens', {
		templateUrl : 'templates/technicien/findTechniciens.html',	
	})
	.when('/', {
		templateUrl : 'templates/shared/home.html',	
	})
	.otherwise({ redirectTo: '/'});
});
