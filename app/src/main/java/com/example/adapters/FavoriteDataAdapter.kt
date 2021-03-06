package com.example.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.models.FavoriteWithPicture
import com.example.database.entities.EntityFavorite
import com.example.havesomerest.R
import com.example.util.ClassConverter
import com.example.viewModels.MyDatabaseViewModel

class FavoriteDataAdapter(
    private val items : List<FavoriteWithPicture>,
    private  val listener : OnItemClickListener,
    private val myDatabaseViewModel: MyDatabaseViewModel,
    private val lifecycle : LifecycleOwner
) : RecyclerView.Adapter<FavoriteDataAdapter.DataViewHolder>(){

    inner class DataViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView), View.OnClickListener{
        val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurant_image)
        val restaurantName = itemView.findViewById<TextView>(R.id.restaurant_name)
        val restaurantAddress = itemView.findViewById<TextView>(R.id.restaurant_address)
        val restaurantPrice = itemView.findViewById<TextView>(R.id.restaurant_price)
        val likeButton = itemView.findViewById<ImageButton>(R.id.favoriteButton)


        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position,restaurantName.text.toString())
            }
        }

    }
    interface OnItemClickListener{
        fun onItemClick(position: Int, toString: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.main_recycle_item_layout,parent,false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = items [position]
        holder.restaurantName.text = currentItem.name
        holder.restaurantAddress.text = currentItem.address
        holder.restaurantPrice.text = currentItem.price.toString()+"$"
        holder.likeButton.setColorFilter(Color.argb(255, 194, 39, 72))

        //load the current item's image
        if (currentItem.image != null){
            holder.restaurantImage.setImageBitmap(currentItem.image)
        }
        else holder.restaurantImage.setImageResource(R.drawable.alap)


        //delete current item from favorites
        holder.likeButton.setOnClickListener {
            myDatabaseViewModel.favorites.observe(lifecycle, Observer {
                notifyDataSetChanged()
            })
            myDatabaseViewModel.deleteFavorite(ClassConverter.favoriteWithPictureToFavorite(currentItem))
        }

    }

    override fun getItemCount(): Int = items.size

}