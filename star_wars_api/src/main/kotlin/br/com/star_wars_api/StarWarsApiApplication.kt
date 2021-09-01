package br.com.star_wars_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarWarsApiApplication

fun main(args: Array<String>) {
	runApplication<StarWarsApiApplication>(*args)
}
