package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.db.ArticleDataBase
import com.example.newsapp.models.Article

class NewsRepository(val db: ArticleDataBase) {

    suspend fun getHeadlines(country: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadLines(country, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upset(article)

    fun getFavouritesNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}