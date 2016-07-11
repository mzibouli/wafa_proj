/**
 * Client services
 */

app.factory('allClientsService', ['$http', function($http) { 
  return $http.get('client/tousLesClients') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);

