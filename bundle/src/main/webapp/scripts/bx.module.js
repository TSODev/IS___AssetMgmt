(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt', [
        'ngSanitize',
        'ui.router',
        // all modules that provide non-abstract navigation routes
        'fr.tsodev.assetmgmt.home',
        'fr.tsodev.assetmgmt-ext',
        //Actions
//        'fr.tsodev.assetmgmt.actions.use-rx-messages',
        //View-Components
        'fr.tsodev.assetmgmt.view-components.custom-label',
        'fr.tsodev.assetmgmt.view-components.barcode'
    ]);
})();
