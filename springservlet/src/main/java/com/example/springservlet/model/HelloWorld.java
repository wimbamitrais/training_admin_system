// This is for Spring PBI 1

package com.example.springservlet.model;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println("Your message: " + message);
    }
}
