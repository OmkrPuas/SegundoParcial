package com.example.baseproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback

class UserListAdapter(val list: ArrayList<Post>, val recycleViewActivity: Callback<List<Post>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return UserListViewHolder(view)
    }

    class UserListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)
        holder.itemView.findViewById<TextView>(R.id.tv_title).text = item.title
        holder.itemView.findViewById<TextView>(R.id.tv_body).text = item.body

    }


}
