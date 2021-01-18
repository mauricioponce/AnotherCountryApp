package cl.eme.countries.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryAPI {
    @GET("all")
    suspend fun getCountries(): Response<List<Country>>
}

// Cliente retrofit
const val BASE_URL = "https://restcountries.eu/rest/v2/"
class RetrofitClient {
    companion object {
        fun instance(): CountryAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(CountryAPI::class.java)
        }
    }
}