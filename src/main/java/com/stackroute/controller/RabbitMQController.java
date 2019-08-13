package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.domain.MovieStars;
import com.stackroute.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/")
public class RabbitMQController {

    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;

    @GetMapping(value = "/movie")
    public String producer(@RequestParam("name") String name, @RequestParam("id") int id,
                           @RequestParam("moviereleased") String moviereleased) {

        Movie movie = new Movie();
        movie.setId(id);
        movie.setName(name);
        movie.setMoviereleased(moviereleased);
        rabbitMQSenderService.send(movie);

        return "Message sent to the RabbitMQ movie Successfully";
    }

    @GetMapping(value = "/movieStars")
    public String producer(@RequestParam("name") String name, @RequestParam("id") int id,
                           @RequestParam("gender") String gender, @RequestParam("age") int age
    ) {

        MovieStars movieStars = new MovieStars();
        movieStars.setId(id);
        movieStars.setName(name);
        movieStars.setGender(gender);
        movieStars.setAge(age);
        rabbitMQSenderService.send(movieStars);

        return "Message sent to the RabbitMQ movieStars Successfully";
    }

}
