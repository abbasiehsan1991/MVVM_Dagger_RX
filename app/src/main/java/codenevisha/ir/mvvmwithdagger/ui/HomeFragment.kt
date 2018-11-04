package codenevisha.ir.mvvmwithdagger.ui

import dagger.android.support.DaggerFragment

class HomeFragment : DaggerFragment(){
    private val TAG: String = HomeFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.name
    }

}