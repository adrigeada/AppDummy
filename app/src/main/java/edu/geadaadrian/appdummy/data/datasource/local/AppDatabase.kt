package edu.geadaadrian.appdummy.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.geadaadrian.appdummy.data.model.Libro

@Database(
    entities = [Libro::class],   // lista de todas las @Entity de la app
    version = 1,                 // versión del esquema — incrementar al hacer cambios
    exportSchema = true          // exportar esquema a /schemas para migraciones
)
@TypeConverters(Converters::class)  // clase con @TypeConverter para tipos complejos
abstract class AppDatabase : RoomDatabase() {
    // Room genera la implementación concreta en tiempo de compilación
    abstract fun libroDao(): LibrosDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appdummy_database"
                )
                    // Para proyectos de aprendizaje: si cambia el esquema, borra y recrea la BD
                    // En producción real se escribirían objetos Migration en lugar de esto
                    .fallbackToDestructiveMigration(dropAllTables = true)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}

