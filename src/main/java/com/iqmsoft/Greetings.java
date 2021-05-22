
package com.iqmsoft;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("hh")
public class Greetings {
    public String getMsg(){
        return "This is a Spring Boot JSF Test";
    }
}
