package com.jersey.whatnot.injectionexample;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class IWillBeInjectedBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(IWillBeInjectedFactory.class).to(IWillBeInjected.class);
    }
}
