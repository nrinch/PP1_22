package na.severinchik.lesson5.presentation.screen.list.updatableadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import na.severinchik.lesson5.data.entities.User
import na.severinchik.lesson5.databinding.UserItemListBinding
import na.severinchik.lesson5.presentation.basics.adapter.BasicAdapter

class UpdatableUserListAdapter : BasicAdapter<User, UserViewHolder>(UserListDiffCallback()) {
    override fun getViewHolder(parent: ViewGroup): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemListBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }
}