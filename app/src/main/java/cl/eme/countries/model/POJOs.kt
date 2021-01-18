package cl.eme.countries.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

// Pojo
@Entity(tableName = "country")
data class Country(
    val name: String,
    @PrimaryKey val alpha2Code: String,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val region: String,
    val subregion: String,
    val population: Long,
    val latlng: List<Double>, // TODO cambiar a data class
    val demonym: String,
    val area: Double,
    val gini: Double,
    val timezones: List<String>,
    val borders: List<String>,
    val nativeName: String,
    val numericCode: String?,
    //TODO @Embedded val currencies: List<Currency>,
    val flag: String
)

data class Currency(val code: String, val name: String, val symbol: String)


data class MinimalCountry(val name: String, val alpha2Code: String, val region: String, val flag: String)