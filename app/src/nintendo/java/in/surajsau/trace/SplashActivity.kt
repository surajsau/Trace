package `in`.surajsau.trace

import `in`.surajsau.trace.databinding.ActivitySplashBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }
}
