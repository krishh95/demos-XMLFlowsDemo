package bade.krushna.storeApp.presentation.ui.auth.splash

import androidx.compose.runtime.Composable
import bade.krushna.storeApp.presentation.navigation.INavigate
import bade.krushna.storeApp.presentation.navigation.INavigationManager
import bade.krushna.storeApp.presentation.navigation.routes.MainRoute
import bade.krushna.storeApp.presentation.ui.auth.sign_in.SignInRoute

@Composable
fun SplashView(controller: SplashRoute) {

    controller.navigateToSignIn()
}

class SplashRoute(callbackManager: INavigationManager) : INavigate(callbackManager), MainRoute{
    override fun getRoute() = "$baseRoute/splash"

    @Composable
    override fun NavigationView() {
        SplashView(
            this
        )
    }

    fun navigateToSignIn(){
        navigate(
            SignInRoute(
                callbackManager = getCallbackManager()
            )
        )
    }



}