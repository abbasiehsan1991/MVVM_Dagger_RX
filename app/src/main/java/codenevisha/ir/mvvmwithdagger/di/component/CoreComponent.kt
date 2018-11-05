package codenevisha.ir.mvvmwithdagger.di.component

import android.app.Application
import codenevisha.ir.mvvmwithdagger.core.App
import codenevisha.ir.mvvmwithdagger.di.builder.ActivityBuilder
import codenevisha.ir.mvvmwithdagger.di.module.ContextModule
import codenevisha.ir.mvvmwithdagger.di.module.DataBaseModule
import codenevisha.ir.mvvmwithdagger.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class,  ActivityBuilder::class,
    DataBaseModule::class, ContextModule::class])
interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }


}