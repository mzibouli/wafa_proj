/**
 * Head directive
 */

app.directive('headDirective', function(){
	return {
		restrict : 'E',
		templateUrl : 'templates/shared/entete.html'
	};
});