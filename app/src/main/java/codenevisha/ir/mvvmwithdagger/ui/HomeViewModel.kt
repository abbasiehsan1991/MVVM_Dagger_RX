package codenevisha.ir.mvvmwithdagger.ui

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import codenevisha.ir.mvvmwithdagger.data.model.Article
import codenevisha.ir.mvvmwithdagger.data.repository.AppRepository
import codenevisha.ir.mvvmwithdagger.ui.base.BaseViewmodel
import javax.inject.Inject

class HomeViewModel @Inject constructor(private var appRepository: AppRepository) : BaseViewmodel() {

    private val TAG = HomeViewModel::class.java.simpleName

    // These observable fields will update Views automatically
    val articlesItem = MutableLiveData<List<Article>>()

    val dataLoading = MutableLiveData<Boolean>()

    val emptyData = MutableLiveData<Boolean>()

    internal val snackbarText = MutableLiveData<String>()

    private val mIsDataLoadingError = MutableLiveData<Boolean>()

    private val mSnackbarText = SnackbarMessage()

    internal fun getSnackbarMessage(): SnackbarMessage {
        return mSnackbarText
    }

    init {

        dataLoading.value = true

        appRepository.getArticles({ articles ->

            dataLoading.value = false

            articlesItem.value = articles.articles

            Log.d(TAG, "Success Response of getting articles $articles")

        }, {

            Log.e(TAG, "getArticles.error() called with $it")

            dataLoading.value = false
            mSnackbarText.value = it.getApiErrorMessage(it.status)
        }
        )
    }

}