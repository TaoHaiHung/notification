package com.example.notisave.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.notisave.model.NotificationEntity

@Dao
interface NotificationDao {
    @Insert
    suspend fun insertNotification(notification: NotificationEntity)

    @Query("SELECT * FROM notifications")
    fun getAllNotifications(): LiveData<List<NotificationEntity>>
}
