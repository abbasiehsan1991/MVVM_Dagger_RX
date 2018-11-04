package codenevisha.ir.mvvmwithdagger.core

import codenevisha.ir.mvvmwithdagger.di.component.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MineApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerMainComponent
            .builder()
            .application(this)
            .build()
    }
}