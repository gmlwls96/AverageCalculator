package com.hj.average.ui.component.appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.core.res.R

@ExperimentalMaterial3Api
@Composable
fun AppBar(
    title: String = "",
    isTitleCenter: Boolean = false,
    titleStyle: TextStyle = LocalTextStyle.current,
    actionsArea: (@Composable () -> Unit)? = null,
    navigationIcon: Int = R.drawable.icon_arrow_left_small_mono,
    onNaviClick: (() -> Unit)? = null,
) {
    if (isTitleCenter) {
        CenterAlignedTopAppBar(
            title = {
                Title(
                    title = title,
                    style = titleStyle
                )
            },
            navigationIcon = {
                NavigationIcon(
                    navigationIcon = navigationIcon,
                    onClick = onNaviClick
                )
            },
            actions = {
                actionsArea?.invoke()
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White
            )
        )
    } else {
        TopAppBar(
            title = {
                Title(
                    title = title,
                    style = titleStyle
                )
            },
            navigationIcon = {
                NavigationIcon(
                    navigationIcon = navigationIcon,
                    onClick = onNaviClick
                )
            },
            actions = {
                actionsArea?.invoke()
            },

            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.White
            )
        )
    }
}

@Composable
fun Title(
    title: String,
    style: TextStyle,
) {
    Text(
        text = title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = style
    )
}

@Composable
fun NavigationIcon(
    navigationIcon: Int,
    onClick: (() -> Unit)?,
) {
    onClick?.let {
        IconButton(onClick = it) {
            Icon(
                painter = painterResource(id = navigationIcon),
                contentDescription = "Localized description"
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true)
fun AppBar1Preview() {
    AppBar(
        title = "",
        actionsArea = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Localized description"
                )
            }
        }
    )
}

@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true)
fun AppBar1Preview2() {
    AppBar(
        navigationIcon = R.drawable.icon_arrow_left_small_mono,
        onNaviClick = {}
    )
}

@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true)
fun AppBar1Preview3() {
    AppBar(
        onNaviClick = {}
    )
}