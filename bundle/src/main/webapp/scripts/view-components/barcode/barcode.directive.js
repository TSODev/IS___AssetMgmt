(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt.view-components.barcode')
        .directive('frTsodevAssetmgmtBarcode', function () {
            return {
                restrict: 'E',
                templateUrl: 'scripts/view-components/barcode/fr-tsodev-assetmgmt-barcode.directive.html',
                scope: {
                    rxConfiguration: '='
                },

                link: function ($scope) {
                    var _config;

                    var init = function () {
                        _config = $scope.rxConfiguration.propertiesByName;

                        // See : https://github.com/lindell/JsBarcode

                        $scope.barcode = JsBarcode("#barcode", _config.tag , {
                            format: "CODE128",
                            lineColor: "#00",
                            background: "#EEEEEE",
                            width:2,
                            height:80,
                            displayValue: true
                          });
                        console.log("Barcode : ", _config.tag);
                    };
                    $scope.$watch('rxConfiguration.propertiesByName.tag', init);
                }

            };
        });
})();