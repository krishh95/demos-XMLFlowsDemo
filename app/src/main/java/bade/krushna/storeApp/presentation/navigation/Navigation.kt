package bade.krushna.storeApp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import bade.krushna.storeApp.presentation.ui.auth.sign_in.SignInRoute
import bade.krushna.storeApp.presentation.ui.auth.splash.SplashRoute

class Navigation(val controller: NavHostController):INavigationManager {

    @Composable
    fun Navigate() {
        NavHost(
            navController = controller,
            startDestination = SplashRoute(
                callbackManager = this@Navigation
            ).getRoute(),
        ) {

            SplashRoute(
                callbackManager = this@Navigation
            ).navigate(navGraphBuilder = this)

            navigation(
                route = SignInRoute(
                    callbackManager = this@Navigation
                ).baseRoute,
                startDestination = SignInRoute(
                    callbackManager = this@Navigation
                ).getRoute()
            ) {

                SignInRoute(
                    callbackManager = this@Navigation
                ).navigate(navGraphBuilder = this)

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

    override fun navigate(navigation: INavigate) {
        navigation.navigateToMe(
            navigator = this@Navigation
        )
    }
}
