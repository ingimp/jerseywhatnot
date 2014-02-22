package com.jersey.whatnot.injectionexample;

import org.glassfish.hk2.api.Factory;

public class WhatEverServiceFactory implements Factory<WhatEverService> {
    @Override
    public WhatEverService provide() {
        return new WhatEverService();
    }

    @Override
    public void dispose(WhatEverService instance) {

    }
}
