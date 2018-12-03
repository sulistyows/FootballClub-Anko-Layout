package com.sulistyo.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClubActivity : AppCompatActivity() {

    lateinit var clubName: TextView
    lateinit var logoClub: ImageView
    lateinit var clubdescription: TextView
    private lateinit var event: DataItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val team = intent.getParcelableExtra<DataItem>("team")
        verticalLayout {
            padding = dip(16)

            logoClub = imageView().lparams(width = dip(100), height = wrapContent) {
                gravity = Gravity.CENTER
            }

            clubName = textView().lparams(width = wrapContent) {
                gravity = Gravity.CENTER
                topMargin = dip(16)
            }

            clubdescription = textView().lparams(width = wrapContent) {
                topMargin = dip(20)

            }
        }


        Glide.with(applicationContext).load(team.image).into(logoClub)
        clubName.text = team.name
        clubdescription.text = team.description


    }
}
