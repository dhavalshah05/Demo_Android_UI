package com.alphastack.android.ui.screens.constraintsetanimation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.alphastack.android.ui.R
import com.alphastack.android.ui.base.BaseObservableUIView
import kotlinx.android.synthetic.main.constraintset_animation_ui_view_start.view.*
import kotlinx.android.synthetic.main.toolbar.view.*

class ConstraintSetAnimationUIView(
        inflater: LayoutInflater,
        parent: ViewGroup?
) : BaseObservableUIView<ConstraintSetAnimationUIView.Listener>() {

    interface Listener {
        fun onBackPressed()
    }

    private val constraintSetStart = ConstraintSet()
    private val constraintSetEnd = ConstraintSet()

    private var isSidePanelVisible = false

    init {
        setRootView(inflater.inflate(R.layout.constraintset_animation_ui_view_start, parent, false))
        setUpView()
        setUpViewListeners()
    }

    private fun setUpView() {
        constraintSetStart.clone(getRootView().constraintLayout)
        constraintSetEnd.clone(getContext(), R.layout.constraintset_animation_ui_view_end)
        isSidePanelVisible = false
    }

    private fun setUpViewListeners() {
        getRootView().setOnClickListener {
            toggleAnimation()
        }
        (getRootView().toolbar as Toolbar).setNavigationOnClickListener {
            getListeners().forEach { it.onBackPressed() }
        }
    }

    private fun toggleAnimation() {
        val transition = AutoTransition()
        transition.duration = 150
        transition.interpolator = LinearInterpolator()

        TransitionManager.beginDelayedTransition(getRootView().constraintLayout, transition)

        if (isSidePanelVisible) {
            constraintSetStart.applyTo(getRootView().constraintLayout)
        } else {
            constraintSetEnd.applyTo(getRootView().constraintLayout)
        }
        isSidePanelVisible = !isSidePanelVisible
    }

}