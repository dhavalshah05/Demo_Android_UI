package com.alphastack.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainFragment : Fragment(), MainUIView.Listener {

    private lateinit var uiView: MainUIView

    private var screenNavigator: ScreenNavigator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = MainUIView(inflater, null)
        screenNavigator = requireActivity() as ScreenNavigator
        return uiView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        uiView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        uiView.unregisterListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        screenNavigator = null
    }

    override fun onCoordinateButtonClicked() {
        screenNavigator?.navigateToCoordinatorScreen()
    }

}
