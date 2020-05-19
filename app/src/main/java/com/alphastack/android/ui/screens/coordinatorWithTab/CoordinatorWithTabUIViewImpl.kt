package com.alphastack.android.ui.screens.coordinatorWithTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alphastack.android.ui.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.coordinator_with_tab_ui_view.view.*

class CoordinatorWithTabUIViewImpl(
        inflater: LayoutInflater,
        parent: ViewGroup?
) : CoordinatorWithTabUIView() {

    init {
        setRootView(inflater.inflate(R.layout.coordinator_with_tab_ui_view, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    override fun setViewPagerAndTabs(adapter: FragmentStateAdapter, tabTitleList: List<String>) {
        getRootView().viewPager.adapter = adapter
        // Set Tab Text
        TabLayoutMediator(getRootView().tabLayout, getRootView().viewPager) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()
    }

    private fun setUpViews() {

    }

    private fun setUpViewListeners() {
        getRootView().toolbar.setNavigationOnClickListener {
            getListeners().forEach { it.onBackPressed() }
        }
    }

}