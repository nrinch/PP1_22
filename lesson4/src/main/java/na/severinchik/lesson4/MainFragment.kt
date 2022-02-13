package na.severinchik.lesson4

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.parcelize.Parcelize

private const val MAIN_FRAGMENT_USER_KEY = "main_fragment_user_key"

class MainFragment : Fragment() {

    lateinit var button: Button
    var user: User? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("-->>fragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("-->>fragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("-->>fragment onCreateView")
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        button = view.findViewById(R.id.fm_button)

        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, BlankFragment(), BlankFragment.TAG)
//                .addToBackStack(TAG)TAG
                .commit()
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        println("-->>fragment onStart")
    }

    override fun onResume() {
        super.onResume()
        user = arguments?.getParcelable<User>(MAIN_FRAGMENT_USER_KEY)
            .apply { println("-->> $this $user") }
        println("-->>fragment onResume")
    }

    override fun onPause() {
        super.onPause()
        println("-->>fragment onPause")
    }

    override fun onStop() {
        super.onStop()
        println("-->>fragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("-->>fragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("-->>fragment onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        println("-->>fragment onDetach")
    }

    companion object {
        const val TAG = "main_fragmemt_tag"

        fun createInstance(user: User, fragmentManager: FragmentManager): MainFragment {
            val fragment: MainFragment =/*
                (fragmentManager.findFragmentByTag(TAG) as MainFragment?) ?:*/ MainFragment()
            println("-->> createInstance $user")
            fragment.arguments = Bundle().apply {
                putParcelable(MAIN_FRAGMENT_USER_KEY, user)
            }
//            println("-->> ${(fragment.arguments as Bundle).getParcelable<User>(MAIN_FRAGMENT_USER_KEY)}")
//            bundleOf(MAIN_FRAGMENT_USER_KEY to user)
            return fragment
        }
    }
}

@Parcelize
data class User(val name: String, val surname: String) : Parcelable
/*{
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: String.EMPTY,
        parcel.readString() ?: String.EMPTY
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(surname)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}*/