package com.example.Spring5.services

import com.example.Spring5.entitys.ListingEntity
import com.googlecode.objectify.Key
import com.googlecode.objectify.ObjectifyService.ofy
import com.googlecode.objectify.cmd.Query
import org.springframework.stereotype.Service

@Service
class ListingService {

    fun getListing(): String {
        return "listing"
    }

    fun getListings(): List<String> {
        return listOf("listing1", "listing2")
    }

    fun getListingEntity(id: String): ListingEntity {
        return ofy().load().type(ListingEntity::class.java).id(id).now()
        // return ofy().load().key(Key.create(ListingEntity::class.java,"4603224087470262402_90")).now()
    }

    fun getLatest(): ListingEntity {
        return ofy().load().type(ListingEntity::class.java).first().now()
    }

    fun queryListings(): Query<ListingEntity> {
        return ofy().load().type(ListingEntity::class.java)
    }

    fun getLisitingsEntitys(): List<ListingEntity> {
        val listings = queryListings().list()
        return listings
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