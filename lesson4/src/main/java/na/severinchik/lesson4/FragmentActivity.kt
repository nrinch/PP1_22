package na.severinchik.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MainFragment())
            .commit()
//
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_container, BlankFragment(), BlankFragment.TAG)
//            .commit()

        println("-->> current step is OnCreate")
    }

    override fun onStart() {
        super.onStart()
        println("-->> current step is OnStart")
    }

    override fun onResume() {
        super.onResume()
        println("-->> current step is OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        println("-->> current step is OnRestart")
    }

    override fun onPause() {
        super.onPause()
        println("-->> current step is OnPause")
    }

    override fun onStop() {
        super.onStop()
        println("-->> current step is OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("-->> current step is OnDestroy")
    }
}