package codenevisha.ir.mvvmwithdagger.data

import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName

data class ArticleModel constructor(
    @SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: MutableList<Article>? = null
)

@Entity
data class Article constructor(
    @SerializedName("source") var source: Source? = null,
    @SerializedName("author") var author: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null,
    @SerializedName("publishedAt") var publishedAt: String? = null,
    @SerializedName("content") var content: String? = null
) {
    val atricleAuthor = "Author: $author"
}

data class Source constructor(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null

)
