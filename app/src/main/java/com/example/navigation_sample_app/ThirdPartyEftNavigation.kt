package com.example.navigation_sample_app

import androidx.navigation.NavController


fun NavController.navigateToThirdPartyEftRoute() =
    navigate(route = AppDestination.ThirdPartyEft)
