package com.example.baseproject

class BookRepository(private val bookDao: IBookDao) {

    suspend fun insert(book: PostBook) {
        bookDao.insert(book)
    }

    fun getListBooks(): List<PostBook> {
        return bookDao.getList()
    }
}
