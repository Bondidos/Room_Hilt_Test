package com.bondidos.roomhilttest

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Di {

    @Provides
    fun provideMainViewModel(repo: Repository): ViewModel = LoginViewModelFactory(repo).create(MainViewModel::class.java)

    @Singleton
    @Provides
    fun provideRepo(room: RoomDao) : Repository = Repository(room)

    @Provides
    fun provideRoomDao(database:AppDatabase): RoomDao = database.getBase()


    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "name"
    ).build()

}