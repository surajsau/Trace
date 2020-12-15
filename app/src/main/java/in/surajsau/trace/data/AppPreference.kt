package `in`.surajsau.trace.data

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

interface AppPreference {
    fun save(key: String, value: String)
}

class AppPreferenceImpl @Inject constructor(
    private val context: Context
) : AppPreference {
    val sharedPreference = context.getSharedPreferences("Trace", Context.MODE_PRIVATE)

    override fun save(key: String, value: String) {
        sharedPreference.edit {
            putString(key, value)
        }
    }
}
