package codenevisha.ir.mvvmwithdagger.core

import android.support.v4.app.FragmentManager
import codenevisha.ir.mvvmwithdagger.ui.HomeFragment


object FragmentFactory{

    fun getHomeFragment(supportFragmentManager: FragmentManager): HomeFragment {
        var fragment = supportFragmentManager.findFragmentByTag(HomeFragment.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = HomeFragment()
        }
        return fragment as HomeFragment
    }

}