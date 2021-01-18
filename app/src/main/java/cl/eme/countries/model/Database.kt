package cl.eme.countries.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import timber.log.Timber

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(countries: List<Country>)

    @Query("SELECT * FROM country")
    fun getCountries(): LiveData<List<Country>>

    @Query("SELECT * FROM country WHERE alpha2Code=:code")
    fun getCountryDetail(code: String): Country
}

@Database(entities = [Country::class], version = 1)
@TypeConverters(Converters::class)
abstract class CountriesDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}

class CountryApplication : Application() {
    companion object {
        var countryDatabase: CountriesDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("onCreate de Application")
        countryDatabase =
            Room.databaseBuilder(this, CountriesDatabase::class.java, "db_countries").build()
    }
}