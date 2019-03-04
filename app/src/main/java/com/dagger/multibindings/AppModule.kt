package com.dagger.multibindings

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [AppModuleBinds::class])
object AppModule {

    @Provides
    @JvmStatic
    fun providesContext(application: Application): Context = application.applicationContext
}

@Module
abstract class AppModuleBinds {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun bindMyViewModel(myViewModel: MyViewModel): ViewModel
}
