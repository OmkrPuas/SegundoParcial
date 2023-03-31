package com.example.baseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityPostBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_book)

        lateinit var newTitle: EditText
        lateinit var newBody: EditText
        lateinit var newBook: Button

        newTitle = findViewById(R.id.editTitleBook)
        newBody = findViewById(R.id.editBodyBook)
        newBook = findViewById(R.id.addBookBtn)

        newBook.setOnClickListener {
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)
                repository.insert(PostBook(newTitle.getText().toString(), newBody.getText().toString()))
                val lista = repository.getListBooks()
                lista.forEach {
                    Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}, Body: ${it.body}")
                }
            }
        }
    }
}