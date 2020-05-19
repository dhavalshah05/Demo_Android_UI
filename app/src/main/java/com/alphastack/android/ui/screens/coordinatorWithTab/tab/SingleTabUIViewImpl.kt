package com.alphastack.android.ui.screens.coordinatorWithTab.tab

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.android.ui.R
import kotlinx.android.synthetic.main.single_tab_ui_view.view.*

class SingleTabUIViewImpl(
        inflater: LayoutInflater,
        parent: ViewGroup?
) : SingleTabUIView() {

    init {
        setRootView(inflater.inflate(R.layout.single_tab_ui_view, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    override fun setTabMessage(message: String) {
        getRootView().textViewTabMessage.text = message
    }

    private fun setUpViews() {

    }

    private fun setUpViewListeners() {

    }

}