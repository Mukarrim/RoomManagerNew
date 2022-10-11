package com.tes.eat.anywhere.roommanager.di


import com.tes.eat.anywhere.roommanager.model.Repository.Repository
import com.tes.eat.anywhere.roommanager.model.Repository.RepositoryImpl
import com.tes.eat.anywhere.roommanager.model.remote.news.NewsApi
import com.tes.eat.anywhere.roommanager.model.remote.news.NewsApiDetails
import com.tes.eat.anywhere.roommanager.model.remote.virginmoney.EmployeeApi
import com.tes.eat.anywhere.roommanager.model.remote.virginmoney.PeopleApiDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module // to define the definition of  depoendancy injection
@InstallIn(SingletonComponent::class) //to define the scope of dependancy injection
class AppModule {
    //define all the dependancies you will use
    @Provides
    //provide the retrofit instance
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(PeopleApiDetails.BASE_URL)
        .build()

    @Provides
    //to provide the API instance references in code use
    fun provideEmployeeApiAPI(retrofit: Retrofit): EmployeeApi =
        retrofit.create(EmployeeApi::class.java)

    @Provides
    //to provide the API instance references in code use
    fun provideNewsAPI(retrofit: Retrofit): NewsApi = retrofit.newBuilder()
        .baseUrl(NewsApiDetails.BASE_URL)
        .build().create(NewsApi::class.java)

    @Provides
    fun provideRepository(employeeApi: EmployeeApi, newsApi: NewsApi
    ): Repository {
        return RepositoryImpl(
            employeeApi, newsApi
        )
    }
}

/*

    @Provides
    //to provide the API instance references in code use
    fun provideNewsAPI(retrofit: Retrofit): NewsApi {
    return retrofit.newBuilder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(NewsApiDetails.BASE_URL)
    .build().create(NewsApi::class.java)
}
 */