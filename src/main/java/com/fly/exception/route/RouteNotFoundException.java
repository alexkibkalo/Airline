package com.fly.exception.route;

import com.fly.exception.standard.NotFoundException;

public class RouteNotFoundException extends NotFoundException {

    public RouteNotFoundException() {
        super("Route not found");
    }

    public RouteNotFoundException(String message) {
        super(message);
    }
}
