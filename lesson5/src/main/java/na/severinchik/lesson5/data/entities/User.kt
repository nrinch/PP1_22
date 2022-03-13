package na.severinchik.lesson5.data.entities

import na.severinchik.lesson5.presentation.basics.adapter.BasicUiEntity

data class User(
    val id: Int,
    val name: String
) : BasicUiEntity<User>() {

    override fun same(entity: BasicUiEntity<User>): Boolean {
        return entity is User && entity.id == id
    }

    override fun contentSame(entity: BasicUiEntity<User>): Boolean {
        return entity is User && entity == this
    }
}
