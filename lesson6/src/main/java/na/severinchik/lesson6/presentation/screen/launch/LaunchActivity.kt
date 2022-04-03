package na.severinchik.lesson6.presentation.screen.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import na.severinchik.lesson6.R
import na.severinchik.lesson6.databinding.ActivityLaunchBinding
import na.severinchik.lesson6.presentation.screen.dogsandcats.DogsPhotoAndCatsFactActivity
import na.severinchik.lesson6.presentation.screen.main.MainActivity

class LaunchActivity : AppCompatActivity() {

    private var _binding: ActivityLaunchBinding? = null
    private val binding: ActivityLaunchBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.alDatabase.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.alRemote.setOnClickListener {
            Intent(this, DogsPhotoAndCatsFactActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}