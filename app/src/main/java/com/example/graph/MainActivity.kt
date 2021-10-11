package com.example.graph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graph.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLineChartData()
    }

    private fun setLineChartData(){
        val xAxis: XAxis = binding.lineChart.xAxis
        xAxis.setDrawLabels(false)
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)

        var yAxis: YAxis = binding.lineChart.axisLeft
        yAxis.setDrawGridLines(false)
        yAxis.setDrawLabels(false)
        yAxis.setDrawAxisLine(false)

        yAxis = binding.lineChart.axisRight
        yAxis.setDrawGridLines(false)
        yAxis.setDrawLabels(false)
        yAxis.setDrawAxisLine(false)

        val xValue = ArrayList<String>()
        xValue.add("02-05-2020")
        xValue.add("27-02-2021")
        xValue.add("04-10-2021")

        val lineEntry = ArrayList<Entry>()
        lineEntry.add(Entry(50f, 0))
        lineEntry.add(Entry(45f, 1))
        lineEntry.add(Entry(50f, 2))

        val lineDataset = LineDataSet(lineEntry, null)
        lineDataset.color = resources.getColor(R.color.purple_200)

        val finalDataset = ArrayList<LineDataSet>()
        finalDataset.add(lineDataset)

        val data = LineData(xValue, finalDataset as List<ILineDataSet>?)

        binding.lineChart.data = data
        binding.lineChart.setBackgroundColor(resources.getColor(R.color.white))
        binding.lineChart.animateXY(3000, 3000)
        binding.lineChart.invalidate()
    }
}