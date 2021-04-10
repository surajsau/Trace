package `in`.surajsau.trace.playstore

import `in`.surajsau.trace.R
import `in`.surajsau.trace.databinding.ActivitySplashBinding
import `in`.surajsau.trace.playstore.ui.main.MainActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        GlobalScope.launch(Dispatchers.Main) {
            delay(2_000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finishAffinity()
        }
    }
}
