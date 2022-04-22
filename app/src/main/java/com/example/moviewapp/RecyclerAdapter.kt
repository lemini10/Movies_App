package com.example.moviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titlesArray = arrayOf("Ratatouille", "Coco","Aladdin", "Wall-E", "Up" )
    private var genresArray = arrayOf("Food", "Foreign","Foreign", "Technology", "Adventure" )
    private var imagesArray = arrayOf(R.drawable.rat, R.drawable.coco,R.drawable.aladdin, R.drawable.walle, R.drawable.up )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titlesArray[position]
        holder.itemGenre.text = genresArray[position]
        holder.itemImage.setImageResource(imagesArray[position])


    }

    override fun getItemCount(): Int {
        return titlesArray.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemGenre: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.text_title)
            itemGenre = itemView.findViewById(R.id.text_genre)
        }

    }


}