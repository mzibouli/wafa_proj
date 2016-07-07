/**
 * Technicien services
 */

app.factory('allTechniciensService', ['$http', function($http) { 
  return $http.get('technicien/allTechniciens') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);

