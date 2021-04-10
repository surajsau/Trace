package `in`.surajsau.trace.androidx

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.core.graphics.drawable.toBitmap

class RoundedImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    var cornerRadius: Dp = 0.dp
        set(value) {
            field = value

            val original = drawable
            if (original != null)
                setImageDrawable(original)
        }

    override fun setImageDrawable(drawable: Drawable?) {
        if (drawable == null) {
            super.setImageDrawable(drawable)
            return
        }

        val bitmap = drawable.toBitmap()
        val roundedDrawable = RoundedBitmapDrawableFactory.create(context.resources, bitmap).apply {
            cornerRadius = this@RoundedImageView.cornerRadius.value
        }
        super.setImageDrawable(roundedDrawable)
    }
}
