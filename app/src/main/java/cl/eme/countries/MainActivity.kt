package cl.eme.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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
[ ] Fragmento de listado
    [ ] Layout de item list
    [ ] Adapter + ViewHolder + RV
    [ ] imágenes SVG
[ ] Fragmento de detalle
[ ] material design
[ ] Navigation
[ ] Testing para la API -> convertir al repo
*/

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()
        Timber.d("onCreate")

        viewModel.countries.observe(this, {
            Timber.d("tengo la lista de ${it.size} paises")
        })

    }

    private fun initLog() {
        // TODO verificar la configuración
        Timber.plant(Timber.DebugTree())
    }
}