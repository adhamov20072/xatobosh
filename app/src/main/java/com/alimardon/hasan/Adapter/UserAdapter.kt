package com.alimardon.hasan.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alimardon.hasan.databinding.UserItemBinding
import com.alimardon.hasan.model.UserItemItem

class UserAdapter : ListAdapter<UserItemItem, UserAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)
    var listener: OnUserClickListener? = null
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<UserItemItem>() {
            override fun areItemsTheSame(oldItem: UserItemItem, newItem: UserItemItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: UserItemItem, newItem: UserItemItem): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val b=getItem(position)
        holder.binding.apply {
           txtCity.text=b.address.city
            txtEmail.text=b.email
            txtId.text=b.id.toString()
            txtUsername.text=b.username
            txtPhone.text=b.phone
            txtName.text=b.name
        }
        holder.itemView.setOnClickListener {
            listener?.onUserClick(b)
        }
    }
    interface OnUserClickListener {
        fun onUserClick(userItem: UserItemItem)
    }

    fun setOnUserItemClickListener(onUserClickListener: OnUserClickListener) {
        listener = onUserClickListener
    }
}












