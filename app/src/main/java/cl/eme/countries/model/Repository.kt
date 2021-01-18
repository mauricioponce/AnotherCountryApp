package cl.eme.countries.model

import timber.log.Timber

class Repository {

    private val countryDao = CountryApplication.countryDatabase!!.countryDao()

    val countries = countryDao.getCountries()

    val minimalCountries = countryDao.getMinimalCountries()

    suspend fun getCountries() {
        Timber.d("getCountries from API")
        val response = RetrofitClient.instance().getCountries()

        when(response.isSuccessful) {
            true -> {
                response.body()?.let {
                    countryDao.insert(it)
                }
            }
            false -> Timber.e("${response.code()} - ${response.errorBody()}")
        }
    }
}