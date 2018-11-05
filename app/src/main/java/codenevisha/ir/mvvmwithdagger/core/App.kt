package codenevisha.ir.mvvmwithdagger.core

import codenevisha.ir.mvvmwithdagger.di.component.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }

}