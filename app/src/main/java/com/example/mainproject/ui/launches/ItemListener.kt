package com.example.mainproject.ui.launches

import com.example.mainproject.data.network.models.SpaceXLaunch

interface ItemListener {
    fun onClickWikipedia(launch: SpaceXLaunch)
    fun onClickArticle(launch: SpaceXLaunch)
}