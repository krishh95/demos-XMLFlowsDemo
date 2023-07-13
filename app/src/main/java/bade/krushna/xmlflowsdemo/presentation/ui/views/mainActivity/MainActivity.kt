package bade.krushna.xmlflowsdemo.presentation.ui.views.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import bade.krushna.xmlflowsdemo.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainActivityVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {

        }
    }
}