package codenevisha.ir.mvvmwithdagger.data.db

import android.arch.persistence.room.*
import codenevisha.ir.mvvmwithdagger.data.model.Source

@Dao
interface SourceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSource(source: Source):Long

    @Delete
    fun deleteSource(source: Source):Int

    @Query("SELECT * FROM Article")
    fun getAllSources():MutableList<Source>
}