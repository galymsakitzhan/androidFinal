package com.finalProject.shopApp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.finalProject.shopApp.R
import com.finalProject.shopApp.databinding.FragmentArticleBinding
import com.finalProject.shopApp.ui.NewsActivity
import com.finalProject.shopApp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar


class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var  newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article


        binding.webView.apply {
            webViewClient = WebViewClient()
             article.url?.let {
                /*loadUrl(it)*/
             }
        }
        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to favourite", Snackbar.LENGTH_SHORT).show()
        }
    }
}














