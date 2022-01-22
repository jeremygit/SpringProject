package com.example.Spring5.entitys

import com.googlecode.objectify.annotation.Entity
import com.googlecode.objectify.annotation.Id
import com.googlecode.objectify.annotation.Index

// TODO add enum type
// No-arg constructor means a constructor with preset value?
@Entity
data class ListingEntity(
    var i: String? = null,
    var name: String? = null,
) {
    @Id val id = i + name
}

data class ListingDto(
    val id: String,
    val name: String,
)