package bade.krushna.storeApp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

interface MyRoute{
    var baseRoute : String
}

abstract class INavigate{
    abstract fun getRoute():String
    abstract fun callbackManager() : INavigationManager

    @Composable
    protected abstract fun NavigationView()


    fun navigateToMe(navigator : Navigation) {
        navigator.controller.navigate(getRoute())
    }

    fun navigate(
        navGraphBuilder: NavGraphBuilder
    ){
        navGraphBuilder.composable(getRoute()) {
            NavigationView()
        }
    }

    fun popupBackStack() = callbackManager().popBackStack()
    fun popNavGraph(route : String) = callbackManager().popNavGraph(route)

    fun popupBackStack(
        navigation: INavigate,
        popThatScreenToo : Boolean
    ) = callbackManager().popBackStack(
        navigation = navigation,
        popThatScreenToo = popThatScreenToo
    )

    fun navigate(
        navigation: INavigate
    )= callbackManager().navigate(navigation = navigation)

}

interface INavigationManager{
    fun popBackStack()
    fun popNavGraph(navRoute : String)
    fun popBackStack(
        navigation: INavigate,
        popThatScreenToo : Boolean
    )
    fun navigate(
        navigation: INavigate
    )
}
