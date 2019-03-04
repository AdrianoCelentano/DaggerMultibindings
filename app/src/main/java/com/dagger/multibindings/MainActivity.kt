package com.dagger.multibindings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var filterAdapter: FilterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        val filterDataList = loadData()
        filterAdapter.filterDataList = filterDataList
        recyclerview.adapter = filterAdapter
    }

    fun loadData(): List<FilterData> {
        val redFilter = FilterData(id = 1, displayName = "red")
        val yellowFilter = FilterData(id = 2, displayName = "yellow")
        val blueFilter = FilterData(id = 3, displayName = "blue")
        val filterList = listOf(redFilter, yellowFilter, blueFilter)
        return filterList
    }
}
