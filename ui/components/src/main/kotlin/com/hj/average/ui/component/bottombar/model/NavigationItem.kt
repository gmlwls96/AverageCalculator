package com.hj.average.ui.component.bottombar.model

import androidx.annotation.DrawableRes

data class NavigationItem(
    @DrawableRes var iconId: Int,
    var titleId: Int,
    override val routeName: String
) : BottomNavigationRoute