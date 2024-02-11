package com.bosta_task.habittracker.onBoarding.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.bosta_task.habittracker.onBoarding.presentation.components.OnBoardingBottom
import com.bosta_task.habittracker.onBoarding.presentation.components.OnBoardingContent
import com.bosta_task.habittracker.onBoarding.presentation.model.OnBoardingItems
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier
) {
    val size = remember {
        OnBoardingItems.items.size
    }
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState {
        OnBoardingItems.items.size
    }

    Column(modifier = modifier) {
        HorizontalPager(state = pageState,modifier= Modifier.fillMaxHeight(0.85f)) { page ->
            val onBoardingItem = OnBoardingItems.items[page]
            OnBoardingContent(
                modifier = modifier, header = onBoardingItem.title, imageId = onBoardingItem.imageId
            )
        }
        OnBoardingBottom(
            modifier=Modifier.fillMaxWidth(),
            index = pageState.currentPage,
            size = size,
            onSkipClick = {},
            onNextClick = {
                if (pageState.currentPage + 1 <size) scope.launch {
                    pageState.scrollToPage(pageState.currentPage+1)
                }
            }
        )
    }
}