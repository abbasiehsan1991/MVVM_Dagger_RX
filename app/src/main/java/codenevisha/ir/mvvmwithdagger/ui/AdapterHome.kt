package codenevisha.ir.mvvmwithdagger.ui

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import codenevisha.ir.mvvmwithdagger.BR.item
import codenevisha.ir.mvvmwithdagger.data.model.Article
import codenevisha.ir.mvvmwithdagger.databinding.RvItemMainBinding
import codenevisha.ir.mvvmwithdagger.ui.base.BaseDataBindingViewHolder

class AdapterHome(
    private var items: MutableList<Article> = arrayListOf<Article>()
) : RecyclerView.Adapter<AdapterHome.SimpleVideoHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SimpleVideoHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleVideoHolder {

        val binding = RvItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimpleVideoHolder(binding)
    }

    inner class SimpleVideoHolder(dataBinding: ViewDataBinding) : BaseDataBindingViewHolder<Article>(dataBinding) {

        override fun onBind(t: Article): Unit = with(t) {

            dataBinding.setVariable(item, t)
        }
    }

    fun swapData(articles: List<*>){
        items.addAll(articles as List<Article>)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }
}