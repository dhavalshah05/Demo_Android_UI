package com.alphastack.android.ui.screens.coordinator

import com.alphastack.android.ui.base.BaseObservableUIView

abstract class CoordinatorUIView: BaseObservableUIView<CoordinatorUIView.Listener>() {

    interface Listener {
        fun onBackPressed()
    }

}