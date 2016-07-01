var app = angular.module('gestionStock', []);

app.controller("MainController", function($scope, $http) {
	$scope.fournisseurs = null;
	$scope.init = function() {
		$scope.produits = null;
		$http.get('produit/tousLesProduits').success(function(data) {
			$scope.produits = data;
		});
	};
	$http.get('fournisseur/tousLesFournisseurs').success(
			function(data) {
				$scope.fournisseurs = data;
			});

});

app
		.controller(
				"FournisseurController",
				function($scope, $http) {

					var formFournisseurAdresse = {};
					var formUpdatedFournisseurAdresse = {};
					$scope.fournisseur;
					$scope.getFournisseurs = function() {
						$http.get('fournisseur/tousLesFournisseurs').success(
								function(data) {
									$scope.fournisseurs = data;
								});
					}

					$scope.creerFournisseur = function(formFournisseur,
							formAdresse) {
						formFournisseurAdresse.fournisseur = formFournisseur;
						formFournisseurAdresse.adresse = formAdresse;

						var res = $http.post('fournisseur/creerFournisseur',
								angular.toJson(formFournisseurAdresse));
						res
								.success(function(fournisseurAdresse) {
									$scope.fournisseurAdresse = fournisseurAdresse;
									$scope.alertMessage = "Success; Le fournisseur a été bien enregistré";
									$("#confirmationFournisseurAlert").css(
											"display", "block");

								});
						res.error(function(data, status, headers, config) {
							alert("error " + status);
						});
						setTimeout(function() {
							window.location.reload();

						}, 2500);
					};

				});

app.controller("ClientController", function($scope, $http) {
	var formClientAdresse = {};
	$scope.creerClient = function(formClient, formAdresse) {
		formClientAdresse.client = formClient;
		formClientAdresse.adresse = formAdresse;
		alert("formClientAdresse : " + formClientAdresse);
		var res = $http.post('client/creerClient', angular
				.toJson(formClientAdresse));
		res.success(function(clientAdresse) {
			$scope.clientAdresse = clientAdresse;
			$scope.alertMessage = "Success; Le client a été bien enregistré";
			$("#confirmationClientAlert").css("display", "block");
		});
		res.error(function(data, status, headers, config) {
			alert("error " + status);
		});
		setTimeout(function() {
			document.location.reload(true);
		}, 2500);
	};

});

app.controller("ProduitController", function($scope, $http) {
	// add produits rows
	$scope.newProduits = [ {
		serialNumber : null,
		description : null,
		qte : null,
		prixUnit : null,
		fournisseur : null,
	} ];
	
	$scope.addNewProduitsRow = function() {
		var produit = {
			serialNumber : null,
			description : null,
			qte : null,
			prixUnit : null,
			fournisseur : null
		};
		$scope.newProduits.push(produit);
	};
	$scope.removeNewProduitRow = function(index) {
		$scope.newProduits.splice(index, 1);
	};
	
	$scope.ajouterProduits = function() {
		alert("newProduits : " +$scope.newProduits ) ;
		var res = $http.post('produit/ajouterProduit',
				angular.toJson($scope.newProduits));
		res
				.success(function(produit) {
					$scope.alertMessage = "Success; La liste des produits ont été bien enregistré";
					alert("success " + produit);

				});
		res.error(function(data, status, headers, config) {
			alert("error eee" + status);
		});
	};	
	
});
