package com.example.baseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val restApiAdapter = RestApiAdapter()
        val endPoint = restApiAdapter.connectionApi()
        val bookResponseCall = endPoint.getAllPost()

        val list = arrayListOf<Post>()

        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
        }

        bookResponseCall.enqueue( object : Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response?.body()

                posts?.forEach{
                    list.add( Post(it.userId, it.id, it.title, it.body))
                    recyclerView.adapter = UserListAdapter(list, this)
                    GlobalScope.launch {
                        val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                        val repository = BookRepository(bookDao)
                        repository.insert(PostBook(it.title, it.body))
                        val lista = repository.getListBooks()
                        lista.forEach {
                            Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}")
                        }
                    }

                }
                Log.d("RESP POST", Gson().toJson(posts))
                posts?.forEach {
                    Log.d("RESP POST", it.body)
                }

            }
        })

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
    }

}
