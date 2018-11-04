package codenevisha.ir.mvvmwithdagger.di.builder

import android.arch.lifecycle.ViewModel
import codenevisha.ir.mvvmwithdagger.di.qualifier.ViewModelKey
import codenevisha.ir.mvvmwithdagger.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}
