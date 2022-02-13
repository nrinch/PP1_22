package na.severinchik.lesson4

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

private const val TEXT_FIELD_KEY = "text_field_key"

class MainActivity : AppCompatActivity() {

    companion object {
        const val SOME_DATA_KEY = "some_data_key"
    }

    lateinit var textField: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textField = findViewById(R.id.am_text_field)
        button = findViewById(R.id.am_button)
        button.setOnClickListener {
//            openWebPage("https://developer.android.com/guide/components/intents-common?hl=ru#ViewUrl")
            runImplicitIntent(textField.text.toString())
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_FIELD_KEY, textField.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textField.setText(savedInstanceState.getString(TEXT_FIELD_KEY) ?: String.EMPTY)
    }

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }

    fun runImplicitIntent(data: String) {
        Intent(this, SecondaryActivity::class.java).apply {
            putExtra(SOME_DATA_KEY, data)
            startActivity(this)
        }

//        val intent = Intent(this,SecondaryActivity::class.java)
//        startActivity(intent)
    }


    fun withCheckPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                42
            )
        } else {
            // TODO()
        }
    }
}

val String.Companion.EMPTY
    get() = ""


class TemporaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }
}