package com.example.mainproject.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.mainproject.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private lateinit var binding: FragmentArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleBinding.inflate(layoutInflater)

        val url = requireArguments().getString("url")

        binding.webView.apply {
            webViewClient = WebViewClient()

            if (url != null) {
                loadUrl(url)
            }
        }

        return binding.root
    }
}