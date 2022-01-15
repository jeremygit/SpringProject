package com.example.Spring5.controllers

import com.googlecode.objectify.ObjectifyService.ofy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ofy")
class ObjectifyController {

    @GetMapping
    fun get(): String {
        ofy().save()
        return "success"
    }
}