package codenevisha.ir.mvvmwithdagger.data.network

import codenevisha.ir.mvvmwithdagger.data.model.ArticleModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?country=us&category=business")
    fun getArticles(
        @Query("apiKey") userApiKey: String)
            : Observable<ArticleModel>
}