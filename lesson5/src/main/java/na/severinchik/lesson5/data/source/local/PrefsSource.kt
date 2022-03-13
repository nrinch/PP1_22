package na.severinchik.lesson5.data.source.local

import android.content.Context

private const val MAIN_PREFS = "main_prefs"

private const val MAIN_PREFS_COUNTER_KEY = "main_prefs_counter_key"

private const val DEFAULT_COUNTER_VALUE = 0

class PrefsSource(private val context: Context) {
    private val prefs = context.getSharedPreferences(MAIN_PREFS, Context.MODE_PRIVATE)


    fun updateCountEntriesInApp(value: Int) {
        prefs.edit().apply {
            putInt(MAIN_PREFS_COUNTER_KEY, value)
            apply()
        }
    }

    fun getCountEntriesInApp() = prefs.getInt(MAIN_PREFS_COUNTER_KEY, DEFAULT_COUNTER_VALUE)

}