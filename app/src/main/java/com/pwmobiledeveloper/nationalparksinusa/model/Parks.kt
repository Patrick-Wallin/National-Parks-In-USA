package com.pwmobiledeveloper.nationalparksinusa.model

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.network.Address

@Entity(tableName = "parks")
data class TableParks(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "park_id")
    val park_id: Long,
    @ColumnInfo(name = "id")
    val id: String = "",
    @ColumnInfo(name = "full_name")
    val fullName: String = "",
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "park_code")
    val parkCode: String = "",
    @ColumnInfo(name = "states")
    val states: String = "",
    @ColumnInfo(name = "url")
    val url: String = "",
    @ColumnInfo(name = "latitude")
    val latitude: String = "",
    @ColumnInfo(name = "longitude")
    val longitude: String = "",
    @ColumnInfo(name = "lat_long")
    val latLong: String = "",
    @ColumnInfo(name = "description")
    val description: String = "",
    @ColumnInfo(name = "designation")
    val designation: String = "",
    @ColumnInfo(name = "directions_info")
    val directionsInfo: String = "",
    @ColumnInfo(name = "directions_url")
    val directionsUrl: String = "",
    @ColumnInfo(name = "weather_info")
    val weatherInfo: String = ""
    /*
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val emailAddresses: List<TableEmailAddress>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val phoneNumbers: List<TablePhoneNumber>,
    /*
    val contacts: TableContacts,
     */
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val activities: List<TableActivity>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val entranceFees: List<TableEntranceFee>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val entrancePasses: List<TableEntrancePass>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val operatingHours: List<TableOperatingHour>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val exceptions: List<TableException>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val topics: List<TableTopic>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val images: List<TableImage>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val addresses: List<TableAddress>
    */

)

@Entity(tableName = "email_addresses")
data class TableEmailAddress(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "email_address_id")
    val email_address_id: Long,
    //val contact_id: Long,
    var park_id: Long = 0L,
    var description: String = "",
    var emailAddress: String = ""
)

@Entity(tableName = "phone_numbers")
data class TablePhoneNumber(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "phone_number_id")
    val phone_number_id: Long,
    //val contact_id: Long,
    var park_id: Long = 0L,
    var description: String = "",
    var extension: String = "",
    var phoneNumber: String = "",
    var type: String = ""
)

@Entity(tableName = "addresses")
data class TableAddress(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "address_id")
    val address_id: Long,
    var park_id: Long = 0L,
    var city: String = "",
    var line1: String = "",
    var line2: String = "",
    var line3: String = "",
    var postalCode: String = "",
    var stateCode: String = "",
    var type: String = ""
)

@Entity(tableName = "activities")
data class TableActivity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "activity_id")
    val activity_id: Long,
    var park_id: Long = 0L,
    var id: String = "",
    var name: String = ""
)

@Entity(tableName = "entrancefees")
data class TableEntranceFee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "entrancefee_id")
    val entrancefee_id: Long,
    var park_id: Long = 0L,
    var cost: String = "",
    var description: String = "",
    var title: String = ""
)

@Entity(tableName = "entrancepasses")
data class TableEntrancePass(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "entrancepass_id")
    val entrancepass_id: Long,
    var park_id: Long = 0L,
    var cost: String = "",
    var description: String = "",
    var title: String = ""
)

@Entity(tableName = "images")
data class TableImage(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "image_id")
    val image_id: Long,
    var park_id: Long = 0L,
    var altText: String = "",
    var caption: String = "",
    var credit: String = "",
    var title: String = "",
    var url: String = ""
)

@Entity(tableName = "topics")
data class TableTopic(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "topic_id")
    val topic_id: Long,
    var park_id: Long = 0L,
    var id: String = "",
    var name: String = ""
)

@Entity(tableName = "operatinghours")
data class TableOperatingHour(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "operatinghour_id")
    val operatinghour_id: Long,
    var park_id: Long = 0L,
    var description: String = "",
    /*
    @Relation(
        parentColumn = "operatinghour_id",
        entityColumn = "operatinghour_id"
    )
    val exceptions: List<TableException>,
     */
    var name: String = "",
    /*
    @Relation(
        parentColumn = "operatinghour_id",
        entityColumn = "operatinghour_id"
    )

     */
    @Embedded
    val standardHours: TableStandardHours
)

@Entity(tableName = "exceptions")
data class TableException(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exception_id")
    val exception_id: Long,
    //val operatinghour_id: Long,
    var park_id: Long = 0L,
    var endDate: String = "",
    /*
    @Relation(
        parentColumn = "exception_id",
        entityColumn = "exception_id"
    */
    @Embedded
    val exceptionHours: TableExceptionHours,
    var name: String = "",
    var startDate: String = ""
)

//@Entity(tableName = "exceptionhours")
data class TableExceptionHours(
    //@PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name = "exceptionhour_id")
    //val exceptionhour_id: Long = 0L,
    //val exception_id: Long,
    var friday: String = "",
    var monday: String = "",
    var saturday: String = "",
    var sunday: String = "",
    var thursday: String = "",
    var tuesday: String = "",
    var wednesday: String = ""
)

//@Entity(tableName = "standardhours")
data class TableStandardHours(
    //@PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name = "standardhour_id")
    //val standardhour_id: Long = 0L,
    //val operatinghour_id: Long,
    var friday: String = "",
    var monday: String = "",
    var saturday: String = "",
    var sunday: String = "",
    var thursday: String = "",
    var tuesday: String = "",
    var wednesday: String = ""
)

data class ParkWithAddresses(
    @Embedded val park: TableParks,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val addresses: List<TableAddress>
)

/*
data class ParkWithAddresses(
    @Embedded val park: TableParks,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id"
    )
    val addresses: List<TableAddress>
)
*/
data class ParkWithAllInfo(
    @Embedded val park: TableParks,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val emailAddresses: List<TableEmailAddress>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val phoneNumbers: List<TablePhoneNumber>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val activities: List<TableActivity>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val entranceFees: List<TableEntranceFee>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val entrancePasses: List<TableEntrancePass>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val operatingHours: List<TableOperatingHour>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val exceptions: List<TableException>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val topics: List<TableTopic>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val images: List<TableImage>,
    @Relation(
        parentColumn = "park_id",
        entityColumn = "park_id",
        entity = TableParks::class
    )
    val addresses: List<TableAddress>
)

data class DomainPark(val id: String,
                        val name: String,
                        val addresses: List<Address>) {
    private val physicalLocation
        get() = addresses.find { it.type == "physical" }
}

fun List<ParkWithAddresses>.asDomainModel(): List<DomainPark> {
    return map {
        DomainPark(
            id = it.park.id,
            name = it.park.name,
            addresses = it.addresses.map {
                Address(it.city,it.line1,it.line2, it.line3, it.postalCode, it.stateCode, it.type)
            }
        )
    }
}

