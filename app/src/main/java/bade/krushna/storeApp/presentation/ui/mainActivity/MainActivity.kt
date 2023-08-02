package bade.krushna.storeApp.presentation.ui.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import bade.krushna.storeApp.di.Dependancies
import bade.krushna.storeApp.presentation.navigation.Navigation
import bade.krushna.xmlflowsdemo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    val viewModel by viewModels<MainActivityVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setContent {
            val navController = rememberNavController()
            //..builder().myModule(MyModule()).build().inject(this)

            Navigation(navController).Navigate()
        }
    }
}