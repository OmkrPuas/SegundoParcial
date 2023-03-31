package com.example.baseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var recycleView: RecyclerView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)


        val list2 = arrayListOf<User>( User("roberto1", "calyr.software@gmail.com"),
            User("roberto2", "calyr.software@gmail.com"),
            User("roberto3", "calyr.software@gmail.com"),
            User("roberto4", "calyr.software@gmail.com")
        )

        //val list = arrayListOf<Post>( Post(item.userId,item.id,item.title, item.body))

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recycleView = findViewById(R.id.recycle_view)
        recycleView.layoutManager = linearLayoutManager
        //recycleView.adapter = UserListAdapter(list2, this)

    }
}