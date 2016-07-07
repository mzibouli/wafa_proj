app.controller('TechnicienController', ['$scope', 'allTechniciensService',
						function($scope, allTechniciensService) {
							allTechniciensService.success(function(data) {
								$scope.allTechniciens = data;
							});
						}
]);

app.controller("addTechnicienController", function($scope, $http) {
	var formTechnicienAdresse = {};
	$scope.creerTechnicien = function(formTechnicien, formAdresse) {
		formTechnicienAdresse.client = formTechnicien;
		formTechnicienAdresse.adresse = formAdresse;
		alert("formTechnicientAdresse : " + formTechnicienAdresse);
		var res = $http.post('technicien/addTechniciens', angular
				.toJson(formTechnicienAdresse));
		res.success(function(TechnicienAdresse) {
			$scope.TechnicienAdresse = TechnicienAdresse;
			$scope.alertMessage = "Success; Le Technicien a été bien enregistré";
			$("#confirmationTechnicienAlert").css("display", "block");
		});
		res.error(function(data, status, headers, config) {
			alert("error " + status);
		});
		setTimeout(function() {
			document.location.reload(true);
		}, 2500);
	};

});