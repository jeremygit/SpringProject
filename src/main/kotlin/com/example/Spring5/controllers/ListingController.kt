package com.example.Spring5.controllers

import com.example.Spring5.entitys.ListingEntity
import com.example.Spring5.services.ListingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/listings")
class ListingController(
    val listingService: ListingService
) {
    @GetMapping
    fun get(): ListingsFiniteResponse {
        ListingsFiniteResponse.Error("Error!")
        return ListingsFiniteResponse.Success(listingService.getListings())
    }

    @GetMapping("/latest")
    fun getLatest(): ListingsFiniteResponse {
        return ListingsFiniteResponse.Success(listOf(listingService.getLatest()))
    }

    @GetMapping("/ents")
    fun getEntities(): ListingsFiniteResponse {
        return try {
            ListingsFiniteResponse.Success(listingService.getLisitingsEntitys())
        } catch (e: Exception) {
            ListingsFiniteResponse.Error("Error!")
        }
    }

    @GetMapping("/ent")
    fun getEntity(
        @RequestParam id: String
    ): ListingsFiniteResponse {
        return ListingsFiniteResponse.Success(listOf(listingService.getListingEntity(id)))
//        return try {
//            ListingsFiniteResponse.Success(listOf(listingService.getListingEntity()))
//        } catch (e: Exception) {
//            ListingsFiniteResponse.Error("Error!")
//        }
    }

    // Hierarchy doesnt matter i.e. /{id} vs /save
    @GetMapping("/{id}")
    fun getListing(
        @PathVariable id: String
    ): String {
        val listing = listingService.getListing()
        return "$id $listing"
    }

    @GetMapping("/save")
    fun putListing(
        @RequestParam name: String
        // @RequestBody params: ListingPutBody
    ): String {
        return listingService.putListing(name)
    }

}

data class ListingsResponse(
    val listings: List<String>
)

sealed class ListingsFiniteResponse {

    data class Success(
        val listings: List<String>? = null,
        val listingsEntitys: List<ListingEntity>? = null,
    ): ListingsFiniteResponse() {
        constructor(listingsEntitys: List<ListingEntity>): this(null, listingsEntitys)
    }

    data class Error(
        val reason: String
    ): ListingsFiniteResponse()

    object NoResponse: ListingsFiniteResponse()

}

data class ListingPutBody(
    val name: String
)

//
//
//

//package com.example.Spring5.controllers
//
//import com.example.Spring5.entitys.ListingEntity
//import com.example.Spring5.services.ListingService
//import com.google.common.annotations.VisibleForTesting
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("/listings")
//class ListingController(
//    val listingService: ListingService
//) {
//    @GetMapping
//    fun get(): ListingsFiniteResponse {
//        ListingsFiniteResponse.Error("Error!")
//        return ListingsFiniteResponse.SuccessEntity(listingService.getListings())
//    }
//
//    // Hierarchy doesnt matter i.e. /{id} vs /save
//    @GetMapping("/{id}")
//    fun getListing(
//        @PathVariable id:String
//        // Renaming of path vars
//        // @PathVariable("agencyId") agencyId: UUID,
//        // @PathVariable("vaultContactId") vaultContactId: Long,
//        // @PathVariable("vaultNoteId") vaultNoteId: Long,
//    ): String {
//        val listing = listingService.getListing()
//        return "$id $listing"
//    }
//
//    @GetMapping("/save")
//    fun putListing(
//        @RequestParam name: String
//        // @RequestBody params: ListingPutBody
//    ): String {
//        return listingService.putListing(name)
//    }
//
//    // Interesting visibility modifier/annotation
//    // @VisibleForTesting
//
//    // applicationEventPublisher
//}
//
//data class ListingsResponse(
//    val listings: List<String>
//)
//
//sealed class ListingsFiniteResponse {
//
//    data class SuccessString(
//        val listings: List<String>
//    ): ListingsFiniteResponse()
//
//    data class SuccessEntity(
//        val listings: List<ListingEntity>
//    ): ListingsFiniteResponse()
//
//    data class Error(
//        val reason: String
//    ): ListingsFiniteResponse()
//
//    object NoResponse: ListingsFiniteResponse()
//
//}
//
//data class ListingPutBody(
//    val name: String
//)

// vararg with * i.e. vararg jobs = *jobs.toTypedArray()

// class TaskQueue(gsonBuilder: GsonBuilder) : JobQueue, ApplicationContextAware {

//import com.google.appengine.api.taskqueue.Queue
//import com.google.appengine.api.taskqueue.QueueFactory
//import com.google.appengine.api.taskqueue.TaskOptions
//TaskOptions.Builder
//.withMethod(method)