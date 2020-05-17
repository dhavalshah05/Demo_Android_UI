package com.alphastack.android.ui.base

import java.util.*

abstract class BaseObservableUIView<ListenerType> : BaseUIView() {

    private val listeners = mutableSetOf<ListenerType>()

    /**
     *
     */
    fun registerListener(listener: ListenerType) {
        listeners.add(listener)
    }

    /**
     *
     */
    fun unregisterListener(listener: ListenerType) {
        listeners.remove(listener)
    }

    /**
     *
     */
    protected fun getListeners(): Set<ListenerType> {
        return Collections.unmodifiableSet(listeners)
    }

}