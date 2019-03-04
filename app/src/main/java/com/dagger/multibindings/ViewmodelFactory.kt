package com.dagger.multibindings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModelProviderMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val viewModelProvider = viewModelProviderMap.get(modelClass)
                ?: throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        return viewModelProvider.get() as T
    }
}