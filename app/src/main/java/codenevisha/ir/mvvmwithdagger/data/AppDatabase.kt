package codenevisha.ir.mvvmwithdagger.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Article::class] , version = AppDatabase.VERSION)
abstract class AppDatabase :RoomDatabase(){
    companion object {
        const val DB_NAME = "MVVMWithDagger"
        const val VERSION = 1
    }

    abstract fun articleDao(): ArticleDao
}