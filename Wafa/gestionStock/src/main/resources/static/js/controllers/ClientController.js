app.controller('ClientController', [ '$scope', 'allClientsService',
		function($scope, allClientsService) {
			allClientsService.success(function(data) {
				$scope.allClients = data;
			});
		} ]);

app.controller("addClientController", function($scope, $http) {
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