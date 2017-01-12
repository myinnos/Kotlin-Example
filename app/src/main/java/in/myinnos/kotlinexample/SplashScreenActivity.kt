package `in`.myinnos.kotlinexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle


class SplashScreenActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start main activity
        startActivity(Intent(this, MainActivity::class.java))

        // close this activity
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        finish()
    }

}
