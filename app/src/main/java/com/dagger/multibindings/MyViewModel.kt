package com.dagger.multibindings

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MyViewModel @Inject constructor(private val myRepository: MyRepository): ViewModel() {

}
