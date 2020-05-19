package com.alphastack.android.ui.screens.coordinatorWithTab

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alphastack.android.ui.base.BaseObservableUIView

abstract class CoordinatorWithTabUIView: BaseObservableUIView<CoordinatorWithTabUIView.Listener>() {

    interface Listener {
        fun onBackPressed()
    }

    abstract fun setViewPagerAndTabs(adapter: FragmentStateAdapter, tabTitleList: List<String>)
}