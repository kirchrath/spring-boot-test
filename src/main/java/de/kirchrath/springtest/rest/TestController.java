package de.kirchrath.springtest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@RestController
public class TestController {

    @GetMapping("/hostname")
    public String hostname() throws UnknownHostException {
        return Inet4Address.getLocalHost().getHostName();
    }
}
