package com.example.music_player

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val dataList: List<Data>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.music_img)
        val title: TextView = itemView.findViewById(R.id.music_name)
        val singer:TextView=itemView.findViewById(R.id.artist)
        val playBtn: ImageButton = itemView.findViewById(R.id.playBtn)
        val pauseBtn: ImageButton = itemView.findViewById(R.id.pauseBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData=dataList[position]
        val mediaPlayer=MediaPlayer.create(context,currentData.preview.toUri())
        holder.title.text=currentData.title
        holder.singer.text=currentData.artist.name.toString()
        Picasso.get().load(currentData.album.cover).into(holder.image)


        holder.playBtn.setOnClickListener {
         // Implement play functionality
            mediaPlayer.start()
        }

        holder.pauseBtn.setOnClickListener {
            // Implement pause functionality
            mediaPlayer.stop()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

