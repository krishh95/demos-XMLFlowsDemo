package bade.krushna.storeApp.di

import bade.krushna.storeApp.data.remote.IApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
            .baseUrl("https://fakestoreapi.com/")
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
@InstallIn(FragmentComponent::class)
object Fragments