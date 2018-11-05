package codenevisha.ir.mvvmwithdagger.ui.base

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import codenevisha.ir.mvvmwithdagger.ui.AdapterHome


/**
 * Contains [BindingAdapter]s for the T list.
 */
class BaseBindings {

    companion object {
        private val TAG = "TasksListBindings"

        @JvmStatic
        @BindingAdapter("app:adapter")
        fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {

            Log.d(TAG, "articles:[$items]")

            if (recyclerView.adapter is AdapterHome) {

                if (items != null) {
                    (recyclerView.adapter as AdapterHome).swapData(items)
                }

            }
        }
    }
}
