package codenevisha.ir.mvvmwithdagger.data

import android.arch.persistence.room.*

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(articel:Article):Long

    @Delete
    fun deleteArticle(articel: Article):Int

    @Query("SELECT * FROM Article")
    fun getAllArticles():MutableList<Article>
}