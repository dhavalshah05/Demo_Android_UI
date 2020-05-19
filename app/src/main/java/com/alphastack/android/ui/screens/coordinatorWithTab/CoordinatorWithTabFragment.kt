package com.alphastack.android.ui.screens.coordinatorWithTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alphastack.android.ui.ScreenNavigator
import com.alphastack.android.ui.screens.coordinatorWithTab.tab.SingleTabFragment

class CoordinatorWithTabFragment : Fragment(), CoordinatorWithTabUIView.Listener {

    private lateinit var uiView: CoordinatorWithTabUIView
    private var screenNavigator: ScreenNavigator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = CoordinatorWithTabUIViewImpl(inflater, container)
        screenNavigator = requireActivity() as ScreenNavigator
        return uiView.getRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPagerWithTabs()
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

    private fun setUpViewPagerWithTabs() {
        val fragmentList = listOf(
                SingleTabFragment(),
                SingleTabFragment(),
                SingleTabFragment()
        )
        val tagTitleList = listOf(
                "First",
                "Second",
                "Third"
        )
        uiView.setViewPagerAndTabs(SingleTabAdapter(this, fragmentList), tagTitleList)
    }

    private inner class SingleTabAdapter(fragment: Fragment,
                                         private val fragmentList: List<SingleTabFragment>) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }

}