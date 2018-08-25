(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt.home').config(function ($stateProvider) {
        $stateProvider.state('bx.home', {
            url: '/home',
            templateUrl: 'scripts/home/home.view.html',
            controller: 'HomeController'
        });
    });
})();
