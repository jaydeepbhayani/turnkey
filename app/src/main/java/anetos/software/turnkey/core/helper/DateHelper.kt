package anetos.software.turnkey.core.helper

import android.annotation.SuppressLint
import androidx.core.util.Preconditions
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * DateHelper class for api data used in retrofit
 *
 *  created by jaydeepbhayani on 19/06/2020
 */


//const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val DATE_PATTERN = "dd-MMM-yyyy"
const val TIME_PATTERN = "HH:mm"
const val API_DATE_PATTERN = "MM-dd-yyyy"
const val API_TIME_PATTERN = "HH:mm:ssz"
const val DATE_PATTERN_2 = "yyyy-MM-dd"
const val DATE_PATTERN_ORDINAL = "MMM"

//const val FORECAST_RECORD_TIME_PATTERN = "ddMMMyyyy HHmm z"
const val FORECAST_RECORD_DATE_PATTERN = "ddMMMyyyy"

val API_TIME_FORMAT = SimpleDateFormat(API_TIME_PATTERN, Locale.ENGLISH)
val API_DATE_FORMAT = SimpleDateFormat(API_DATE_PATTERN, Locale.ENGLISH)
val DATE_FORMAT_2 = SimpleDateFormat(DATE_PATTERN_2, Locale.ENGLISH)
val DATE_FORMAT_ORDINAL = SimpleDateFormat(DATE_PATTERN_ORDINAL, Locale.ENGLISH)

fun String.getForecastDate(): String? {
    val apiFormat = SimpleDateFormat(FORECAST_RECORD_DATE_PATTERN, Locale.ENGLISH)
    val convertedFormat = SimpleDateFormat(DATE_PATTERN, Locale.ENGLISH)
    val date = apiFormat.parse(this)
    return try {
        convertedFormat.format(date!!)
    } catch (e: ParseException) {
        null
    }
}

fun String.getApiTime(): Date? {
    API_TIME_FORMAT.timeZone = TimeZone.getDefault()
    return try {
        API_TIME_FORMAT.parse(this)
    } catch (e: ParseException) {
        null
    }
}

fun yesterday(): Date {
    val cal = Calendar.getInstance()
    cal.add(Calendar.DATE, -1)
    return cal.time
}

fun String.after8Hours(): String? {
    return try {
        val simpleDateFormat = SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.ENGLISH)
        val cal = Calendar.getInstance()
        cal.time = simpleDateFormat.parse(this)!!
        cal.add(Calendar.HOUR, 12)
        simpleDateFormat.format(cal.time)

    } catch (e: Exception) {
        null
    }
}

fun Date.getApiStringDate(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone("GMT")
    return dateFormat.format(this)
}

fun Date.getApiStringDate(): String {
    val dateFormat = SimpleDateFormat(API_DATE_PATTERN, Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone("GMT")
    return dateFormat.format(this)
}

fun String.getLastMin(): String? {
    val cal = getRoundOffTime()
    cal.time = this.getApiTime()!!
    cal.add(Calendar.MINUTE, -15)
    return API_TIME_FORMAT.format(cal.time).replace("GMT", "")
}

fun String.getTimeFormatMin(): String? {
    val cal = getRoundOffTime()
    cal.time = this.getApiTime()!!
    return TIME_PATTERN.format(cal.time)
}

fun String.getLastHour(): String? {
    val cal = getRoundOffTime()
    cal.time = this.getApiTime()!!
    cal.add(Calendar.HOUR, -1)
    return API_TIME_FORMAT.format(cal.time).replace("GMT", "")
}

fun String.getLastDay(): String? {
    val cal = getRoundOffTime()
    cal.time = this.getApiTime()!!
    cal.add(Calendar.HOUR, -24)
    return API_TIME_FORMAT.format(cal.time).replace("GMT", "")
}

private fun getRoundOffTime(): Calendar {
    val now = Calendar.getInstance()
    now.set(Calendar.SECOND, 0)
    val mod = now.get(Calendar.MINUTE) % 15
    now.add(Calendar.MINUTE, if (mod < 8) -mod else 15 - mod)
    return now
}

/*
* this function gets the ordinal day's number like, 1st, 12th
* */
@SuppressLint("RestrictedApi")
fun getDayOfMonthSuffix(day: Int): String {
    Preconditions.checkArgument(day >= 1 && day <= 31, "illegal day of month: $day")
    if (day >= 11 && day <= 13) {
        return "th"
    }
    when (day % 10) {
        1 -> return "st"
        2 -> return "nd"
        3 -> return "rd"
        else -> return "th"
    }
}

@SuppressLint("RestrictedApi")
public fun getDayOfMonthSuffix(date: String): String {
    val day = date.split("-")[2].toInt()

    val currentTime = DATE_FORMAT_ORDINAL.format(DATE_FORMAT_2.parse(date)!!)

    Preconditions.checkArgument(day >= 1 && day <= 31, "illegal day of month: $day")
    if (day >= 11 && day <= 13) {
        return day.toString() + "th " + currentTime
    }
    when (day % 10) {
        1 -> return day.toString() + "st " + currentTime
        2 -> return day.toString() + "nd " + currentTime
        3 -> return day.toString() + "rd " + currentTime
        else -> return day.toString() + "th " + currentTime
    }
}


fun getDayMonthPrefix(day: Int): String {
    //Preconditions.checkArgument(day >= 1 && day <= 9, "illegal day of month: $day")
    if (day >= 1 && day <= 9) {
        return "0" + day
    } else {
        return day.toString()
    }
}
