package na.severinchik.lesson6.presentation.screen.dogsandcats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson6.R
import na.severinchik.lesson6.databinding.ActivityDogsPhotoAndCatsFactBinding

class DogsPhotoAndCatsFactActivity : AppCompatActivity() {

    private var _binding: ActivityDogsPhotoAndCatsFactBinding? = null
    private val binding: ActivityDogsPhotoAndCatsFactBinding
        get() = _binding!!

    private val viewModel: DogAndCatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDogsPhotoAndCatsFactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adpacfUpdate.setOnClickListener {
            viewModel.fetch()
        }

        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { state ->
                binding.adpacfFactTextView.text = "Fact about cats:\n ${state.factCat}"
                Glide.with(this@DogsPhotoAndCatsFactActivity)
                    .load(state.linkDog)
                    .centerCrop()
                    .circleCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.adpacfImage)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}