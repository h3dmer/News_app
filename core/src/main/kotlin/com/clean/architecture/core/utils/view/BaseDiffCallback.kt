package com.clean.architecture.core.utils.view

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class BaseDiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(item1: T, item2: T): Boolean {
        return item1 == item2
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(item1: T, item2: T): Boolean {
        return item1 == item2
    }
}