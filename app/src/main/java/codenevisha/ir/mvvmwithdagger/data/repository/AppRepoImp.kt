package codenevisha.ir.mvvmwithdagger.data.repository

import android.util.Log
import codenevisha.ir.mvvmwithdagger.core.Config
import codenevisha.ir.mvvmwithdagger.data.db.AppDatabase
import codenevisha.ir.mvvmwithdagger.data.model.Article
import codenevisha.ir.mvvmwithdagger.data.model.ArticleModel
import codenevisha.ir.mvvmwithdagger.data.network.ApiDisposable
import codenevisha.ir.mvvmwithdagger.data.network.ApiError
import codenevisha.ir.mvvmwithdagger.data.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AppRepoImp(
    val apiService: ApiService,
    val database: AppDatabase
) : AppRepository {

    val TAG = AppRepoImp::class.java.simpleName

    override fun getArticles(
        success: (ArticleModel) -> Unit, failure: (ApiError) -> Unit, terminate: () -> Unit
    ): Disposable {

        return apiService.getArticles(Config.API_USER_TOKEN)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(terminate)
            .subscribeWith(
                ApiDisposable<ArticleModel>(
                    {
                        success(it)
                    },
                    {
                        failure(it)
                    }
                )
            )
    }

    override fun insertArticle(article: Article): Disposable {
        return Observable
            .fromCallable { database.articleDao().insertArticle(article) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "food added: subscribe: $it")
            }
    }
}