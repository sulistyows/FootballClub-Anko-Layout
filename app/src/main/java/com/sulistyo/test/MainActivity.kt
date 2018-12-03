package com.sulistyo.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.sulistyo.test.R.array.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var listTeam: RecyclerView
    private var items: MutableList<DataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout {
            lparams(width = matchParent, height = matchParent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            listTeam = recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(context)
            }

        }

        adapter = RecyclerViewAdapter(this, items) {
            itemKlik(it)
        }
        listTeam.adapter = adapter

        initData()
    }

    private fun itemKlik(item: DataItem) {
        startActivity<DetailClubActivity>(
            "team" to item)
    }

    private fun initData() {
        val name = resources.getStringArray(clubName)
        val image = resources.obtainTypedArray(clubImage)
        val deskrip = resources.getStringArray(clubDescription)
        items.clear()
        for (i in name.indices) {
            items.add(
                DataItem(
                    name[i],
                    image.getResourceId(i, 0),
                    deskrip[i]
                )
            )
        }
        image.recycle()
    }
}
