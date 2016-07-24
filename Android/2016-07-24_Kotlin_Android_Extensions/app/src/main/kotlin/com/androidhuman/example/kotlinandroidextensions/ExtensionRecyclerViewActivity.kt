package com.androidhuman.example.kotlinandroidextensions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_extension_recycler_view.*
import kotlinx.android.synthetic.main.item_photo.view.*
import kotlinx.android.synthetic.main.item_text.view.*

class ExtensionRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_recycler_view)

        with(rv_activity_extension_recycler_view) {
            layoutManager = LinearLayoutManager(this@ExtensionRecyclerViewActivity)
            adapter = FeedAdapter()
        }
    }

    inner class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        val VIEW_TYPE_PHOTO = 10

        val VIEW_TYPE_TEXT = 20

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            when (viewType) {
                VIEW_TYPE_PHOTO -> return PhotoHolder(parent)
                VIEW_TYPE_TEXT -> return TextHolder(parent)
            }
            throw IllegalArgumentException("Unknown view type: $viewType")
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            when (holder) {
                is PhotoHolder -> holder.bindView("Author $position", "Description $position")

                is TextHolder -> holder.bindView("Author $position", "Description $position")
            }
        }

        override fun getItemViewType(position: Int): Int {
            return if (position % 2 == 0) VIEW_TYPE_PHOTO else VIEW_TYPE_TEXT
        }

        override fun getItemCount(): Int {
            return 20
        }
    }

    inner class PhotoHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_photo, parent, false)) {

        fun bindView(author: String, description: String) {
            with(itemView) {
                iv_item_photo.setImageResource(R.drawable.img_kotlin)
                tv_item_photo_author.text = author
                tv_item_photo_description.text = description
            }
        }
    }

    inner class TextHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_text, parent, false)) {

        fun bindView(author: String, description: String) {
            with(itemView) {
                tv_item_text_author.text = author
                tv_item_text_description.text = description
            }
        }
    }

}