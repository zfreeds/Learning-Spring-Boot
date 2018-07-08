package com.zfreeds.test.demo.dog

import com.zfreeds.test.demo.owner.Owner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dog")
class DogController {

    @Autowired
    private lateinit var dogService: DogService

    @GetMapping("")
    fun getAllDogs() = dogService.getAllDogs()

    @PostMapping("")
    fun addDog(@RequestBody dog: Dog) {
        dogService.addDog(dog)

    }
    @GetMapping("/{dogId}/owners")
    fun getOwners(@PathVariable dogId : Long): MutableList<Owner> {
        return dogService.getOwners(dogId)
    }
}

