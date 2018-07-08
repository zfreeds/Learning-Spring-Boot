package com.zfreeds.test.demo.owner

import com.zfreeds.test.demo.dog.Dog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/owner")
class OwnerController {

    @Autowired
    private lateinit var ownerService: OwnerService

    @GetMapping("/")
    fun getAllOwners(): List<Owner> {
       return ownerService.getAllOwners()
    }

    @PostMapping("/")
    fun addOwner(@Validated  @RequestBody owner: Owner): List<Owner> {
        ownerService.addOwner(owner)
        return ownerService.getAllOwners()
    }

    @PutMapping("/{ownerId}/address")
    fun updateOwnerAddress(@PathVariable ownerId: Long, @RequestBody address: String): Owner {
        ownerService.updateOwnerAddress(ownerId, address)
        return ownerService.getOwner(ownerId)
    }


    @DeleteMapping("")
    fun deleteAll(): String {
        // Obviously only for practice purposes
        ownerService.deleteAllOwners()
        return "SUCCESSFULLY DELETED ALL OWNERS"
    }

    @PutMapping("/{ownerId}")
    fun addPetToOwner(@PathVariable ownerId: Long,  @RequestBody dog : Dog){
        ownerService.addPetToOwner(ownerId, dog)
    }
}