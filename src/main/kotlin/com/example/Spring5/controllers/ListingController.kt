package com.example.Spring5.controllers

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

    // Hierarchy doesnt matter i.e. /{id} vs /save
    @GetMapping("/{id}")
    fun getListing(
        @PathVariable id:String
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
        val listings: List<String>
    ): ListingsFiniteResponse()

    data class Error(
        val reason: String
    ): ListingsFiniteResponse()

    object NoResponse: ListingsFiniteResponse()

}

data class ListingPutBody(
    val name: String
)