package com.sulistyo.test

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sulistyo.test.R.id.team_badge
import com.sulistyo.test.R.id.team_name
import org.jetbrains.anko.*


class RecyclerViewAdapter(
    private val context: Context,
    private val dataItems: List<DataItem>,
    private val listener: (DataItem) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(dataItems[position], listener)
    }

    override fun getItemCount(): Int = dataItems.size


    class TeamUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = team_badge
                    }.lparams {
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = team_name
                        textSize = 16f
                    }.lparams {
                        margin = dip(15)
                    }

                }
            }
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val teamBadge: ImageView = view.find(team_badge)
        private val teamName: TextView = view.find(team_name)

        fun bindItem(items: DataItem, listener: (DataItem) -> Unit) {


            teamBadge.let { Glide.with(itemView.context).load(it).into(teamBadge) }
            teamName.text = items.name
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}