package com.alphastack.android.ui.base

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

abstract class BaseUIView {

    private lateinit var rootView: View

    /**
     *
     */
    protected fun setRootView(view: View) {
        this.rootView = view
    }

    /**
     *
     */
    fun getRootView(): View = rootView

    /**
     *
     */
    protected fun getContext(): Context = getRootView().context

    /**
     *
     */
    protected fun getString(@StringRes id: Int): String {
        return getContext().getString(id)
    }

    /**
     *
     */
    protected fun <T : View> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

    /**
     *
     */
    protected fun getDrawable(@DrawableRes id: Int): Drawable? {
        return ContextCompat.getDrawable(getContext(), id)
    }

    /**
     *
     */
    protected fun getColor(@ColorRes id: Int): Int {
        return ContextCompat.getColor(getContext(), id)
    }
}