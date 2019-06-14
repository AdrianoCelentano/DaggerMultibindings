package com.dagger.multibindings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OldShapeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CIRCLE_VIEW_TYPE = 1
        const val TRIANGLE_VIEW_TYPE = 2
        const val RECTANGLE_VIEW_TYPE = 3
    }

    var shapeDataList: List<ShapeData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        val shapeData = shapeDataList.get(position)
        when {
            shapeData.id == CIRCLE_VIEW_TYPE -> {
                return CIRCLE_VIEW_TYPE
            }
            shapeData.id == TRIANGLE_VIEW_TYPE -> {
                return TRIANGLE_VIEW_TYPE
            }
            shapeData.id == RECTANGLE_VIEW_TYPE -> {
                return RECTANGLE_VIEW_TYPE
            }
            else -> {
                return RECTANGLE_VIEW_TYPE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            RECTANGLE_VIEW_TYPE -> {
                val itemView = inflater.inflate(R.layout.rectangle_item, parent, false)
                return RectangleViewHolder(itemView)
            }
            CIRCLE_VIEW_TYPE -> {
                val itemView = inflater.inflate(R.layout.circle_item, parent, false)
                return RectangleViewHolder(itemView)
            }
            TRIANGLE_VIEW_TYPE -> {
                val itemView = inflater.inflate(R.layout.triangle_item, parent, false)
                return RectangleViewHolder(itemView)
            }
            else -> {
                val itemView = inflater.inflate(R.layout.rectangle_item, parent, false)
                return RectangleViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val shapeData = shapeDataList.get(position)

        when (holder.itemViewType) {
            RECTANGLE_VIEW_TYPE -> {
                (holder as RectangleViewHolder).name.text = shapeData.displayName
            }
            CIRCLE_VIEW_TYPE -> {
                (holder as CircleViewHolder).name.text = shapeData.displayName
            }
            TRIANGLE_VIEW_TYPE -> {
                (holder as TriangleViewHolder).name.text = shapeData.displayName
            }
            else -> {
                (holder as RectangleViewHolder).name.text = shapeData.displayName
            }
        }
    }

    override fun getItemCount(): Int {
        return shapeDataList.size
    }

    class RectangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView

        init {
            name = itemView.findViewById(R.id.name)
        }
    }

    class TriangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView

        init {
            name = itemView.findViewById(R.id.name)
        }
    }

    class CircleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView

        init {
            name = itemView.findViewById(R.id.name)
        }
    }

}
