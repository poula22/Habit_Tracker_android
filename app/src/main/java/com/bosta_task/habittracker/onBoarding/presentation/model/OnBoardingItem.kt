package com.bosta_task.habittracker.onBoarding.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnBoardingItem(
    @DrawableRes val imageId:Int,
    @StringRes val title:Int
)