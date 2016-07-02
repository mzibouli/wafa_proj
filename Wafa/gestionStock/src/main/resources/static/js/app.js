var app = angular.module('gestionStock', ['ngRoute']);

app.controller("MainController", function($scope, $http) {
	$scope.fournisseurs = null;
	$scope.init = function() {
		$scope.produits = null;
		$http.get('produit/tousLesProduits').success(function(data) {
			$scope.produits = data;
		});
	};
	$http.get('fournisseur/tousLesFournisseurs').success(function(data) {
		$scope.fournisseurs = data;
	});

});

app.controller("FournisseurController", function($scope, $http) {

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