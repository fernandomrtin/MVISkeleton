package training.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import training.data.model.dto.MonsterDto

interface MonstersService {

    @GET("pokemon/{id}")
    suspend fun getMonsterData(@Path("id") id: Int): Response<MonsterDto>
}