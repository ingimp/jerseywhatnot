package com.jersey.whatnot.injectionexample;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class WhatEverServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(WhatEverServiceFactory.class).to(WhatEverService.class);
    }
}
