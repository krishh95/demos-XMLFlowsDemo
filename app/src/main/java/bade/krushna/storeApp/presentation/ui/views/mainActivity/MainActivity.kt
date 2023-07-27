package bade.krushna.storeApp.presentation.ui.views.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import bade.krushna.xmlflowsdemo.R

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainActivityVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setContent {

        }
    }
}