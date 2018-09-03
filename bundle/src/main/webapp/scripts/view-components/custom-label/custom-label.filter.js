(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt.view-components.custom-label')
        .filter('frTsodevAssetmgmgMyFilter', function () {
            return function (labelText) {
                return labelText;
            };
        });
})();