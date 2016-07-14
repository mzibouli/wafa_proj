app.controller('FournisseurController', ['$scope', 'allFournisseursService',
						function($scope, allFournisseursService) {
								allFournisseursService.success(function(data) {
								$scope.fournisseurs = data;
							});
						}
]);

app.controller("addFournisseurController", function($scope, $http) {

	var formFournisseurAdresse = {};
	var formUpdatedFournisseurAdresse = {};

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