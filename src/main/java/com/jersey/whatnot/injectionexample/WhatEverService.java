package com.jersey.whatnot.injectionexample;

import org.jvnet.hk2.annotations.Service;

@Service
public class WhatEverService {
    public String getIt() {
        return "injection successfully done.";
    }
}
