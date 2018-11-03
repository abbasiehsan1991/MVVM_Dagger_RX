package codenevisha.ir.mvvmwithdagger.di.module

import android.app.Application
import android.arch.persistence.room.Room
import codenevisha.ir.mvvmwithdagger.data.db.AppDatabase
import codenevisha.ir.mvvmwithdagger.data.db.ArticleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun provideArticleDao(appDatabase: AppDatabase):ArticleDao {
        return appDatabase.articleDao()
    }
}
