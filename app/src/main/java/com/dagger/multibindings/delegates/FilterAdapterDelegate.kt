package com.dagger.multibindings.delegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.FilterData

interface FilterAdapterDelegate {

    val viewType: Int

    fun isForViewType(filterData: FilterData): Boolean

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(filterData: FilterData, holder: RecyclerView.ViewHolder)
}