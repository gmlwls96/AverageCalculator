package com.hj.average.ui.route

import hw.dp.core.ui.navigator.annotation.RouteAnnotation
import hw.dp.core.ui.navigator.api.Route
import hw.dp.route.generated.RouteExtension.Companion.getValueRoute

@Suppress("EmptyClassBlock")
@RouteAnnotation
class DetailRoute(val itemId: Int) : Route {
    companion object {}

    override fun buildValuePath(): String = getValueRoute()
}