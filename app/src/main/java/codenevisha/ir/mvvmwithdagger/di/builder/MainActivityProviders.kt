package codenevisha.ir.mvvmwithdagger.di.builder

import codenevisha.ir.mvvmwithdagger.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders{
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

}