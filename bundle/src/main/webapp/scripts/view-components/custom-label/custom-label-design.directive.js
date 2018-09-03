(function () {
    'use strict';
    
    angular.module('fr.tsodev.assetmgmt.view-components.custom-label')
        .directive('frTsodevAssetmgmtCustomLabelDesign', function () {
            return {
                restrict: 'E',
                templateUrl: 'scripts/view-components/custom-label/fr-tsodev-assetmgmt-custom-label-design.directive.html',

                scope: {
                    rxConfiguration: '='
                }
            };
        });
})();