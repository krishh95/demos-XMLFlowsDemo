package bade.krushna.storeApp.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import bade.krushna.storeApp.data.remote.IApiServices
import bade.krushna.storeApp.presentation.navigation.Navigation
import bade.krushna.storeApp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object Dependancies {

    @Provides
    fun retrofit(okHttpClient: OkHttpClient) : IApiServices {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(IApiServices::class.java)
    }
    @Provides
    fun clientProvider():OkHttpClient{
        return OkHttpClient().newBuilder().apply {
            this.connectTimeout(1000,TimeUnit.MILLISECONDS)
            this.readTimeout(1000,TimeUnit.MILLISECONDS)
            this.writeTimeout(1000,TimeUnit.MILLISECONDS)
        }.build()
    }






}

@Module
@InstallIn(ActivityComponent::class)
object Acitivities{

}