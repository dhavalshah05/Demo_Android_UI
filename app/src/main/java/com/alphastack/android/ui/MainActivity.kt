package com.alphastack.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alphastack.android.ui.screens.constraintsetanimation.ConstraintSetAnimationFragment
import com.alphastack.android.ui.screens.coordinator.CoordinatorFragment
import com.alphastack.android.ui.screens.coordinatorWithTab.CoordinatorWithTabFragment
import com.ncapdevi.fragnav.FragNavController

class MainActivity : AppCompatActivity(), ScreenNavigator {

    private val fragNavController: FragNavController = FragNavController(supportFragmentManager, R.id.containerMain)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val fragments = listOf(MainFragment())
        fragNavController.rootFragments = fragments

        fragNavController.initialize(0, savedInstanceState)
    }

    override fun onBackPressed() {
        if (fragNavController.isRootFragment) {
            super.onBackPressed()
        } else {
            fragNavController.popFragment()
        }
    }

    override fun navigateUp() {
        onBackPressed()
    }

    override fun navigateToCoordinatorScreen() {
        fragNavController.pushFragment(CoordinatorFragment())
    }

    override fun navigateToConstraintSetAnimationScreen() {
        fragNavController.pushFragment(ConstraintSetAnimationFragment())
    }

    override fun navigateToCoordinatorWithTabScreen() {
        fragNavController.pushFragment(CoordinatorWithTabFragment())
    }

}
