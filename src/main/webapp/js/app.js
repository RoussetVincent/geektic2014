var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider',
               function($routeProvider) {
                 $routeProvider.
                   when('/home', {
                     templateUrl: 'views/home.html',
                     controller: 'HomeCtrl'
                   }).
                   when('/search', {
                     templateUrl: 'views/search.html',
                     controller: 'SearchCtrl'
                   }).
                   when('/all', {
                     templateUrl: 'views/all.html',
                     controller: 'AllCtrl'
                   }).	  
                   otherwise({
                     redirectTo: '/home'
                   });
               }]);

/*** SearchCtrl ***/ 
app.controller('SearchCtrl', function($scope, $http) {

	$scope.btnSearchClick = function () {
		$http.get('/api/geek/sex/' + $scope.frm_search.form.sex).success(function(geeks) {
	    	$scope.searchGeeks = geeks;
	    });
	};
	
    
	$scope.btnUpCptviewClick = function (geekId) {
		$http.put('/api/geek/'+geekId+'/upCptview' ).success(function(newCptview) {
			  /* Maj scope cptView */  
			  for(var k in $scope.searchGeeks){
		    	  if ($scope.searchGeeks[k].id == geekId) {
		    		  $scope.searchGeeks[k].cptview = newCptview;
		    	  }
		      }
			  /* Add log  */  
		      $http.get('/api/log/add/'+geekId).success(function(geeks) {
		      });
	    });
	};
	
});

/*** AllCtrl ***/ 
app.controller('AllCtrl', function($scope, $http) {
    $http.get('/api/geek').success(function(geeks) {
    	$scope.allGeeks = geeks;
    });
    
	$scope.btnUpCptviewClick = function (geekId) {
		$http.put('/api/geek/'+geekId+'/upCptview' ).success(function(newCptview) {
		    /* Maj scope cptView */  
			for(var k in $scope.allGeeks){
				if ($scope.allGeeks[k].id == geekId) {
					$scope.allGeeks[k].cptview = newCptview;
				}
			}
			/* Add log  */  
		    $http.get('/api/log/add/'+geekId).success(function(geeks) {
		    });
  
	    });
	};
    
});

/*** HomeCtrl ***/ 
app.controller('HomeCtrl', function($scope, $http) {

});

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
    	$scope.helloMessage = helloMessage;
    });

	$scope.data_lst_sex = [{
	    val: "FEMININ",
	    title: "Femme"
	}, {
	    val: "MASCULIN",
	    title: "Homme"
	}];

});