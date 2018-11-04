package codenevisha.ir.mvvmwithdagger.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import codenevisha.ir.mvvmwithdagger.data.model.Article
import codenevisha.ir.mvvmwithdagger.data.model.Source

@Database(entities = [Article::class , Source::class] , version = AppDatabase.VERSION , exportSchema = false)
abstract class AppDatabase :RoomDatabase(){
    companion object {
        const val DB_NAME = "MVVMWithDagger"
        const val VERSION = 1
    }

    abstract fun articleDao(): ArticleDao
    abstract fun SourceDao(): SourceDao
}