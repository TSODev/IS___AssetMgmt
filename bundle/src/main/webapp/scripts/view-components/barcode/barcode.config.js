(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt.view-components.barcode')
        .config(function (rxViewComponentProvider) {
            rxViewComponentProvider.registerComponent([
                {
                    name: 'Barcode',
                    group: 'Asset Mgmt',
                    icon: 'text',
                    type: 'fr-tsodev-assetmgmt-barcode',
                    designType: 'fr-tsodev-assetmgmt-barcode-design',
                    bundleId: 'fr.tsodev.assetmgmt',
                    propertiesByName: [
                        {
                            name: 'tag',
                            type: 'string',
                            isConfig: true,     // Input parameter
                            isProperty: false,  // Not an output parameter
                            isRequired: false,  // Not required
                            enableExpressionEvaluation: true    // The expression will be evaluated.
                        }
                    ]
                }
            ]);
        });
})();