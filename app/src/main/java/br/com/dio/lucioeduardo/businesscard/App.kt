package br.com.dio.lucioeduardo.businesscard

import android.app.Application
import br.com.dio.lucioeduardo.businesscard.data.AppDatabase
import br.com.dio.lucioeduardo.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }

    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}