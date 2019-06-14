package com.dagger.multibindings

import android.app.Application
import android.content.Context
import com.dagger.multibindings.delegates.CircleDelegate
import com.dagger.multibindings.delegates.RectangleDelegate
import com.dagger.multibindings.delegates.ShapeDelegate
import com.dagger.multibindings.delegates.TriangleDelegate
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
    @ShapeKey(CircleDelegate.CIRCLE_VIEW_TYPE)
    fun provideCircleDelegate(circleDelegate: CircleDelegate): ShapeDelegate

    @Binds
    @IntoMap
    @ShapeKey(TriangleDelegate.TRIANGLE_VIEW_TYPE)
    fun provideTriangleDelegate(triangleDelegate: TriangleDelegate): ShapeDelegate

    @Binds
    @IntoMap
    @ShapeKey(RectangleDelegate.RECTANGLE_VIEW_TYPE)
    fun providerectangleDelegate(rectangleDelegate: RectangleDelegate): ShapeDelegate
}
