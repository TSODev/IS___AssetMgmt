/*
 * Copyright (c) 2001-2015 BMC Software, Inc. All rights reserved. This software is the confidential
 * and proprietary information of BMC Software, Inc ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the
 * license agreement between you and BMC Software, Inc.
 */

package fr.tsodev.bundle;

import com.bmc.arsys.rx.services.common.RxBundle;
import com.bmc.arsys.rx.services.common.domain.WebResourceDefinition;

import fr.tsodev.integration.impl.AssetManagementServiceImpl;

/**
 * Rx Web Activator class.
 */
public class MyApplication extends RxBundle {

    /* (non-Javadoc)
     * @see com.bmc.arsys.rx.business.common.RxBundle#register()
     */
    @Override
    protected void register() {
        //
        // TODO: Register static web resources and framework extensions.
        //
        // registerService(new MyService());

    	registerService(new AssetManagementServiceImpl());
        //

        registerStaticWebResource(String.format("/%s", getId()), "/webapp");
    }
}
