package com.example.Spring5.services

import com.example.Spring5.entitys.ListingEntity
import com.googlecode.objectify.ObjectifyService.ofy
import org.springframework.stereotype.Service

@Service
class ListingService {

    fun getListing(): String {
        return "listing"
    }

    fun getListings(): List<String> {
        return listOf("listing1", "listing2")
    }

    fun putListing(name: String): String {
        val listing = ListingEntity(
            Math.random().toRawBits().toString(),
            name,
        )
        ofy().save().entity(listing).now()
        return name
    }

}