package na.severinchik.lesson5.presentation.screen.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson5.R
import na.severinchik.lesson5.databinding.ActivityMainBinding
import na.severinchik.lesson5.presentation.screen.list.UsersListActivity

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding
        get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java) // 1st variant providing ViewModel (without params)

//        val factory = MainViewModelFactory(userName = "John Doe")                             // 2nd variant providing ViewModel (with params)
//        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        lifecycleScope.launchWhenResumed {
            viewModel.state.collect { data ->
                binding.amTextField.text = data
            }
        }
        var counterEntries = viewModel.fetchCounter()
        binding.amTextFiledCounter.text = getString(R.string.count_of_entry, counterEntries)
        counterEntries++
        viewModel.updateCounter(counterEntries)

        binding.amButton.setOnClickListener {
//            viewModel.fetchData()
            Intent(this, UsersListActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}