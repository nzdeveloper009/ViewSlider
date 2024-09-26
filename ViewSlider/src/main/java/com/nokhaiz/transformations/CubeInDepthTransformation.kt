package com.nokhaiz.transformations

import android.view.View
import com.nokhaiz.SliderPager

class CubeInDepthTransformation : SliderPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.cameraDistance = 20000f
        when {
            position < -1 -> {
                page.alpha = 0f
            }
            position <= 0 -> {
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.rotationY = 90 * Math.abs(position)
            }
            position <= 1 -> {
                page.alpha = 1f
                page.pivotX = 0f
                page.rotationY = -90 * Math.abs(position)
            }
            else -> {
                page.alpha = 0f
            }
        }
        if (Math.abs(position) <= 0.5) {
            page.scaleY = Math.max(.4f, 1 - Math.abs(position))
        } else if (Math.abs(position) <= 1) {
            page.scaleY = Math.max(.4f, 1 - Math.abs(position))
        }
    }
}