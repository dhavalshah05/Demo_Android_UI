package com.alphastack.android.ui.screens.constraintsetanimation

import com.alphastack.android.ui.base.BaseObservableUIView

abstract class ConstraintSetAnimationUIView: BaseObservableUIView<ConstraintSetAnimationUIView.Listener>() {

    interface Listener {
        fun onBackPressed()
    }

}