package bade.krushna.storeApp.presentation.ui.auth.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import bade.krushna.storeApp.R
import bade.krushna.storeApp.presentation.navigation.INavigate
import bade.krushna.storeApp.presentation.navigation.INavigationManager
import bade.krushna.storeApp.presentation.navigation.routes.MainRoute
import bade.krushna.storeApp.presentation.ui.auth.sign_in.SignInRoute
import kotlinx.coroutines.delay

@Composable
fun SplashView(controller: SplashRoute) {

    LaunchedEffect(key1 = true){
        delay(3000)
        controller.navigateToSignIn()
    }
    Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(
                    id = R.drawable.logo
                ),
                contentDescription = "logo"
            )
    }
}
@Preview(showSystemUi = true, widthDp = 100, heightDp = 200)
@Composable
fun SplashPreviewView() {

    LaunchedEffect(key1 = true){
        delay(3000)
        //controller.navigateToSignIn()
    }
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(
                id = R.drawable.logo
            ),
            contentDescription = "logo"
        )
    }
}

class SplashRoute(val callbackManager: INavigationManager) : INavigate(),MainRoute{
    override fun getRoute() = "/splash"
    override fun callbackManager() = callbackManager

    @Composable
    override fun NavigationView() {
        SplashView(
            controller = this
        )
    }

    fun navigateToSignIn(){
        navigate(
            SignInRoute(
                callbackManager = callbackManager()
            )
        )
    }



}