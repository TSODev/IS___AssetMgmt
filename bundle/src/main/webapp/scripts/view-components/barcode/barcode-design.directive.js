(function () {
    'use strict';
    
    angular.module('fr.tsodev.assetmgmt.view-components.barcode')
        .directive('frTsodevAssetmgmtBarcodeDesign', function () {
            return {
                restrict: 'E',
                templateUrl: 'scripts/view-components/barcode/fr-tsodev-assetmgmt-barcode-design.directive.html',

                scope: {
                    rxConfiguration: '='
                }
            };
        });
})();