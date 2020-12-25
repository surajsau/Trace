package `in`.surajsau.trace.data

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

inline class PrefKey(val value: String)

interface AppPreference {
    fun save(key: PrefKey, value: String)

    fun get(key: PrefKey): String

    fun has(key: PrefKey): Boolean
}

class AppPreferenceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AppPreference {
    private val sharedPreference = context.getSharedPreferences("Trace", Context.MODE_PRIVATE)

    override fun save(key: PrefKey, value: String) {
        sharedPreference.edit {
            putString(key.value, value)
        }
    }

    override fun get(key: PrefKey): String {
        return sharedPreference.getString(key.value, "")!!
    }

    override fun has(key: PrefKey): Boolean {
        return sharedPreference.contains(key.value)
    }
}
