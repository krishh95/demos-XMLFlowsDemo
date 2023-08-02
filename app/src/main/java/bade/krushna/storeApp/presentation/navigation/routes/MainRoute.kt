package bade.krushna.storeApp.presentation.navigation.routes

import bade.krushna.storeApp.presentation.navigation.MyRoute

interface MainRoute : MyRoute {
    override var baseRoute: String
        get() = "MainRoute"
        set(value) {}


}