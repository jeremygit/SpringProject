package com.example.Spring5.controllers

import com.googlecode.objectify.ObjectifyService.ofy
import com.googlecode.objectify.annotation.Entity
import com.googlecode.objectify.annotation.Id
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ofy")
class ObjectifyController {

    @GetMapping
    fun get(): String {
        ofy().save().entity(ObjectifyEntity1("100", "Test")).now()
        return "success"
    }
}

@Entity
data class ObjectifyEntity1(
    @Id
    val id: String,
    val name: String
)