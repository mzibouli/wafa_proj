var dialogApp = angular.module('tableExample', []);

    dialogApp.directive('myTable', function() {
        return function(scope, element, attrs) {

            // apply DataTable options, use defaults if none specified by user
            var options = {};
            if (attrs.myTable.length > 0) {
                options = scope.$eval(attrs.myTable);
            } else {
                options = {
                    "bStateSave": true,
                    "iCookieDuration": 2419200, /* 1 month */
                    "bJQueryUI": true,
                    "bPaginate": false,
                    "bLengthChange": false,
                    "bFilter": false,
                    "bInfo": false,
                    "bDestroy": true
                };
            }

            // Tell the dataTables plugin what columns to use
            // We can either derive them from the dom, or use setup from the controller           
            var explicitColumns = [];
            element.find('th').each(function(index, elem) {
                explicitColumns.push($(elem).text());
            });
            if (explicitColumns.length > 0) {
                options["aoColumns"] = explicitColumns;
            } else if (attrs.aoColumns) {
                options["aoColumns"] = scope.$eval(attrs.aoColumns);
            }

            // aoColumnDefs is dataTables way of providing fine control over column config
            if (attrs.aoColumnDefs) {
                options["aoColumnDefs"] = scope.$eval(attrs.aoColumnDefs);
            }
            
            if (attrs.fnRowCallback) {
                options["fnRowCallback"] = scope.$eval(attrs.fnRowCallback);
            }

            // apply the plugin
            var dataTable = element.dataTable(options);

            
            
            // watch for any changes to our data, rebuild the DataTable
            scope.$watch(attrs.aaData, function(value) {
                var val = value || null;
                if (val) {
                    dataTable.fnClearTable();
                    dataTable.fnAddData(scope.$eval(attrs.aaData));
                }
            });
        };
    });

function Ctrl($scope) {

    $scope.message = '';            
    
        $scope.myCallback = function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {            
            $('td:eq(2)', nRow).bind('click', function() {
                $scope.$apply(function() {
                    $scope.someClickHandler(aData);
                });
            });
            return nRow;
        };

        $scope.someClickHandler = function(info) {
            $scope.message = 'clicked: '+ info.price;
        };
    
        $scope.columnDefs = [ 
            { "mDataProp": "Date Achat", "aTargets":[0]},
            { "mDataProp": "Description", "aTargets":[1] },
            { "mDataProp": "Fabriquant", "aTargets":[2] },
            { "mDataProp": "Serial Number", "aTargets":[3] }
        ]; 
        
        $scope.overrideOptions = {
            "bStateSave": true,
            "iCookieDuration": 2419200, /* 1 month */
            "bJQueryUI": true,
            "bPaginate": true,
            "bLengthChange": false,
            "bFilter": true,
            "bInfo": true,
            "bDestroy": true
        };
    
       
        $scope.sampleProductCategories = [

              {
                "Date Achat": "1948 Porsche 356-A Roadster",
                "Description": 53.9,
                "Fabriquant": "Classic Cars",
                "Serial Number": "Classic Cars",
                "action":"x"
              },
              {
                "Date Achat": "1948 Porsche Type 356 Roadster",
                "Description": 62.16,
	            "Fabriquant": "Classic Cars",
	            "Serial Number": "Classic Cars",
                "action":"x"
              },
              {
                "Date Achat": "1949 Jaguar XK 120",
                "Description": 47.25,
                "Fabriquant": "Classic Cars",
                "Serial Number": "Classic Cars",
                "action":"x"
              }
              ,
              {
                "Date Achat": "1936 Harley Davidson El Knucklehead",
                "Description": 24.23,
	            "Fabriquant": "Motorcycles",
	            "Serial Number": "Classic Cars",
                "action":"x"
              },
              {
                  "Date Achat": "hritini",
                  "Description": 24.23,
  	            "Fabriquant": "Motorcycles",
  	            "Serial Number": "Classic Cars",
                  "action":"x"
                }
          
        ];            
            
}