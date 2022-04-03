package na.severinchik.lesson6.presentation.screen.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import na.severinchik.lesson6.data.localsource.entities.Note
import na.severinchik.lesson6.databinding.NoteItemBinding
import na.severinchik.lesson6.presentation.screen.main.MainAdapter.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val NOTE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS"

class MainAdapter() : ListAdapter<Note, NotesViewHolder>(NotesDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NotesViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.niTitle.text = note.title
            binding.niBody.text = note.body
            val date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(NOTE_DATE_FORMAT))
            binding.niDate.text = date
        }
    }

    class NotesDiffUtilCallback() : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }


}