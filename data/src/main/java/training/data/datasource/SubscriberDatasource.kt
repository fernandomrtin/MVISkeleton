package training.data.datasource

import training.data.service.SubscriberService
import retrofit2.Retrofit
import javax.inject.Inject

class SubscriberDatasource @Inject constructor(
    private val retrofit: Retrofit
) {

    private val subscriberService = retrofit.create(SubscriberService::class.java)

    fun getSubscriptions() : String = subscriberService.getSubscriptions().execute().body().orEmpty()
}