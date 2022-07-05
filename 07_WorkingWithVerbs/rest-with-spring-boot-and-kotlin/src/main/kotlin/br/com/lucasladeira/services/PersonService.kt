package br.com.lucasladeira.services

import br.com.lucasladeira.entities.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person{
        logger.info("Finding one person!")

        val person = Person()
        person.id = id
        person.firstName = "Leandro"
        person.lastName = "Costa"
        person.address = "Uberlândia"
        person.gender = "Male"
        return person
    }

    fun findAll(): List<Person>{
        logger.info("Finding All people!")

        val persons: MutableList<Person> = arrayListOf()

        for (i in 0..7){
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lastName = "Last name $i"
        person.address = "Some address in Brazil"
        person.gender = "Male"
        return person
    }
}