package `in`.surajsau.trace.ui.splash

import `in`.surajsau.trace.R
import `in`.surajsau.trace.domain.repository.AuthRepository
import `in`.surajsau.trace.ui.login.LoginActivity
import `in`.surajsau.trace.ui.main.MainActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (authRepository.isAuthenticated()) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        finishAffinity()
    }
}
