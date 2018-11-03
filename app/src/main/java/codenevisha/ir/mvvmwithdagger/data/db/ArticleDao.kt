package codenevisha.ir.mvvmwithdagger.data.db

import android.arch.persistence.room.*
import codenevisha.ir.mvvmwithdagger.data.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(articel: Article):Long

    @Delete
    fun deleteArticle(articel: Article):Int

    @Query("SELECT * FROM Article")
    fun getAllArticles():MutableList<Article>
}