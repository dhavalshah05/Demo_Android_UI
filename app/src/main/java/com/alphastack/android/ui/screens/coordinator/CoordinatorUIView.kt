package com.alphastack.android.ui.screens.coordinator

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.android.ui.R
import com.alphastack.android.ui.base.BaseObservableUIView
import com.alphastack.android.ui.base.BaseUIView
import kotlinx.android.synthetic.main.coordinator_ui_view.view.*

class CoordinatorUIView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        private val deviceHeight: Int
) : BaseObservableUIView<CoordinatorUIView.Listener>() {

    interface Listener {
        fun onBackPressed()
    }

    init {
        setRootView(inflater.inflate(R.layout.coordinator_ui_view, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    private fun setUpViews() {
        setCollapsingToolbarHeight()
    }

    private fun setUpViewListeners() {
        getRootView().toolbar.setNavigationOnClickListener {
            getListeners().forEach { it.onBackPressed() }
        }
    }

    private fun setCollapsingToolbarHeight() {
        val height = (deviceHeight * 70) / 100
        val layoutParams = getRootView().collapsingToolbarLayout.layoutParams
        layoutParams.height = height
        getRootView().collapsingToolbarLayout.layoutParams = layoutParams
    }

}