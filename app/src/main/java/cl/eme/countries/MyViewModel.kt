package cl.eme.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.countries.model.Repository
import kotlinx.coroutines.launch
import timber.log.Timber

class MyViewModel: ViewModel() {

    private val repository = Repository()

    val countries = repository.countries

    val minimalCountries = repository.minimalCountries

    init {
        Timber.d("give me tha countries")
        viewModelScope.launch {
            repository.getCountries()
        }
    }
}