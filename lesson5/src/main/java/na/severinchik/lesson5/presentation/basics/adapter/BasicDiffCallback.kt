package na.severinchik.lesson5.presentation.basics.adapter

import androidx.recyclerview.widget.DiffUtil

open class BasicDiffCallback<T : BasicUiEntity<T>> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.same(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.contentSame(newItem)
    }
}
