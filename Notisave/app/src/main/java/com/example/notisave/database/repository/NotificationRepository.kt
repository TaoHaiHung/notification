package com.example.notisave.database.repository

import androidx.lifecycle.LiveData
import com.example.notisave.database.dao.NotificationDao
import com.example.notisave.model.NotificationEntity

class NotificationRepository(private val notificationDao: NotificationDao) {
    suspend fun insertNotification(notification: NotificationEntity) {
        notificationDao.insertNotification(notification)
    }

    fun getAllNotifications(): LiveData<List<NotificationEntity>> {
        return notificationDao.getAllNotifications()
    }
}
