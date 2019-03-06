package com.dagger.multibindings

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.delegates.FilterAdapterDelegate
import javax.inject.Inject

class FilterAdapter @Inject constructor(
    private val adapterDelegates: Map<Int, @JvmSuppressWildcards FilterAdapterDelegate>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var filterDataList: List<FilterData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        val filterData = filterDataList.get(position)
        return adapterDelegates.values
            .firstOrNull { it.isForViewType(filterData) }
            ?.viewType
            ?: throw IllegalArgumentException("No adapter delegate found")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return adapterDelegates.getValue(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return filterDataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filterData = filterDataList.get(position)
        adapterDelegates.getValue(holder.itemViewType).onBindViewHolder(filterData, holder)
    }

}
