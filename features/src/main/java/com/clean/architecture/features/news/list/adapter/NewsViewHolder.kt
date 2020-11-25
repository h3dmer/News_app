package com.clean.architecture.features.news.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.clean.architecture.core.extensions.loadUrl
import com.clean.architecture.core.utils.view.BaseViewHolder
import com.clean.architecture.domain.entity.model.news.Article
import com.clean.architecture.features.databinding.ItemArticleBinding

class NewsViewHolder(
    parent: ViewGroup,
    creator: (inflater: LayoutInflater, root: ViewGroup, attachToRoot: Boolean) -> ItemArticleBinding
) : BaseViewHolder<ItemArticleBinding, Article>(parent, creator) {

    override fun bind(item: Article) {
        with(binding) {
            articleDate.text = item.publishedAt
            articleTitle.text = item.title
            articleDescription.text = item.description
            articleImage.loadUrl(item.urlToImage)
        }
    }
}
