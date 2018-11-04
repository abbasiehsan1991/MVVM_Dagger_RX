package codenevisha.ir.mvvmwithdagger.data.repository

import codenevisha.ir.mvvmwithdagger.data.db.AppDatabase
import codenevisha.ir.mvvmwithdagger.data.model.Article
import codenevisha.ir.mvvmwithdagger.data.network.ApiError
import codenevisha.ir.mvvmwithdagger.data.network.ApiService
import io.reactivex.disposables.Disposable

class AppRepoImp(
    val apiService: ApiService,
    val database: AppDatabase
):AppRepository {
    override fun getArticles(
        success: (Article) -> Unit,
        failure: (ApiError) -> Unit,
        terminate: () -> Unit
    ): Disposable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertArticle(article: Article): Disposable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}