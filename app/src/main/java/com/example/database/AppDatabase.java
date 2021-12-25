package com.example.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.model.Message;

@Database(entities = {Message.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO getItemDAO();
}