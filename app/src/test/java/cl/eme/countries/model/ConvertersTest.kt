package cl.eme.countries.model

import org.junit.Test

import com.google.common.truth.Truth.assertThat
import org.junit.Before

class ConvertersTest {

    private lateinit var converter: Converters

    @Before
    fun setup() {
        converter = Converters()
    }

    @Test
    fun list2String() {
        // Given
        val inputList = listOf("value1", "value2", "value3")
        val expected = "value1, value2, value3"

        // When
        val result = converter.list2String(inputList)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).isNotEmpty()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun string2List() {
        // Given
        val inputString = "value1, value2, value 3"

        // When
        val result = converter.string2List(inputString)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).hasSize(3)
        assertThat(result[0]).isEqualTo("value1")
        assertThat(result[2]).isEqualTo("value 3")
    }

    @Test
    fun list2Double() {
        // Given
        val inputList = listOf(1.1, 2.2)
        val expected = "1.1, 2.2"

        // When
        val result = converter.list2Double(inputList)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun list2Double_emptyList() {
        // Given
        val inputList = listOf<Double>()
        val expected = ""

        // When
        val result = converter.list2Double(inputList)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun doubles2List() {
        // Given
        val inputString = "1.1, 2.2"

        // When
        val result = converter.doubles2List(inputString)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).hasSize(2)
        assertThat(result[1]).isEqualTo(2.2)
    }

    @Test
    fun doubles2List_emptyString() {
        // Given
        val inputString = ""

        // When
        val result = converter.doubles2List(inputString)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).hasSize(0)
    }
}