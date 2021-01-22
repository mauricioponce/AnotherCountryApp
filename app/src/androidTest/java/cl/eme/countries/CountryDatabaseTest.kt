package cl.eme.countries

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import cl.eme.countries.model.CountriesDatabase
import cl.eme.countries.model.Country
import cl.eme.countries.model.CountryDao
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CountriesDatabaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Instancias de DAO y database
    private lateinit var cDao: CountryDao
    private lateinit var db: CountriesDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, CountriesDatabase::class.java).build()
        cDao = db.countryDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertCountry_empty() = runBlocking {
        // Given
        val countryList = listOf<Country>()

        // When
        cDao.insert(countryList)

        // Then
        cDao.getMinimalCountries().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEmpty()
        }
    }

    /*
    @Test
    fun insertCountry_1element() = runBlocking {
        // Given
        val countryList = listOf(Country("cl", "cl", "cl", "flag"))

        // When
        cDao.insert(countryList)

        // Then
        cDao.getMinimalCountries().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).hasSize(1)
        }
    }
*/
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Truth.assertThat("cl.eme.countries").isEqualTo(appContext.packageName)
    }
}