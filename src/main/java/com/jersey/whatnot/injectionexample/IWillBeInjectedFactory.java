package com.jersey.whatnot.injectionexample;

import org.glassfish.hk2.api.Factory;

public class IWillBeInjectedFactory implements Factory<IWillBeInjected> {
    @Override
    public IWillBeInjected provide() {
        return new IWillBeInjected();
    }

    @Override
    public void dispose(IWillBeInjected instance) {

    }
}
