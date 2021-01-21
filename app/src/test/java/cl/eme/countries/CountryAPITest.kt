package cl.eme.countries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.eme.countries.model.CountryAPI
import cl.eme.countries.model.MinimalCountry
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// https://stackoverflow.com/questions/39827081/unit-testing-android-application-with-retrofit-and-rxjava
// https://android.jlelse.eu/unit-test-api-calls-with-mockwebserver-d4fab11de847
@RunWith(JUnit4::class)
class CountryAPITest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockWebServer: MockWebServer

    private lateinit var service: CountryAPI

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryAPI::class.java)
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun countriesList_happyCase() = runBlocking{
        // Given
        val resultList = listOf(MinimalCountry("cl", "cl", "cl", "flag"))
        mockWebServer.enqueue(MockResponse().setBody(Gson().toJson(resultList)))

        // When
        val result = service.getCountries()

        // Then
        assertThat(result).isNotNull()
        assertThat(result.isSuccessful).isTrue()

        val message = result.body()
        assertThat(message).isNotNull()
        assertThat(message).hasSize(1)
    }
}