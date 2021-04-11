package `in`.surajsau.trace.androidx

import android.content.Context
import androidx.core.content.ContextCompat

interface ResourceProvider {
    fun getColor(colorRes: Int): Int

    fun getString(stringId: Int, vararg args: Int): String
}

class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    override fun getColor(colorRes: Int): Int {
        return ContextCompat.getColor(context, colorRes)
    }

    override fun getString(stringId: Int, vararg args: Int): String {
        return context.getString(stringId, args)
    }
}
