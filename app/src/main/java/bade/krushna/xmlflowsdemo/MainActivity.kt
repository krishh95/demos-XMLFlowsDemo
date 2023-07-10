package bade.krushna.xmlflowsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class MainActivity : AppCompatActivity() {
    //val viewmodel by viewModels<MainActivityVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewmodel.item

        val item1 = flow<String> {

        }.stateIn(GlobalScope, SharingStarted.WhileSubscribed(),null)

    }
}