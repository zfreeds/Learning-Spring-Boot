package com.zfreeds.test.demo.dog

import org.springframework.data.repository.CrudRepository

interface DogRepository : CrudRepository<Dog, Long> {
}