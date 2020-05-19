package com.alphastack.android.ui.screens.coordinatorWithTab.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SingleTabFragment: Fragment() {

    private lateinit var uiView: SingleTabUIView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = SingleTabUIViewImpl(inflater, container)
        return uiView.getRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uiView.setTabMessage(this.uiView.hashCode().toString())
    }

}