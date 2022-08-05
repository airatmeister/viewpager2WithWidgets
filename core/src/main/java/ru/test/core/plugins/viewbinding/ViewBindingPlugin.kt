package ru.test.core.plugins.viewbinding

import ru.test.core.plugins.BasePlugin
import ru.test.core.plugins.LifecycleEvent

class ViewBindingPlugin : BasePlugin {

    private val clearListeners: MutableList<ClearBinding> = mutableListOf()

    fun addClearListener(listener: ClearBinding) {
        clearListeners.add(listener)
    }

    override fun onLifecycleEvent(event: LifecycleEvent) {
        when (event) {
            is LifecycleEvent.OnDestroyView -> {
                clearListeners.forEach { it.clear() }
                clearListeners.clear()
            }
            else -> Unit
        }
    }

    interface ClearBinding {
        fun clear()
    }
}