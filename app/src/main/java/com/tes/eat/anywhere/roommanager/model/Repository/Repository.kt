package com.tes.eat.anywhere.roommanager.model.Repository

import com.tes.eat.anywhere.roommanager.model.data.news.News
import com.tes.eat.anywhere.roommanager.model.data.people.People
import com.tes.eat.anywhere.roommanager.model.data.room.Room
import retrofit2.Response


/*
* */
interface Repository {
    suspend fun  getPeople():Response<People>

    suspend fun  getRoom(): Response<Room>

    suspend fun  getNews():Response<News>

}