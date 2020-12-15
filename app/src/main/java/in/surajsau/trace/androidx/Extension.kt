package `in`.surajsau.trace.androidx

import `in`.surajsau.trace.App
import android.util.TypedValue
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

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
