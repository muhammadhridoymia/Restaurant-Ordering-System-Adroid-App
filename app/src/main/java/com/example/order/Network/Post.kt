import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.http.GET

data class res(
    val image: String,
    val message: String,
    val status: String,
    var likes: Int,
    val comments: List<String>,
    val id: String
)
data class PostRes(
    val success: Boolean,
    val posts: List<res>
)

interface PostApi {
    @GET("api/get/posts")
    suspend fun getPosts(): PostRes
}

class PostViewModel : ViewModel() {
    val Postdata = mutableStateOf<List<res>>(emptyList())
    val loading = mutableStateOf(true)
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.postapi.getPosts()
                if (response.success) {
                    Postdata.value = response.posts
                    loading.value = false
                    println("Post data: ${response.posts}")
                }
            }
            catch (e: Exception) {
                println(e.message)
            }
            finally {
                loading.value = false
            }
        }
    }
}