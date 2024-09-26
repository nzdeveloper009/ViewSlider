package com.nokhaiz.indicatorView.animation

import com.nokhaiz.indicatorView.animation.controller.AnimationController
import com.nokhaiz.indicatorView.animation.controller.ValueController.UpdateListener
import com.nokhaiz.indicatorView.draw.data.Indicator

class AnimationManager(indicator: Indicator, listener: UpdateListener) {
    private val animationController: AnimationController?
    fun basic() {
        if (animationController != null) {
            animationController.end()
            animationController.basic()
        }
    }

    fun interactive(progress: Float) {
        animationController?.interactive(progress)
    }

    fun end() {
        animationController?.end()
    }

    init {
        animationController = AnimationController(indicator, listener)
    }
}