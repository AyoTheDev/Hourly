package com.ayo.spacex.ui.rockets

import com.ayo.spacex.R
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayo.spacex.ui.rockets.adapter.RocketListAdapter
import com.ayo.spacex.ui.base.BaseActivityDagger
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class RocketsActivity : BaseActivityDagger() {

    private var adapter: RocketListAdapter? = null
    private var snackBar: Snackbar? = null
    private var welcomeDialog: AlertDialog? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: RocketsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(RocketsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        viewModel.event.observe(this, Observer { handleUiEvents(it) })
        viewModel.loadRocketList(false)
    }

    override fun onDestroy() {
        viewModel?.cancelActiveJobs()
        snackBar?.apply { if (isShown) dismiss() }
        welcomeDialog?.apply { if (isShowing) dismiss() }
        super.onDestroy()
    }

    private fun handleUiEvents(event: RocketsViewModel.Event?) {
        when (event) {
            is RocketsViewModel.Event.ShowWelcomeMessage -> showWelcomeDialog()
            is RocketsViewModel.Event.RocketList -> {
                event.data?.let { adapter?.update(it) }
                event.loading?.let { ui_swipe_to_refresh.isRefreshing = it }
                event.exception?.let { showSnackBar(it.message ?: "Error") }
            }
        }
    }

    private fun initView() {
        adapter = RocketListAdapter(rocketListClickListener)
        ui_rocket_list.layoutManager = LinearLayoutManager(this)
        ui_rocket_list.adapter = adapter
        ui_swipe_to_refresh.setOnRefreshListener { viewModel.loadRocketList(true) }
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


}
