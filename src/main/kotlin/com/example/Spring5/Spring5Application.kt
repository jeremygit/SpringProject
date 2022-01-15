package com.example.Spring5

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Spring5Application

fun main(args: Array<String>) {
	runApplication<Spring5Application>(*args)
}


@RestController
class HelloController {

	@GetMapping("/hello")
	fun get(): String {
		return "hello"
	}

}

