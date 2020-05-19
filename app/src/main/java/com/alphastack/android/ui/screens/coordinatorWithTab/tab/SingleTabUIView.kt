package com.alphastack.android.ui.screens.coordinatorWithTab.tab

import com.alphastack.android.ui.base.BaseObservableUIView

abstract class SingleTabUIView: BaseObservableUIView<SingleTabUIView.Listener>() {

    interface Listener {

    }

    abstract fun setTabMessage(message: String)
}