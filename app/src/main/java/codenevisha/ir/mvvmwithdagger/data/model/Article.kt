package codenevisha.ir.mvvmwithdagger.data.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class ArticleModel(
    @SerializedName("status") var status: String?,
    @SerializedName("totalResults") var totalResults: Int?,
    @SerializedName("articles") var articles: MutableList<Article>?
)

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @SerializedName("author") var author: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("url") var url: String?,
    @SerializedName("urlToImage") var urlToImage: String?,
    @SerializedName("publishedAt") var publishedAt: String?,
    @SerializedName("content") var content: String?,
    @Embedded
    @SerializedName("source") var source: Source
) {
    var atricleAuthor = "Author: $author"
}

class Source constructor(
    @SerializedName("id") var sourceId: String?,
    @SerializedName("name") var sourceNname: String?
)
