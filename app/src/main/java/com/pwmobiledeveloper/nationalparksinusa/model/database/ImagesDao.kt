package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableImage

@Dao
interface ImagesDao {
    @Insert
    fun insert(image: TableImage) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(image: List<TableImage>) {

    }

    @Update
    fun update(image: TableImage)

    @Query("DELETE FROM images")
    fun clear()

    @Query("SELECT * FROM images WHERE park_id = :parkId")
    fun getImages(parkId: Long): TableImage?
}