package com.dagger.multibindings.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.FilterData
import com.dagger.multibindings.R
import javax.inject.Inject

class RedFilterDelegate @Inject constructor() : FilterAdapterDelegate {

    override val viewType: Int = RED_FILTER_VIEW_TYPE

    override fun isForViewType(filterData: FilterData): Boolean {
        return filterData.id.toIntOrNull() == RED_FILTER_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.red_filter_item, parent, false)
        return RedFilterViewHolder(itemView)
    }

    override fun onBindViewHolder(filterData: FilterData, holder: RecyclerView.ViewHolder) {
        (holder as RedFilterViewHolder).name.text = filterData.displayName
    }

    companion object {
        const val RED_FILTER_VIEW_TYPE = 1
    }
}

class RedFilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var name: TextView

    init {
        name = itemView.findViewById(R.id.name)
    }
}