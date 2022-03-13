package na.severinchik.lesson5.presentation.screen.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.core.text.toSpannable
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson5.data.entities.User
import na.severinchik.lesson5.databinding.ActivityListBinding
import na.severinchik.lesson5.databinding.UserItemListBinding
import na.severinchik.lesson5.presentation.screen.list.updatableadapter.UpdatableUserListAdapter

class UsersListActivity : AppCompatActivity() {

    private var _binding: ActivityListBinding? = null
    private val binding: ActivityListBinding
        get() = _binding!!

    private val viewModel: UsersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adater = UpdatableUserListAdapter()
        binding.alOutputField.adapter = adater

        lifecycleScope.launchWhenResumed {
            viewModel.state.collect { data ->
                adater.submitList(data)
                adater.notifyDataSetChanged()
//                    UsersListAdapter(data, object : UsersListAdapter.OnClickListener {
//                        override fun onClick(user: User) {
////                            Toast.makeText(
////                                this@UsersListActivity,
////                                "Click by $user",
////                                Toast.LENGTH_LONG
////                            ).show()
//                            UserDialogFragment.instanceWithParams(user).apply {
//                                this.show(supportFragmentManager, UserDialogFragment.TAG)
//                            }
//                        }
//                    })

            }
        }

        binding.alButtonAdd.setOnClickListener { viewModel.add(User(42, "Vova")) }
        binding.alButtonGetAll.setOnClickListener { viewModel.getAllData() }
        binding.alButtonGetById.setOnClickListener { viewModel.getById(0) }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

class UserDialogFragment : DialogFragment() {

    private var _binding: UserItemListBinding? = null
    private val binding: UserItemListBinding
        get() = _binding!!

    private val NAME = "name"

    companion object {
        val TAG = "user_dialog_fragment"
        fun instanceWithParams(user: User): UserDialogFragment {
            return UserDialogFragment().apply {
                arguments = bundleOf(NAME to user.name)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserItemListBinding.inflate(layoutInflater, container, false)
        val name = arguments?.getString(NAME) ?: String.EMPTY
        binding.uilAvatar.text = name.first().toString()
        binding.uilName.text = name

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

val String.Companion.EMPTY
    get() = ""