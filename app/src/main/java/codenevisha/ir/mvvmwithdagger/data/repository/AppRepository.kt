package codenevisha.ir.mvvmwithdagger.data.repository

import codenevisha.ir.mvvmwithdagger.data.model.Article
import codenevisha.ir.mvvmwithdagger.data.network.ApiError
import io.reactivex.disposables.Disposable

interface AppRepository {

    fun getArticles(
        success: (Article) -> Unit,
        failure: (ApiError) -> Unit = {},
        terminate: () -> Unit = {}
    ): Disposable

    fun insertArticle(article: Article): Disposable
}