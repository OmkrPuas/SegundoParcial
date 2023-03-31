package com.example.baseproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
class PostBook(@ColumnInfo(name = "title") var title: String, @ColumnInfo(name = "body") var body: String) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}