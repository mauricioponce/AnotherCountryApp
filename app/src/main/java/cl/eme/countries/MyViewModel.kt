package cl.eme.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.countries.model.Country
import cl.eme.countries.model.MinimalCountry
import cl.eme.countries.model.Repository
import kotlinx.coroutines.launch
import timber.log.Timber

class MyViewModel: ViewModel() {
    private val repository = Repository()

    val minimalCountries = repository.minimalCountries

    init {
        Timber.d("give me tha countries")
        viewModelScope.launch {
            repository.getCountries()
        }
    }

    private lateinit var selectedCountry: MinimalCountry

    fun selected(minimalCountry: MinimalCountry) {
        selectedCountry = minimalCountry
    }

    fun getDetail(): LiveData<Country> {
        return repository.getCountry(selectedCountry.alpha2Code)
    }
}