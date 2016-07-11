/**
 * Client services
 */

app.factory('allProduitsService', ['$http', function($http) { 
  return $http.get('produit/tousLesProduits') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);
