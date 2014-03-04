package com.jersey.whatnot.customexception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class MyExceptionProvider implements ExceptionMapper<MyException> {

    @Override
    public Response toResponse(MyException exception) {
        return Response
                .status(Response.Status.FORBIDDEN)
                .entity(exception.getMessage())
                .build();
    }
}
