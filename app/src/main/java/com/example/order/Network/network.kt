import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "http://172.172.15.79:5000/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: LoginApiService by lazy {
        retrofit.create(LoginApiService::class.java)
    }

    val foodapi: FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }

    val foodcategoryapi: FoodCategoryApiService by lazy {
        retrofit.create(FoodCategoryApiService::class.java)
    }

    val categoryfoodlistapi: CategoryFoodApi by lazy {
        retrofit.create(CategoryFoodApi::class.java)
    }

    val bannerapi: BannerApi by lazy {
        retrofit.create(BannerApi::class.java)
    }
    val orderapi: OrderApi by lazy {
        retrofit.create(OrderApi::class.java)
    }
    val getorderapi: getOrdersApi by lazy {
        retrofit.create(getOrdersApi::class.java)
    }

    val postapi: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }

}

