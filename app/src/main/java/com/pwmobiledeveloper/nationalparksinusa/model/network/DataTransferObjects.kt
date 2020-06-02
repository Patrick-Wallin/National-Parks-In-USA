package com.pwmobiledeveloper.nationalparksinusa.model.network

import androidx.room.Relation
import com.pwmobiledeveloper.nationalparksinusa.model.*
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class NetworkParkContainer(val parks: List<NetworkPark>)

/*
@JsonClass(generateAdapter = true)
data class NetworkPark(
    val parkId: Long,
    val id: String,
    val fullName: String,
    val parkCode: String,
    val city: String,
    val states: String,
    val url: String,
    val latLong: String,
    val description: String)
*/
//@JsonClass(generateAdapter = true)
data class NetworkPark(
    val data: List<Data>,
    val limit: String,
    val start: String,
    val total: String
)

data class Data(
    val activities: List<Activity>,
    val addresses: List<Address>,
    val contacts: Contacts,
    val description: String,
    val designation: String,
    val directionsInfo: String,
    val directionsUrl: String,
    val entranceFees: List<EntranceFee>,
    val entrancePasses: List<EntrancePass>,
    val fullName: String,
    val id: String,
    val images: List<Image>,
    val latLong: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val operatingHours: List<OperatingHour>,
    val parkCode: String,
    val states: String,
    val topics: List<Topic>,
    val url: String,
    val weatherInfo: String
)

data class Address(
    val city: String,
    val line1: String,
    val line2: String,
    val line3: String,
    val postalCode: String,
    val stateCode: String,
    val type: String
)

data class Activity(
    val id: String,
    val name: String
)

data class Contacts(
    val emailAddresses: List<EmailAddress>,
    val phoneNumbers: List<PhoneNumber>
)

data class EmailAddress(
    val description: String,
    val emailAddress: String
)

data class PhoneNumber(
    val description: String,
    val extension: String,
    val phoneNumber: String,
    val type: String
)

data class EntranceFee(
    val cost: String,
    val description: String,
    val title: String
)

data class EntrancePass(
    val cost: String,
    val description: String,
    val title: String
)

data class Image(
    val altText: String,
    val caption: String,
    val credit: String,
    val title: String,
    val url: String
)

data class OperatingHour(
    val description: String,
    val exceptions: List<Exception>,
    val name: String,
    val standardHours: StandardHours
)

data class Exception(
    val endDate: String,
    val exceptionHours: ExceptionHours,
    val name: String,
    val startDate: String
)

data class ExceptionHours(
    val friday: String,
    val monday: String,
    val saturday: String,
    val sunday: String,
    val thursday: String,
    val tuesday: String,
    val wednesday: String
)

data class StandardHours(
    val friday: String,
    val monday: String,
    val saturday: String,
    val sunday: String,
    val thursday: String,
    val tuesday: String,
    val wednesday: String
)

data class Topic(
    val id: String,
    val name: String
)

fun NetworkPark.asDomainModel(): List<DomainPark> {
    return data.map {
        DomainPark(
            id = it.id,
            name = it.name,
            addresses = it.addresses
        )
    }
}

fun NetworkPark.asDatabaseModel(): List<ParkWithAllInfo> {
    return data.map {
        val tableEmailAddress = it.contacts.emailAddresses.map {
            TableEmailAddress(email_address_id = 0, park_id = 0, description = it.description, emailAddress = it.emailAddress)
        }

        val tablePhoneNumber = it.contacts.phoneNumbers.map {
            TablePhoneNumber(phone_number_id = 0, park_id = 0, description = it.description, extension = it.extension, phoneNumber = it.phoneNumber, type = it.type)
        }

        // var tableContacts = TableContacts(park_id = 0, contact_id = 0, emailAddresses = tableEmailAddress, phoneNumbers = tablePhoneNumber)

        val tableActivity = it.activities.map {
            TableActivity(activity_id = 0, park_id = 0, id = it.id, name = it.name)
        }

        val tableAddresses = it.addresses.map {
            TableAddress(address_id = 0, park_id = 0, city = it.city, line1 = it.line1, line2 = it.line2, line3 = it.line3, postalCode = it.postalCode, stateCode = it.stateCode, type = it.type)
        }

        val tableEntranceFee = it.entranceFees.map {
            TableEntranceFee(entrancefee_id = 0, park_id = 0, cost = it.cost, description = it.description, title = it.title)
        }

        val tableEntrancePass = it.entrancePasses.map {
            TableEntrancePass(entrancepass_id = 0, park_id = 0, cost = it.cost, description = it.description, title = it.title)
        }

        val tableImage = it.images.map {
            TableImage(image_id = 0, park_id = 0, altText = it.altText, caption = it.caption, credit = it.credit, title = it.title, url = it.url)
        }

        val tableTopic = it.topics.map {
            TableTopic(topic_id = 0, park_id = 0, id = it.id, name = it.name)
        }

        val tableOperatingHour = it.operatingHours.map {
            /*
            val tableExceptions = it.exceptions.map {
                val tableExceptionHours = TableExceptionHours(
                    exceptionhour_id = 0, exception_id = 0, friday = it.exceptionHours.friday, monday = it.exceptionHours.monday,
                    saturday = it.exceptionHours.saturday, sunday = it.exceptionHours.sunday, thursday = it.exceptionHours.thursday, tuesday = it.exceptionHours.tuesday,
                    wednesday = it.exceptionHours.wednesday)
                TableException(exception_id = 0, operatinghour_id = 0, endDate = it.endDate, exceptionHours = tableExceptionHours, name = it.name, startDate = it.startDate)
            }
             */
            val tableStandardHours = TableStandardHours(friday = it.standardHours.friday, monday = it.standardHours.monday,
                saturday = it.standardHours.saturday, sunday = it.standardHours.sunday, thursday = it.standardHours.thursday, tuesday = it.standardHours.tuesday,
                wednesday = it.standardHours.wednesday)

            TableOperatingHour(operatinghour_id = 0, park_id = 0, description = it.description, name = it.name, standardHours = tableStandardHours )
        }

        val tableExceptions = it.operatingHours[0].exceptions.map {
            val tableExceptionHours = TableExceptionHours(
                friday = it.exceptionHours.friday, monday = it.exceptionHours.monday,
                saturday = it.exceptionHours.saturday, sunday = it.exceptionHours.sunday, thursday = it.exceptionHours.thursday, tuesday = it.exceptionHours.tuesday,
                wednesday = it.exceptionHours.wednesday)

            TableException(exception_id = 0, park_id = 0, endDate = it.endDate, exceptionHours = tableExceptionHours, name = it.name, startDate = it.startDate)
        }

        val tablePark: TableParks = TableParks(
            park_id = 0,
            id = it.id,
            fullName = it.fullName,
            name = it.name,
            parkCode = it.parkCode,
            states = it.states,
            url = it.url,
            latitude = it.latitude,
            longitude = it.longitude,
            latLong = it.latLong,
            description = it.description,
            designation = it.designation,
            directionsInfo = it.directionsInfo,
            directionsUrl = it.directionsUrl,
            weatherInfo = it.weatherInfo
        )

        ParkWithAllInfo(
            park = tablePark,
            emailAddresses = tableEmailAddress,
            phoneNumbers = tablePhoneNumber,
            activities = tableActivity,
            entranceFees = tableEntranceFee,
            entrancePasses = tableEntrancePass,
            operatingHours = tableOperatingHour,
            exceptions = tableExceptions,
            topics = tableTopic,
            images = tableImage,
            addresses = tableAddresses
        )
    }
}

