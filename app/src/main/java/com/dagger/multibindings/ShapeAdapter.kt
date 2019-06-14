package com.dagger.multibindings

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.delegates.ShapeDelegate
import javax.inject.Inject

class ShapeAdapter @Inject constructor(
    private val shapeDelegates: Map<Int, @JvmSuppressWildcards ShapeDelegate>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var shapeDataList: List<ShapeData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        val shapeData = shapeDataList.get(position)
        return shapeDelegates.values
            .firstOrNull { it.isForViewType(shapeData) }
            ?.viewType
            ?: throw IllegalArgumentException("No adapter delegate found")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return shapeDelegates.getValue(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val shapeData = shapeDataList.get(position)
        shapeDelegates.getValue(holder.itemViewType).onBindViewHolder(shapeData, holder)
    }

    override fun getItemCount(): Int {
        return shapeDataList.size
    }

}
