package na.severinchik.lesson5.presentation.screen.list.updatableadapter

import na.severinchik.lesson5.data.entities.User
import na.severinchik.lesson5.databinding.UserItemListBinding
import na.severinchik.lesson5.presentation.basics.adapter.BasicViewHolder

class UserViewHolder(private val bindingImpl: UserItemListBinding) :
    BasicViewHolder<User>(bindingImpl) {
    override fun bind(item: User) {
        bindingImpl.uilAvatar.text = item.name.first().toString()
        bindingImpl.uilName.text = item.name
    }
}