package com.clean.architecture.features.news.list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.clean.architecture.core.viewBinding.viewBinding
import com.clean.architecture.features.R
import com.clean.architecture.features.databinding.FragmentNewsListBinding
import com.clean.architecture.features.news.list.adapter.NewsListAdapter
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class NewsListFragment : Fragment(R.layout.fragment_news_list) {

    private val binding: FragmentNewsListBinding by viewBinding(FragmentNewsListBinding::bind)

    private val newsListViewModel: NewsListViewModel by viewModel()

    private val newsAdapter by lazy { NewsListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newsListRecyclerView.adapter = newsAdapter
        observeData()
    }

    private fun observeData() {
        newsListViewModel.newsListState.observe(viewLifecycleOwner, ::renderState)
    }

    private fun renderState(state: NewsListState) {
        with(state) {
            binding.newsListProgressBar.isVisible = isLoading

            newsList?.let(newsAdapter::submitList)

            apiError?.let { throwable ->
                Timber.e(throwable)
                throwable.message?.let { error -> toast(error) }
            }
        }
    }
}
