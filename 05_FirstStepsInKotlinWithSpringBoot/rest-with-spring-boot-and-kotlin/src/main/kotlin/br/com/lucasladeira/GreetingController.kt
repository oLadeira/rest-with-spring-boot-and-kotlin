package br.com.lucasladeira

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(name = "name", defaultValue = "World") name: String): Greeting{
        return Greeting(counter.incrementAndGet(), "Hello, $name!")
    }

}