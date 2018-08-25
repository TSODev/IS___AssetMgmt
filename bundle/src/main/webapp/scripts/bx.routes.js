(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt').config(function ($stateProvider) {
        $stateProvider.state('bx', {
            parent: 'rx.viewport',
            template: '<ui-view/>'
        });
    });
})();
