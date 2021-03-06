package com.ayo.hourly.ui.rockets

import com.ayo.hourly.R
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayo.domain.model.RocketDomain
import com.ayo.domain.model.UserDomain
import com.ayo.domain.usecase.UserUseCase
import com.ayo.hourly.common.Resource
import com.ayo.hourly.common.Status
import com.ayo.hourly.ui.base.BaseActivity
import com.ayo.hourly.ui.rockets.adapter.RocketListAdapter
import com.ayo.hourly.ui.base.BaseActivityDagger
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

//todo move away from baseActivityDagger
class RocketsActivity : BaseActivityDagger() {

    private var adapter: RocketListAdapter? = null
    private var snackBar: Snackbar? = null
    private var welcomeDialog: AlertDialog? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val viewModel: RocketsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(RocketsViewModel::class.java)
    }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        observeViewModel()
        viewModel.loadRocketList(false)
    }

    override fun onDestroy() {
        viewModel.cancelActiveJobs()
        snackBar?.apply { if (isShown) dismiss() }
        welcomeDialog?.apply { if (isShowing) dismiss() }
        errorDialog?.apply { if (isShowing) dismiss() }
        super.onDestroy()
    }

    private fun handleRocketListData(resource: Resource<List<RocketDomain>>) {
        when(resource.status){
            Status.SUCCESS -> {
                adapter?.update(resource.data)
                ui_swipe_to_refresh.isRefreshing = false
            }
            Status.ERROR -> {
                showErrorDialog(resource.message ?: "Error")
                ui_swipe_to_refresh.isRefreshing = false
            }
            Status.LOADING -> ui_swipe_to_refresh.isRefreshing = true
        }
    }

    private fun handleUiEvents(event: RocketsViewModel.UiEvent?) {
        when (event) {
            is RocketsViewModel.UiEvent.ShowWelcomeMessage -> showWelcomeDialog()
        }
    }

    @ExperimentalCoroutinesApi
    private fun initView() {
        adapter = RocketListAdapter(rocketListClickListener)
        ui_rocket_list.layoutManager = LinearLayoutManager(this)
        ui_rocket_list.adapter = adapter
        ui_swipe_to_refresh.setOnRefreshListener { viewModel.loadRocketList(true) }
    }

    private fun observeViewModel(){
        viewModel.event.observe(this, Observer { handleUiEvents(it) })
        viewModel.rocketsLiveData.observe(this, Observer { handleRocketListData(it) })
    }

    private val rocketListClickListener = object : RocketListAdapter.ItemClickListener {
        override fun onClick(position: Int) {
            val rocket = adapter?.getItem(position)
            showSnackBar("clicked on ${rocket?.name}")
        }
    }

    private fun showWelcomeDialog() {
        if (welcomeDialog == null) {
            welcomeDialog = AlertDialog.Builder(this)
                .setTitle(getString(R.string.welcome))
                .setPositiveButton(getString(R.string.continue_text), null)
                .create()
        }
        welcomeDialog?.show()
    }


    private fun showSnackBar(msg: String) {
        snackBar = Snackbar.make(root_view, msg, Snackbar.LENGTH_LONG)
        snackBar?.show()
    }


    var errorDialog: AlertDialog? = null

    fun showErrorDialog(msg: String) {
        if (errorDialog == null) {
            errorDialog = AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(msg)
                .setPositiveButton("dismiss", null)
                .create()
        }
        errorDialog?.show()
    }


}
