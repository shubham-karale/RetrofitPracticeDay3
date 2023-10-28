package com.example.retrofitpracticeday3

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(val context:Activity,val commentsList:List<DataClassItem>):RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val commentName= itemView.findViewById<TextView>(R.id.commentName)
        val commentEmail = itemView.findViewById<TextView>(R.id.commentEmail)
        val commentBody = itemView.findViewById<TextView>(R.id.commentBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return CommentsViewHolder(view)
    }

    override fun getItemCount(): Int {
       return commentsList.size
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {

        val currentComment = commentsList[position]

        holder.commentName.text = currentComment.name
        holder.commentEmail.text = currentComment.email
        holder.commentBody.text  = currentComment.body


    }

}