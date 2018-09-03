(function () {
    'use strict';

    angular.module('fr.tsodev.assetmgmt.view-components.custom-label')
        .config(function (rxViewComponentProvider) {
            rxViewComponentProvider.registerComponent([
                {
                    name: 'Custom Label',
                    group: 'Asset Mgmt',
                    icon: 'comment_text',
                    type: 'fr-tsodev-assetmgmt-custom-label',
                    designType: 'fr-tsodev-assetmgmt-custom-label-design',
                    bundleId: 'fr.tsodev.assetmgmt',
                    propertiesByName: [
                        {
                            name: 'label',
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