package dev.grack.submitaplikasifootballclubkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import dev.grack.submitaplikasifootballclubkotlin.ui.MainUI
import dev.grack.submitaplikasifootballclubkotlin.model.ModelFootballs
import org.jetbrains.anko.AnkoContext

class AdapterFootball(var lists: MutableList<ModelFootballs>,
                      var listener: (ModelFootballs) -> Unit) : RecyclerView.Adapter<AdapterFootball.ViewHolderFootball>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFootball {
        return ViewHolderFootball(MainUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ViewHolderFootball, position: Int) {
        holder.bindItem(lists[position], listener)
    }

    class ViewHolderFootball(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageClub: ImageView
        var namaClub: TextView

        init {
            imageClub = itemView.findViewById(MainUI.gambarId)
            namaClub = itemView.findViewById(MainUI.namaId)
        }

        fun bindItem(modelFootballs: ModelFootballs,
                     listener: (ModelFootballs) -> Unit) {
            namaClub.text = modelFootballs.name
            Glide.with(itemView.context)
                    .load(modelFootballs.image)
                    .into(imageClub)

            itemView.setOnClickListener {
                listener(modelFootballs)
            }
        }
    }
}