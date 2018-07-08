package com.zfreeds.test.demo.owner

import com.zfreeds.test.demo.dog.Dog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OwnerService {

    @Autowired
    private lateinit var ownerRepository: OwnerRepository


    fun getAllOwners(): List<Owner> {
        return ownerRepository.findAll().toList()
    }

    fun addOwner(owner: Owner){
        ownerRepository.save(owner)
    }

    fun getOwner(id: Long): Owner {
       return ownerRepository.findById(id).get()
    }
    fun updateOwnerAddress(id : Long, address : String){
        // Probably wouldn't be the best way to do this. Multithreading issues could probably arise
        val owner = getOwner(id)
        owner.address = address
        ownerRepository.save(owner)
    }
    fun deleteAllOwners(){
        ownerRepository.deleteAll()
    }

    fun addPetToOwner(ownerId: Long, dog : Dog) {
        val owner = ownerRepository.findById(ownerId).get()
        owner.dogs.add(dog)
        ownerRepository.save(owner)
    }
}