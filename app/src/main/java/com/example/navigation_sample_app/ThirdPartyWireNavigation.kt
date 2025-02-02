package com.example.navigation_sample_app

import AppDestination
import androidx.navigation.NavController

fun NavController.navigateToThirdPartyWireRoute() =
    navigate(route = AppDestination.ThirdPartyEft)
