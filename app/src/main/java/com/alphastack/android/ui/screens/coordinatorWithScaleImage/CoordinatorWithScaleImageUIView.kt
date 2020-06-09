package com.alphastack.android.ui.screens.coordinatorWithScaleImage

import com.alphastack.android.ui.base.BaseObservableUIView

abstract class CoordinatorWithScaleImageUIView: BaseObservableUIView<CoordinatorWithScaleImageUIView.Listener>() {

    interface Listener {
        fun onBackPressed()
    }

}