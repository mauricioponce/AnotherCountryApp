package cl.eme.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[X] Consumo de API
    [X] Interfaz de operaciones
    [X] cliente de retrofit
    [X] POJOs
    [X] dependencias
    [X] permiso de internet
[ ] ROOM
    [ ] Dao
    [ ] cliente de base de datos
    [ ] Entities
    [ ] dependencias
    [ ] testing
    [ ] subclase de application
    [ ] type converters
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
    }
}