package com.example.notisave.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notisave.database.AppDatabase
import com.example.notisave.model.NotificationEntity
import com.example.notisave.database.repository.NotificationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NotificationRepository
    val allNotifications: LiveData<List<NotificationEntity>>

    init {
        val notificationDao = AppDatabase.getDatabase(application).notificationDao()
        repository = NotificationRepository(notificationDao)
        allNotifications = repository.getAllNotifications()
    }

    fun insertNotification(notification: NotificationEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNotification(notification)
        }
    }
}
