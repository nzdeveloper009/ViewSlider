package com.nokhaiz.indicatorView.draw.drawer.type

import android.graphics.Canvas
import android.graphics.Paint
import com.nokhaiz.indicatorView.animation.data.Value
import com.nokhaiz.indicatorView.animation.data.type.SlideAnimationValue
import com.nokhaiz.indicatorView.draw.data.Indicator
import com.nokhaiz.indicatorView.draw.data.Orientation

class SlideDrawer(paint: Paint, indicator: Indicator) : BaseDrawer(paint, indicator) {
    fun draw(
        canvas: Canvas,
        value: Value,
        coordinateX: Int,
        coordinateY: Int) {
        if (value !is SlideAnimationValue) {
            return
        }
        val coordinate = value.coordinate
        val unselectedColor = indicator.unselectedColor
        val selectedColor = indicator.selectedColor
        val radius = indicator.radius
        paint.color = unselectedColor
        canvas.drawCircle(coordinateX.toFloat(), coordinateY.toFloat(), radius.toFloat(), paint)
        paint.color = selectedColor
        if (indicator.orientation == Orientation.HORIZONTAL) {
            canvas.drawCircle(coordinate.toFloat(), coordinateY.toFloat(), radius.toFloat(), paint)
        } else {
            canvas.drawCircle(coordinateX.toFloat(), coordinate.toFloat(), radius.toFloat(), paint)
        }
    }
}