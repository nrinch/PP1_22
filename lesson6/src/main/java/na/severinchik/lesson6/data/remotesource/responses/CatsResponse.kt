package na.severinchik.lesson6.data.remotesource.responses

import com.google.gson.annotations.SerializedName

data class CatsResponse(
    @SerializedName("fact")
    val value:String,
    @SerializedName("length")
    val length:Int
)
