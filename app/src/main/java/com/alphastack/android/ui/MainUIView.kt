package com.alphastack.android.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.android.ui.base.BaseObservableUIView
import kotlinx.android.synthetic.main.main_ui_view.view.*

class MainUIView(
        inflater: LayoutInflater,
        parent: ViewGroup?
): BaseObservableUIView<MainUIView.Listener>() {

    interface Listener {
        fun onCoordinateButtonClicked()
        fun onConstraintSetAnimationButtonClicked()
        fun onCoordinatorWithTabButtonClicked()
    }

    init {
        setRootView(inflater.inflate(R.layout.main_ui_view, parent, false))
        setUpView()
        setUpViewListeners()
    }

    private fun setUpView() {

    }

    private fun setUpViewListeners() {
        getRootView().buttonCoordinator.setOnClickListener {
            getListeners().forEach { it.onCoordinateButtonClicked() }
        }
        getRootView().buttonConstraintSetAnimation.setOnClickListener {
            getListeners().forEach { it.onConstraintSetAnimationButtonClicked() }
        }
        getRootView().buttonCoordinatorWithTab.setOnClickListener {
            getListeners().forEach { it.onCoordinatorWithTabButtonClicked() }
        }
    }

}