package mvvm.practice.app.adapters

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import mvvm.practice.app.R
import mvvm.practice.app.models.WordedImageModel
import java.lang.Exception

class WordedImageRecyclerAdapter(val context: Context, val dataset:MutableList<WordedImageModel>):RecyclerView.Adapter<WordedImageRecyclerAdapter.CustomViewHolder>() {

    class CustomViewHolder(v: View):RecyclerView.ViewHolder(v){
        val descriptionDisplay = v.findViewById<TextView>(R.id.descriptionDisplay)
        val imageDisplay = v.findViewById<ImageView>(R.id.imageDisplay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       return CustomViewHolder(LayoutInflater.from(parent.context)
           .inflate(R.layout.worded_image_indvidual_box,parent,false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val wordedImage = dataset[position]
        holder.descriptionDisplay.text = wordedImage.description



        val picassoCallback = object : Callback{
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
               holder.imageDisplay.setImageDrawable(AppCompatResources.getDrawable(context,R.drawable.ic_launcher_background))
            }

        }


        Picasso.get().load(Uri.parse(wordedImage.imageUrl)).into(holder.imageDisplay,picassoCallback)

    }

    override fun getItemCount(): Int = dataset.size
}