package bade.krushna.storeApp.presentation.navigation.routes

import bade.krushna.storeApp.presentation.navigation.MyRoute

interface AuthRoute : MyRoute {
    override var baseRoute: String
        get() = "auth"
        set(value) {}
}