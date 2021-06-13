package com.example.mainproject.data.network.models

data class SpaceXLaunch(
    val mission_name: String,
    val details: String,
    val launch_date_utc: String,
    val links: Links,
)