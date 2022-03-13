package na.severinchik.lesson5.presentation.basics.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BasicViewHolder<T : BasicUiEntity<T>>(private val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)

}
