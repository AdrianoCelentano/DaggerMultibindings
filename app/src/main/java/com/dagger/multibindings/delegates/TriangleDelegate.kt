package com.dagger.multibindings.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dagger.multibindings.R
import com.dagger.multibindings.ShapeData
import javax.inject.Inject

class TriangleDelegate @Inject constructor() : ShapeDelegate {

    override val viewType: Int = TRIANGLE_VIEW_TYPE

    override fun isForViewType(shapeData: ShapeData): Boolean {
        return shapeData.id == TRIANGLE_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.triangle_item, parent, false)
        return TriangleViewHolder(itemView)
    }

    override fun onBindViewHolder(shapeData: ShapeData, holder: RecyclerView.ViewHolder) {
        (holder as TriangleViewHolder).name.text = shapeData.displayName
    }

    companion object {
        const val TRIANGLE_VIEW_TYPE = 2
    }
}

class TriangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var name: TextView

    init {
        name = itemView.findViewById(R.id.name)
    }
}