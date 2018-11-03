package codenevisha.ir.mvvmwithdagger.di

import android.app.Application
import codenevisha.ir.mvvmwithdagger.core.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component
interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicatio(application: Application): Builder

        fun builder(): Builder
    }
}