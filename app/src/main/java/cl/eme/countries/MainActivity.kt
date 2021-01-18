package cl.eme.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.BuildConfig
import timber.log.Timber

/*
[X] Consumo de API
    [X] Interfaz de operaciones
    [X] cliente de retrofit
    [X] POJOs
    [X] dependencias
    [X] permiso de internet
[ ] ROOM
    [X] Dao
    [X] cliente de base de datos
    [X] Entities
    [X] dependencias
    [ ] testing
    [X] subclase de application -> agregar al manifest
    [X] type converters (con testing)
[ ] corutinas (dependencias)
[ ] Repositorio
[ ] ViewModel (by viewModels()) -> Implementa el patrón factory
[ ] Testing a los mappers
[ ] Fragmento de listado
    [ ] Layout de item list
    [ ] Adapter + ViewHolder + RV
    [ ] imágenes SVG
[ ] Fragmento de detalle
[ ] Navigation
[ ] Testing para la API -> convertir al repo
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()
        Timber.d("onCreate")
    }

    private fun initLog() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}