package com.bjelor.dine4fit.data

import com.bjelor.dine4fit.data.service.Dine4FitService
import com.bjelor.dine4fit.data.service.PidInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun providePidInterceptor(): PidInterceptor = PidInterceptor()

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        pidInterceptor: PidInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(pidInterceptor)
        .build()

    @Provides
    fun provideDine4FitService(client: OkHttpClient): Dine4FitService = Retrofit.Builder()
        .baseUrl("https://api.kaloricketabulky.cz")
        .client(client)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
        .create(Dine4FitService::class.java)
}