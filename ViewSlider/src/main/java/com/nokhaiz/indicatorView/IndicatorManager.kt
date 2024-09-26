package com.nokhaiz.indicatorView

import com.nokhaiz.indicatorView.animation.AnimationManager
import com.nokhaiz.indicatorView.animation.controller.ValueController.UpdateListener
import com.nokhaiz.indicatorView.animation.data.Value
import com.nokhaiz.indicatorView.draw.DrawManager
import com.nokhaiz.indicatorView.draw.data.Indicator

class IndicatorManager internal constructor(private val listener: Listener?) : UpdateListener {
    private val drawManager: DrawManager = DrawManager()
    private val animationManager: AnimationManager

    internal interface Listener {
        fun onIndicatorUpdated()
    }

    fun animate(): AnimationManager {
        return animationManager
    }

    fun indicator(): Indicator {
        return drawManager.indicator()
    }

    fun drawer(): DrawManager {
        return drawManager
    }

    override fun onValueUpdated(value: Value?) {
        drawManager.updateValue(value)
        listener?.onIndicatorUpdated()
    }

    init {
        animationManager = AnimationManager(drawManager.indicator(), this)
    }
}