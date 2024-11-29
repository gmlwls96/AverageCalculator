package com.hj.average.ui.component.bottombar

import androidx.annotation.DrawableRes
import com.hj.average.ui.component.bottombar.model.BottomNavigationRoute

data class NavigationItem(
    @DrawableRes var iconId: Int,
    var titleId: Int,
    override val routeName: String
) : BottomNavigationRoute