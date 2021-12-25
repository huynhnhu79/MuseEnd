package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.model.Message;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    public void insert(Message... items);
    @Update
    public void update(Message... items);
    @Delete
    public void delete(Message item);

    @Query("SELECT * FROM items")
    public List<Message> getItems();



}