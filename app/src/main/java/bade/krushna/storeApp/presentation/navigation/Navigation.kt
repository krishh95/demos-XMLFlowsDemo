package bade.krushna.storeApp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import bade.krushna.storeApp.presentation.ui.auth.sign_in.SignInRoute
import bade.krushna.storeApp.presentation.ui.auth.splash.SplashRoute

class Navigation(val controller: NavHostController):INavigationManager {
val nav= this@Navigation
    @Composable
    fun Navigate() {
        NavHost(
            navController = controller,
            startDestination = SplashRoute(nav).getRoute(),
        ) {

            SplashRoute(nav).navigate(navGraphBuilder = this)

            navigation(
                route = SignInRoute(nav).baseRoute,
                startDestination = SignInRoute(nav).getRoute()
            ) {

                SignInRoute(nav).navigate(navGraphBuilder = this)

            }
        }
    }

    override fun popBackStack() {
        controller.popBackStack()
    }

    override fun popBackStack(
        navigation: INavigate,
        popThatScreenToo: Boolean
    ) {
        controller.popBackStack(
            route = navigation.getRoute(),
            inclusive = popThatScreenToo
        )
    }

    override fun popNavGraph(navRoute: String) {
        controller.popBackStack(route = navRoute, inclusive = false, saveState = false)
    }

    override fun navigate(navigation: INavigate) {
        navigation.navigateToMe(
            navigator = nav
        )
    }
}
