package na.severinchik.lesson5.presentation.screen.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import na.severinchik.lesson5.data.entities.User
import na.severinchik.lesson5.databinding.UserItemListBinding

class UsersListAdapter(private val data: List<User>, private val listener: OnClickListener) :
    RecyclerView.Adapter<UsersListAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemListBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(
            binding = binding,
            listener = listener
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class UserViewHolder(
        private val binding: UserItemListBinding,
        private val listener: OnClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.uilAvatar.text = user.name.first().toString()
            binding.uilName.text = user.name
            binding.uilCard.setOnClickListener {
                listener.onClick(user)
            }
        }
    }

    interface OnClickListener {
        fun onClick(user: User)
    }

}