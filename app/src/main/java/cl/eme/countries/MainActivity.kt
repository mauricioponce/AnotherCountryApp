package cl.eme.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import timber.log.Timber

/*
[X] Consumo de API
    [X] Interfaz de operaciones
    [X] cliente de retrofit
    [X] POJOs
    [X] dependencias
    [X] permiso de internet
[X] ROOM
    [X] Dao
    [X] cliente de base de datos
    [X] Entities
    [X] dependencias
    [X] subclase de application -> agregar al manifest
    [X] type converters (con testing)
[X] corutinas (dependencias)
[X] Repositorio
[X] ViewModel (by viewModels()) -> Implementa el patrón factory
[X] Fragmento de listado
    [X] Layout de item list
    [X] Adapter + ViewHolder + RV
    [X] imágenes SVG
[X] Fragmento de detalle
[ ] material design
[ ] Navigation
[ ] Testing para la API -> convertir al repo
*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()
        Timber.d("onCreate")

        configCoil()
    }

    private fun initLog() {
        Timber.plant(Timber.DebugTree())
    }

    private fun configCoil() {
        val context = this

        Coil.setImageLoader(ImageLoader.Builder(context)
            .componentRegistry {
                add(SvgDecoder(context))
            }
            .build())
    }
}