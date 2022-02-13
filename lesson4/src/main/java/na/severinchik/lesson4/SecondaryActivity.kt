package na.severinchik.lesson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondaryActivity : AppCompatActivity() {

    lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)


        title = findViewById(R.id.as_title)
        title.text = intent.getStringExtra(MainActivity.SOME_DATA_KEY) ?: String.EMPTY
        title.setOnClickListener {
            Intent(this, MainActivity::class.java).apply { startActivity(this)
            finish()}
        }
    }
}