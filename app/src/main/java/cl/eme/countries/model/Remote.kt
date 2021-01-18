package cl.eme.countries.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryAPI {
    @GET("all")
    suspend fun getCountries(): Response<List<Country>>
}

// Pojo
data class Country(
    val name: String,
    val alpha2Code: String,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val region: String,
    val subregion: String,
    val population: Long,
    val latlng: LatLng,
    val demonym: String,
    val area: Double,
    val gini: Double,
    val timezones: List<String>,
    val borders: List<String>,
    val nativeName: String,
    val numericCode: String,
    val currencies: List<Currency>,
    val flag: String,
    val cioc: String
)

data class LatLng(val lat: Double, val long: Long)

data class Currency(val code: String, val name: String, val symbol: String)


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