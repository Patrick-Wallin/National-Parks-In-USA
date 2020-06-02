package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableTopic

@Dao
interface TopicsDao {
    @Insert
    fun insert(topic: TableTopic) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(topics: List<TableTopic>) {

    }

    @Update
    fun update(topic: TableTopic)

    @Query("DELETE FROM topics")
    fun clear()

    @Query("SELECT * FROM topics WHERE park_id = :parkId")
    fun getTopics(parkId: Long): TableTopic?
}