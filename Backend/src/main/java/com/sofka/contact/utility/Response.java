package com.sofka.contact.utility;

public class Response {


    public Boolean error;


    public String message;


    public Object data;
    public String status;


    public Response() {
        error = false;
        message = "";
        data = null;
    }

    public void restart() {
        error = false;
        message = "";
        data = null;
    }
}
