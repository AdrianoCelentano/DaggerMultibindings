package com.dagger.multibindings.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.R
import com.dagger.multibindings.ShapeData
import javax.inject.Inject

class CircleDelegate @Inject constructor() : ShapeDelegate {

    override val viewType: Int = CIRCLE_VIEW_TYPE

    override fun isForViewType(shapeData: ShapeData): Boolean {
        return shapeData.id == CIRCLE_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.triangle_item, parent, false)
        return CircleViewHolder(itemView)
    }

    override fun onBindViewHolder(shapeData: ShapeData, holder: RecyclerView.ViewHolder) {
        (holder as CircleViewHolder).name.text = shapeData.displayName
    }

    companion object {
        const val CIRCLE_VIEW_TYPE = 1
    }
}

class CircleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var name: TextView

    init {
        name = itemView.findViewById(R.id.name)
    }
}