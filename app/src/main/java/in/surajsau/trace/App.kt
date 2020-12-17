package `in`.surajsau.trace

import android.app.Application
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        Stetho.initializeWithDefaults(this)

        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
