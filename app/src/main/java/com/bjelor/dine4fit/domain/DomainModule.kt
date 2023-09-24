package com.bjelor.dine4fit.domain

import com.bjelor.dine4fit.data.service.Dine4FitService
import com.bjelor.dine4fit.domain.usecase.GetDetailUseCase
import com.bjelor.dine4fit.domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object DomainModule {

    @Provides
    fun provideSearchUseCase(service: Dine4FitService): SearchUseCase = SearchUseCase(service)

    @Provides
    fun provideGetDetailUseCase(service: Dine4FitService): GetDetailUseCase =
        GetDetailUseCase(service)
}