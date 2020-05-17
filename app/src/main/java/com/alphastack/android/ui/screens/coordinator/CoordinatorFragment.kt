package com.alphastack.android.ui.screens.coordinator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alphastack.android.ui.ScreenNavigator
import com.alphastack.android.ui.utils.DisplayMetrics

class CoordinatorFragment: Fragment(), CoordinatorUIView.Listener {

    private lateinit var uiView: CoordinatorUIView

    private var screenNavigator: ScreenNavigator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = CoordinatorUIView(
                inflater = inflater,
                parent = container,
                deviceHeight = DisplayMetrics.getDeviceHeightInPixel(requireActivity())
        )
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

    override fun onBackPressed() {
        screenNavigator?.navigateUp()
    }

}