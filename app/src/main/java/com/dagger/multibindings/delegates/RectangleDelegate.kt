package com.dagger.multibindings.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.R
import com.dagger.multibindings.ShapeData
import javax.inject.Inject

class RectangleDelegate @Inject constructor() : ShapeDelegate {

    override val viewType: Int = RECTANGLE_VIEW_TYPE

    override fun isForViewType(shapeData: ShapeData): Boolean {
        return shapeData.id == RECTANGLE_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.rectangle_item, parent, false)
        return RectangleViewHolder(itemView)
    }

    override fun onBindViewHolder(shapeData: ShapeData, holder: RecyclerView.ViewHolder) {
        (holder as RectangleViewHolder).name.text = shapeData.displayName
    }

    companion object {
        const val RECTANGLE_VIEW_TYPE = 3
    }
}

class RectangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var name: TextView

    init {
        name = itemView.findViewById(R.id.name)
    }
}