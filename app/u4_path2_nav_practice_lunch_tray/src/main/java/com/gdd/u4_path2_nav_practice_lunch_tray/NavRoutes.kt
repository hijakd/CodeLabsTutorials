package com.gdd.u4_path2_nav_practice_lunch_tray

import androidx.annotation.StringRes

enum class NavRoutes(@StringRes val title: Int) {
    Start(title = R.string.start_order),
    Entree(title = R.string.choose_entree),
    SideDish(title = R.string.choose_side_dish),
    Accompaniment(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)
}