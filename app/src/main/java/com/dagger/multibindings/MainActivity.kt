package com.dagger.multibindings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var shapeAdapter: ShapeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        val shapeDataList = loadData()
        shapeAdapter.shapeDataList = shapeDataList
        recyclerview.adapter = shapeAdapter
    }

    fun loadData(): List<ShapeData> {
        val rectangleData = ShapeData(id = 1, displayName = "rectangle")
        val circleData = ShapeData(id = 2, displayName = "circle")
        val triangleData = ShapeData(id = 3, displayName = "triangle")
        val shapeList = listOf(rectangleData, circleData, triangleData)
        return shapeList
    }
}
