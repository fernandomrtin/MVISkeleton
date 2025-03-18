package training.data.service

import retrofit2.Call
import retrofit2.http.GET

interface SubscriberService {

    @GET("To fill")
    fun getSubscriptions() : Call<String>
}