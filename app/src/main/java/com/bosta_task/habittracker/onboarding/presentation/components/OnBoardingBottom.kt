package com.bosta_task.habittracker.onboarding.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat.ScrollIndicators
import com.bosta_task.habittracker.R

@Composable
fun OnBoardingBottom(
    modifier: Modifier = Modifier,
    index: Int,
    size: Int,
    onSkipClick: () -> Unit,
    onNextClick: () -> Unit
) {
    if (index < size - 1) {
        Row(
            modifier = modifier
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.skip),
                Modifier.clickable { onSkipClick() },
                style = MaterialTheme.typography.bodySmall
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                repeat(size) { Indicator(isSelected = it == index) }
            }
            Text(
                text = stringResource(R.string.next),
                modifier = Modifier.clickable { onNextClick() },
                style = MaterialTheme.typography.bodySmall
            )
        }
    } else {
        Box(modifier = modifier) {
            Button(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.medium.copy(all = CornerSize(8.dp)),
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = stringResource(R.string.get_started),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 11.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = ""
    )

    Box(
        modifier = Modifier
            .height(11.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.onPrimary
                else MaterialTheme.colorScheme.primary
            )
    ) {

    }
}

@Preview
@Composable
fun BottomPreview() {
    MaterialTheme {
        Surface {
            OnBoardingBottom(
                index = 3,
                size = 4,
                onSkipClick = {},
                onNextClick = {},
                modifier = Modifier.width(300.dp)
            )
        }
    }
}