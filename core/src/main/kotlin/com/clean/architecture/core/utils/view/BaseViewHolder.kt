package com.clean.architecture.core.utils.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T : ViewBinding, I> private constructor(
    val binding: T
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        creator: (inflater: LayoutInflater, root: ViewGroup, attachToRoot: Boolean) -> T
    ) : this(creator(LayoutInflater.from(parent.context), parent, false))

    abstract fun bind(item: I)
}
