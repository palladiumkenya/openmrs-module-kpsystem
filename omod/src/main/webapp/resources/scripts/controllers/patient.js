/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

/**
 * Patient service
 */
kenyaemrApp.service('PatientService', function ($rootScope) {

	/**
	 * Broadcasts new patient search parameters
	 */
	this.updateSearch = function(query, which) {
		$rootScope.$broadcast('patient-search', { query: query, which: which });
	};
});

/**
 * Controller for patient search form
 */
kenyaemrApp.controller('PatientSearchForm', ['$scope', 'PatientService', function($scope, patientService) {

	$scope.query = '';

	$scope.init = function(which) {
		$scope.which = which;
		$scope.$evalAsync($scope.updateSearch); // initiate an initial search
	};

	$scope.updateSearch = function() {
		patientService.updateSearch($scope.query, $scope.which);
	};
}]);

/**
 * Controller for peer search form
 */
kenyaemrApp.controller('PeerSearchForm', ['$scope', 'PatientService', function($scope, patientService) {

	$scope.query = '';

	$scope.init = function() {
		$scope.which = "";
		$scope.$evalAsync($scope.updateSearch); // initiate an initial search
	};

	$scope.updateSearch = function() {
		patientService.updateSearch($scope.query, $scope.which);
	};
}]);

/**
 * Controller for patient search results
 */
kenyaemrApp.controller('PatientSearchResults', ['$scope', '$http', function($scope, $http) {

	$scope.query = '';
	$scope.results = [];

	/**
	 * Initializes the controller
	 * @param appId the current app id
	 * @param which
	 */
	$scope.init = function(appId, pageProvider, page) {
		$scope.appId = appId;
		$scope.pageProvider = pageProvider;
		$scope.page = page;
	};

	/**
	 * Listens for the 'patient-search' event
	 */
	$scope.$on('patient-search', function(event, data) {
		$scope.query = data.query;
		$scope.which = data.which;
		$scope.refresh();
	});

	/**
	 * Refreshes the person search
	 */
	$scope.refresh = function() {
		$http.get(ui.fragmentActionLink('kenyaemr', 'search', 'patients', { appId: $scope.appId, q: $scope.query, which: $scope.which })).
			success(function(data) {
				$scope.results = data;
		});
	};

	/**
	 * Result click event handler
	 * @param patient the clicked patient
	 */
	$scope.onResultClick = function(patient) {
		ui.navigate($scope.pageProvider, $scope.page, { patientId: patient.id });
	};

}]);


/**
 * Controller for peer search results
 */
kenyaemrApp.controller('PeerSearchResults', ['$scope', '$http','$q','$timeout', function($scope, $http,$q,$timeout) {

	$scope.query = '';
	$scope.results = [];

	/**
	 * Initializes the controller
	 * @param appId the current app id
	 * @param which
	 */
	$scope.init = function(appId, pageProvider, page) {
		$scope.appId = appId;
		$scope.pageProvider = pageProvider;
		$scope.page = page;
	};

	/**
	 * Listens for the 'peer-search' event
	 */
	$scope.$on('patient-search', function(event, data) {
		$scope.query = data.query;
		$scope.which = "all";
		$scope.refresh();
	});

	/**
	 * Refreshes the person search
	 */
	$scope.refresh = function() {
		$http.get(ui.fragmentActionLink('kenyaemr', 'search', 'patients', { appId: $scope.appId, q: $scope.query, which: $scope.which })).
		success(function(data) {
			$scope.results = data;

		});
	};

	/**
	 * Result click event handler
	 * @param patient the clicked patient
	 */
	$scope.onPeerEducatorResultClick = function(patient) {
		$scope.getRelationships()
			.then(function(posts) {
				$scope.clientResults = posts.results;
			});
		$timeout(function() {
			// ui.navigate('kenyaemr', 'peerCalender/peerViewClients', { patientId: patient.id });
			//ui.navigate($scope.pageProvider, $scope.page, { patientId: patient.id });
		},1000);


	};
	$scope.getRelationships= function( ) {
		var deferred = $q.defer();
		var uuids = '7a4b7711-69d1-441d-b15b-83d06c623cc9';
		var v ='custom:(uuid,id,personA:(uuid,display,id,birthdate,gender,age))';
		// get posts form backends
		$http.get('/openmrs/ws/rest/v1/relationship?v='+ v + '&person=7a4b7711-69d1-441d-b15b-83d06c623cc9')
			.then(function (result) {
					deferred.resolve(result.data);

			}, function (error) {
					deferred.reject(error);
			});
		return deferred.promise;
	}

	$scope.onPeerResultClick = function(patient) {
		ui.navigate('kenyaemr', 'enterForm', { patientId: patient.personA.id,
			formUuid:'99979576-8854-11e9-bc42-526af7764f64',appId:'kenyaemr.medicalEncounter',
			returnUrl:'peerCalender/peerCalenderHome'});

	};


}]);


/**
 * Controller for similar patients (on registration form)
 */
kenyaemrApp.controller('SimilarPatients', ['$scope', '$http', function($scope, $http) {

	$scope.givenName = '';
	$scope.familyName = '';
	$scope.results = [];

	/**
	 * Initializes the controller
	 * @param appId the current app id
	 * @param which
	 */
	$scope.init = function(appId, pageProvider, page) {
		$scope.appId = appId;
		$scope.pageProvider = pageProvider;
		$scope.page = page;
		$scope.refresh();
	};

	/**
	 * Refreshes the patient search
	 */
	$scope.refresh = function() {
		var query = $scope.givenName + ' ' + $scope.familyName;
		$http.get(ui.fragmentActionLink('kenyaemr', 'search', 'patients', { appId: $scope.appId, q: query, which: 'all' })).
			success(function(data) {
				$scope.results = data;
			});
	};

	/**
	 * Result click event handler
	 * @param patient the clicked patient
	 */
	$scope.onResultClick = function(patient) {
		ui.navigate($scope.pageProvider, $scope.page, { patientId: patient.id });
	};

}]);

/**
 * Controller for daily schedule
 */
kenyaemrApp.controller('DailySchedule', ['$scope', '$http', function($scope, $http) {

	$scope.date = null;
	$scope.scheduled = [];

	/**
	 * Initializes the controller
	 * @param appId
	 * @param date
	 * @param pageProvider
	 * @param page
	 */
	$scope.init = function(appId, date, pageProvider, page) {
		$scope.appId = appId;
		$scope.date = date;
		$scope.pageProvider = pageProvider;
		$scope.page = page;
		$scope.fetch();
	};

	/**
	 * Refreshes the schedule
	 */
	$scope.fetch = function() {
		$http.get(ui.fragmentActionLink('kenyaemr', 'patient/patientUtils', 'getScheduled', { appId: $scope.appId, date: $scope.date })).
			success(function(data) {
				$scope.scheduled = data;
			});
	};

	/**
	 * Result click event handler
	 * @param patient the clicked patient
	 */
	$scope.onResultClick = function(patient) {
		ui.navigate($scope.pageProvider, $scope.page, { patientId: patient.id });
	};
}]);

/**
 * Controller for daily seen patients
 */
kenyaemrApp.controller('DailySeen', ['$scope', '$http', function($scope, $http) {

	$scope.date = null;
	$scope.seen = [];

	/**
	 * Initializes the controller
	 * @param appId
	 * @param date
	 * @param pageProvider
	 * @param page
	 */
	$scope.init = function(appId, date, pageProvider, page) {
		$scope.appId = appId;
		$scope.date = date;
		$scope.pageProvider = pageProvider;
		$scope.page = page;
		$scope.fetch();
	};

	/**
	 * Refreshes the seen patients
	 */
	$scope.fetch = function() {
		$http.get(ui.fragmentActionLink('kenyaemr', 'patient/patientUtils', 'getSeenPatients', { appId: $scope.appId, date: $scope.date })).
			success(function(data) {
				$scope.seen = data;
			});
	};

	/**
	 * Result click event handler
	 * @param patient the clicked patient
	 */
	$scope.onResultClick = function(patient) {
		ui.navigate($scope.pageProvider, $scope.page, { patientId: patient.id });
	};
}]);

/**
 * Controller for recently viewed
 */
kenyaemrApp.controller('RecentlyViewed', ['$scope', '$http', function($scope, $http) {

	$scope.recent = [];

	/**
	 * Initializes the controller
	 * @param pageProvider
	 * @param page
	 */
	$scope.init = function() {
		$http.get(ui.fragmentActionLink('kenyaemr', 'patient/patientUtils', 'recentlyViewed')).
			success(function(data) {
				$scope.recent = data;
			});
	};

	/**
	 * Result click event handler
	 * @param patient the clicked patient
	 */
	$scope.onResultClick = function(patient) {
		ui.navigate('kenyaemr', 'chart/chartViewPatient', { patientId: patient.id });
	};
}]);