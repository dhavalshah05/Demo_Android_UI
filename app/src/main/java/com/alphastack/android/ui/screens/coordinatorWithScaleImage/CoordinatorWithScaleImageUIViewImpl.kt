package com.alphastack.android.ui.screens.coordinatorWithScaleImage

import android.graphics.Matrix
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.android.ui.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.coordinator_with_scale_image_ui_view.view.*
import kotlin.math.roundToInt


class CoordinatorWithScaleImageUIViewImpl(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        private val deviceHeight: Int
) : CoordinatorWithScaleImageUIView() {

    init {
        setRootView(inflater.inflate(R.layout.coordinator_with_scale_image_ui_view, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    private fun setUpViews() {
        setCollapsingToolbarHeight()
    }

    private fun setUpViewListeners() {
        getRootView().toolbar.setNavigationOnClickListener {
            getListeners().forEach { it.onBackPressed() }
        }
        setUpAppbarScrollBehaviour()
    }

    private fun setCollapsingToolbarHeight() {
        val height = (deviceHeight * 70) / 100
        val layoutParams = getRootView().collapsingToolbarLayout.layoutParams
        layoutParams.height = height
        getRootView().collapsingToolbarLayout.layoutParams = layoutParams
    }

    private fun setUpAppbarScrollBehaviour() {
        getRootView().appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->

            val imageView = getRootView().imageViewToolbar
            val matrix = Matrix(imageView.imageMatrix)

            //get image's width and height

            //get image's width and height
            val dWidth: Int = imageView.drawable.intrinsicWidth
            val dHeight: Int = imageView.drawable.intrinsicHeight

            //get view's width and height

            //get view's width and height
            val vWidth: Int = imageView.width - imageView.paddingLeft - imageView.paddingRight
            var vHeight: Int = imageView.height - imageView.paddingTop - imageView.paddingBottom

            val scale: Float
            var dx = 0f
            var dy = 0f
            val parallaxMultiplier = (imageView.layoutParams as CollapsingToolbarLayout.LayoutParams).parallaxMultiplier

            //maintain the image's aspect ratio depending on offset

            //maintain the image's aspect ratio depending on offset
            if (dWidth * vHeight > vWidth * dHeight) {
                vHeight += verticalOffset //calculate view height depending on offset
                scale = vHeight.toFloat() / dHeight.toFloat() //calculate scale
                dx = (vWidth - dWidth * scale) * 0.5f //calculate x value of the center point of scaled drawable
                dy = -verticalOffset * (1 - parallaxMultiplier) //calculate y value by compensating parallaxMultiplier
            } else {
                scale = vWidth.toFloat() / dWidth.toFloat()
                dy = (vHeight - dHeight * scale) * 0.5f
            }

            val currentWidth = (scale * dWidth).roundToInt() //calculate current intrinsic width of the drawable


            if (vWidth <= currentWidth) { //compare view width and drawable width to decide, should we scale more or not
                matrix.setScale(scale, scale)
                matrix.postTranslate(dx.roundToInt().toFloat(), dy.roundToInt().toFloat())
                imageView.imageMatrix = matrix
            }
        })
    }
}