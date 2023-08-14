package bade.krushna.storeApp.presentation.ui.auth.sign_in

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import bade.krushna.storeApp.presentation.navigation.INavigate
import bade.krushna.storeApp.presentation.navigation.INavigationManager
import bade.krushna.storeApp.presentation.navigation.routes.AuthRoute
import bade.krushna.storeApp.presentation.ui.auth.splash.SplashRoute

@Composable
fun SignInView(controller: SignInRoute? = null) {
    Box(Modifier.fillMaxSize()) {

       Button(
            onClick = {
                controller?.popNavGraph(controller.splashRoute())
            }
        ) {
            Text("GO Back")
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun Preview() = SignInView()


class SignInRoute(private val callbackManager: INavigationManager):INavigate(),AuthRoute {

    override fun getRoute() = "/signin"
    override fun callbackManager() = callbackManager

    fun splashRoute() = SplashRoute(callbackManager()).baseRoute

    @Composable
    override fun NavigationView() {
        return SignInView(
            this
        )
    }
}