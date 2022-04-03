package na.severinchik.lesson6.data.remotesource.responses


import com.google.gson.annotations.SerializedName

data class DogsResponse(
    @SerializedName("message")
    val link: String,
    @SerializedName("status")
    val status: String
)