package com.dagger.multibindings

import android.app.Application
import android.content.Context
import com.dagger.multibindings.delegates.BlueFilterDelegate
import com.dagger.multibindings.delegates.FilterAdapterDelegate
import com.dagger.multibindings.delegates.GreenFilterDelegate
import com.dagger.multibindings.delegates.RedFilterDelegate
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [AppBindsModule::class])
object AppModule {

    @Provides
    @JvmStatic
    fun providesContext(application: Application): Context = application.applicationContext
}

@Module
interface AppBindsModule {

    @Binds
    @IntoMap
    @FilterMapKey(RedFilterDelegate.RED_FILTER_VIEW_TYPE)
    fun provideRedFilterDelegate(redFilterDelegate: RedFilterDelegate): FilterAdapterDelegate

    @Binds
    @IntoMap
    @FilterMapKey(GreenFilterDelegate.GREEN_FILTER_VIEW_TYPE)
    fun provideGreenFilterDelegate(greenFilterDelegate: GreenFilterDelegate): FilterAdapterDelegate

    @Binds
    @IntoMap
    @FilterMapKey(BlueFilterDelegate.BLUE_FILTER_VIEW_TYPE)
    fun provideBlueFilterDelegate(blueFilterDelegate: BlueFilterDelegate): FilterAdapterDelegate
}
