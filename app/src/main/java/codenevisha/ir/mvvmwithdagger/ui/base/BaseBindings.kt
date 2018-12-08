package codenevisha.ir.mvvmwithdagger.ui.base

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import codenevisha.ir.mvvmwithdagger.R
import codenevisha.ir.mvvmwithdagger.ui.AdapterHome
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions


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

        @JvmStatic
        @BindingAdapter("app:loadImage")
        fun setImageResource(view: ImageView, imageUrl: String?) {

            val context = view.context

            val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)


            imageUrl?.let {

                Glide.with(context)
                    .setDefaultRequestOptions(options)
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade(1000))
                    .into(view)
            }
        }
    }
}
