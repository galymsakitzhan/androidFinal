package com.finalProject.shopApp.repository

import com.finalProject.shopApp.api.RetrofitInstance
import com.finalProject.shopApp.db.ArticleDatabase
import com.finalProject.shopApp.models.Article
import retrofit2.http.Query

class NewsRepository (val db:ArticleDatabase){
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArtcileDao().upsert(article)

    fun getFavouriteNews() = db.getArtcileDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArtcileDao().deleteArticle(article)
}