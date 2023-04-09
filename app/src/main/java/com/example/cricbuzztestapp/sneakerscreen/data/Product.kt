package com.example.cricbuzztestapp.sneakerscreen.data


data class Product(
    val id: Int = 0,
    val name: String,
    val shoe: Int,
    val price: String,
    val brand: String? = null,
    val colorway: String? = null,
    val gender: String? = null,
    val media: Media? = null,
    val releaseDate: String? = "2022-12-15",
    val styleId: String? = null,
    val title: String? = null,
    val year: String? = null

    )