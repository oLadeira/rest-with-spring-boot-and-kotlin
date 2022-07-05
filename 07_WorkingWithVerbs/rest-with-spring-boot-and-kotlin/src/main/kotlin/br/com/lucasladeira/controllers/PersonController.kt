package br.com.lucasladeira.controllers

import br.com.lucasladeira.entities.Person
import br.com.lucasladeira.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService


    @GetMapping("/{id}")
    fun findById(@PathVariable(name = "id") id: Long): Person{
        return personService.findById(id)
    }

    @GetMapping
    fun findAll(): List<Person>{
        return personService.findAll()
    }
}