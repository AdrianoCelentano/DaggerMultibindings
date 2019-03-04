package com.dagger.multibindings

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    @JvmStatic
    fun providesContext(application: Application): Context = application.applicationContext
}
