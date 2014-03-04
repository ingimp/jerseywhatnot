package com.jersey.whatnot.customexception;

import javax.ws.rs.WebApplicationException;

public class MyException extends WebApplicationException {
    public MyException(String msg) {
        super(msg);
    }
}
