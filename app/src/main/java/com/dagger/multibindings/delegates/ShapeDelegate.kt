package com.dagger.multibindings.delegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.ShapeData

interface ShapeDelegate {

    val viewType: Int

    fun isForViewType(shapeData: ShapeData): Boolean

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(shapeData: ShapeData, holder: RecyclerView.ViewHolder)
}