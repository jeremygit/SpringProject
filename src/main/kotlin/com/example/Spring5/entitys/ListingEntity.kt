package com.example.Spring5.entitys

import com.googlecode.objectify.annotation.Entity
import com.googlecode.objectify.annotation.Id

// TODO add enum type
@Entity
data class ListingEntity(
    @Id
    val id: String,
    val name: String,
)