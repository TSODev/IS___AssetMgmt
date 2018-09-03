(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt.view-components.custom-label')
        .directive('frTsodevAssetmgmtCustomLabel', function () {
            return {
                restrict: 'E',
                templateUrl: 'scripts/view-components/custom-label/fr-tsodev-assetmgmt-custom-label.directive.html',
                scope: {
                    rxConfiguration: '='
                },

                link: function ($scope) {
                    var _config;

                    var init = function () {
                        _config = $scope.rxConfiguration.propertiesByName;
                        $scope.Label = _config.label;
                    };
                    $scope.$watch('rxConfiguration.propertiesByName.label', init);
                }

            };
        });
})();