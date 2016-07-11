/**
 * Technicien services
 */

app.factory('allFournisseursService', ['$http', function($http) { 
  return $http.get('fournisseur/tousLesFournisseurs') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);

