package bade.krushna.xmlflowsdemo.di

import bade.krushna.xmlflowsdemo.data.api.IApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Dependancies {

    @Provides
    fun retrofit() : IApiServices{
        return Retrofit
            .Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IApiServices::class.java)
    }


}