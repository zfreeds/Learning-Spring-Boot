package com.zfreeds.test.demo.owner

import org.springframework.data.repository.CrudRepository

interface OwnerRepository : CrudRepository<Owner, Long> {
}