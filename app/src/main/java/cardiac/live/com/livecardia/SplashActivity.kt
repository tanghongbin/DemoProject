package cardiac.live.com.livecardia

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import cardiac.live.com.livecardiacandroid.constants.RouteConstants
import cardiac.live.com.livecardiacandroid.utils.Utils
import cardiac.live.com.testlibrary.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mNext.setOnClickListener {
            Utils.routeNavigation(RouteConstants.MAIN_ROUTE)
        }

    }
}
