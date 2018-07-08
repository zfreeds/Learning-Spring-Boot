package com.zfreeds.test.demo.dog

import com.fasterxml.jackson.annotation.JsonBackReference
import com.zfreeds.test.demo.owner.Owner
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class Dog(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id :Long = 0,
        @field:Size(min =1, max = 20)
        val name:String ="",
        val age : Int = 0,
        @field:ManyToMany(mappedBy = "dogs" ,cascade = [CascadeType.PERSIST, CascadeType.MERGE])
        @field:JsonBackReference
        val owners: MutableList<Owner> = mutableListOf()

)