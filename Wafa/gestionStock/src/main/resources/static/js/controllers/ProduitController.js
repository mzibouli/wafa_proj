
app.controller('ProduitController', ['$scope', 'allProduitsService',
						function($scope, allProduitsService) {
							allProduitsService.success(function(data) {
								$scope.allProduits = data;
							});
						}
]);

app.controller("addProduitController", function($scope, $http) {
					// add produits rows
					$scope.newProduits = [ {
						serialNumber : null,
						description : null,
						dateAchat : null,
						qte : null,
						fabriquant : null,
						fournisseur : null,
					} ];

					$scope.addNewProduitsRow = function() {
						var produit = {
							serialNumber : null,
							description : null,
							dateAchat : null,
							qte : null,
							fabriquant : null,
							fournisseur : null,
						};
						$scope.newProduits.push(produit);
					};
					$scope.removeNewProduitRow = function(index) {
						$scope.newProduits.splice(index, 1);
					};

					$scope.ajouterProduits = function() {
						alert("newProduits : " + $scope.newProduits);
						var res = $http.post('produit/ajouterProduit', angular
								.toJson($scope.newProduits));
						res
								.success(function(produit) {
									$scope.alertMessage = "Success; La liste des produits ont été bien enregistré";
									alert("xd" + $scope.produits);
									$scope.produits.push(angular
											.toJson($scope.newProduits));
									$scope.produits.push(
										    {id: "67", name: "Douglas Adams", type: "comedy"}
										);
									alert("success :" + produit);
								});
						res.error(function(data, status, headers, config) {
							alert("error eee" + status);
						});
					};

				});