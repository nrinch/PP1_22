package na.severinchik.lesson5.data.source.local

import na.severinchik.lesson5.data.entities.User

class LocalSource {

    private val mList: MutableList<User> = mutableListOf(
        User(id = 0, name = "Johny"),
        User(id = 1, name = "Tom"),
        User(id = 2, name = "Matt"),
        User(id = 0, name = "Sean"),
        User(id = 4, name = "Mick"),
        User(id = 5, name = "Corey"),
        User(id = 6, name = "Alex")
    )

    fun add(user: User) {
        mList.add(user)
    }

    fun getAll() = mList.toList()

    fun getById(id: Int) = mList.filter { it.id == id }
}