package `in`.surajsau.trace.androidx

import `in`.surajsau.trace.App
import android.graphics.Outline
import android.util.TypedValue
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.disposeBy(disposable: CompositeDisposable) = disposable.add(this)

inline class Dp(val value: Float)

val Float.dp: Dp
    get() {
        val displayMetrics = App.instance.resources.displayMetrics
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), displayMetrics
        )
        return Dp(value = px)
    }

val Int.dp: Dp
    get() = this.toFloat().dp

fun RecyclerView.ViewHolder.getImageDrawable(@DrawableRes id: Int) = ContextCompat.getDrawable(itemView.context, id)

fun ImageView.setCornerRadius(corner: Dp) {
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View?, outline: Outline?) {
            view ?: return
            outline?.setRoundRect(0, 0, view.width, (view.height + corner.value).toInt(), corner.value)
        }
    }
    clipToOutline = true
}
