package com.clean.architecture.features.news.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.clean.architecture.core.utils.view.BaseDiffCallback
import com.clean.architecture.domain.entity.model.news.Article
import com.clean.architecture.features.databinding.ItemArticleBinding

class NewsListAdapter : ListAdapter<Article, NewsViewHolder>(BaseDiffCallback<Article>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(parent, ItemArticleBinding::inflate)

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(getItem(position))
}
