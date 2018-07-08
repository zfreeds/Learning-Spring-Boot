package com.zfreeds.test.demo.dog

import com.zfreeds.test.demo.owner.Owner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DogService {

    @Autowired
    lateinit var dogRepository: DogRepository


    fun getAllDogs() = dogRepository.findAll()

    fun addDog(dog : Dog) = dogRepository.save(dog)
    fun getOwners(dogId: Long): MutableList<Owner> {
        val dog = dogRepository.findById(dogId).get()
        return dog.owners
    }

}