package io.tristanlarsin.scanwellhealthchallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.tristanlarsin.scanwellhealthchallenge.repositories.DataRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDataRepository() = DataRepository
}