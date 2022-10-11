package com.tes.eat.anywhere.roommanager.model.repository

import com.tes.eat.anywhere.roommanager.model.remote.news.NewsApi
import com.tes.eat.anywhere.roommanager.model.remote.virginmoney.EmployeeApi
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val employeeApi: EmployeeApi,
    private val newsApi: NewsApi
) : Repository {
    override suspend fun getPeople() = employeeApi.getPeople()
    override suspend fun getRoom() = employeeApi.getRoom()
    override suspend fun getNews() = newsApi.getNews()
}