package com.zfreeds.test.demo.owner

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.zfreeds.test.demo.dog.Dog
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class Owner(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)  // Should I be worried the id's are sequencial?
        val id: Long = 0,
        @field:Size(min = 1, max = 20)
        var name : String = "",
        var age : Int = 0,
        var address: String = "",
        @field:ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
        @field:JsonManagedReference
        val dogs: MutableList<Dog> = mutableListOf()
){

}