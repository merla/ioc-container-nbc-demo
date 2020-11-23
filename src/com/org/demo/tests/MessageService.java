package com.org.demo.tests;


import com.org.demo.annotations.Injectable;

@Injectable
public class MessageService {
    public String getMessage() {
        return "Hello NBC Peacock!";
    }
}
