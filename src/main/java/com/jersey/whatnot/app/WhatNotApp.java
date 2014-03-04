package com.jersey.whatnot.app;

import com.jersey.whatnot.injectionexample.WhatEverServiceBinder;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class WhatNotApp extends ResourceConfig {
    public WhatNotApp() {
        packages("com.jersey.whatnot") //auto scan
                .register(new WhatEverServiceBinder())
                .register(SseFeature.class);
    }
}
