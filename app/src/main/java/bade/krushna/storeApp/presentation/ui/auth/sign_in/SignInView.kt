package bade.krushna.storeApp.presentation.ui.auth.sign_in

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import bade.krushna.storeApp.presentation.navigation.INavigate
import bade.krushna.storeApp.presentation.navigation.INavigationManager
import bade.krushna.storeApp.presentation.navigation.Navigation
import bade.krushna.storeApp.presentation.navigation.routes.AuthRoute

@Composable
fun SignInView(controller: SignInRoute) {

}


class SignInRoute(callbackManager: INavigationManager): INavigate(callbackManager),AuthRoute {

    override fun getRoute() = "$baseRoute/signin"
    @Composable
    override fun NavigationView() {
        return SignInView(
            this
        )
    }
}