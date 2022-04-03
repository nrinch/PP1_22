package na.severinchik.lesson6.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = MainAdapter()
        binding.amRecycler.apply {
            this.adapter = adapter
        }

        viewModel.update()

        binding.amInsertButton.setOnClickListener {
            viewModel.insert()
        }


        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { listNotes ->
                adapter.submitList(listNotes)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}