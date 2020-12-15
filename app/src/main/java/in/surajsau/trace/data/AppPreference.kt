package `in`.surajsau.trace.data

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface AppPreference {
    fun save(key: String, value: String)

    fun has(key: String): Boolean
}

class AppPreferenceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AppPreference {
    private val sharedPreference = context.getSharedPreferences("Trace", Context.MODE_PRIVATE)

    override fun save(key: String, value: String) {
        sharedPreference.edit {
            putString(key, value)
        }
    }

    override fun has(key: String): Boolean {
        return sharedPreference.contains(key)
    }
}
