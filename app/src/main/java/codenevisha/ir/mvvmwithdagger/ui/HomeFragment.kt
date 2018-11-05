package codenevisha.ir.mvvmwithdagger.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codenevisha.ir.mvvmwithdagger.databinding.FragmentHomeBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    private val TAG: String = HomeFragment::class.java.simpleName

    private lateinit var binding : FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel : HomeViewModel by lazy {
         ViewModelProviders.of(this , viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)
        binding.viewmodel = viewModel


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSnakbar()
        setupRvMain()

    }

    private fun setupRvMain(){
        rv_home.layoutManager = LinearLayoutManager(activity ,LinearLayoutManager.VERTICAL , false)
        rv_home.adapter= AdapterHome()
    }

    private fun setupSnakbar() {
        viewModel.getSnackbarMessage().observe(this, object : SnackbarMessage.SnackbarObserver {
            override fun onNewMessage(@StringRes snackbarMessageResourceId: Int) {

                SnackbarUtils.showSnackbar(view, getString(snackbarMessageResourceId))

            }
        })
    }
    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.name
    }

}
