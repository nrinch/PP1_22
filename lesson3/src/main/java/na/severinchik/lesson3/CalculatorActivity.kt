package na.severinchik.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val buttonOne: Button = findViewById<Button>(R.id.ca_one)
        val result: TextView = findViewById(R.id.ac_operation_input)
        buttonOne.setOnClickListener {
            println("-->> click")
            counter++
            result.setText("Current result $counter")

        }
    }

    fun onClick(v: View){
        when((v as Button).id){
            R.id.ca_one -> TODO()
        }
    }
}

