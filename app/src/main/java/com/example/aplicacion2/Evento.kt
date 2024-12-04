package com.example.aplicacion2

import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class Evento(
    val name: String,
    val description: String,
    val address: String,
    val price: String,
    val date: String,
    val capacity: String,
    val imageUri: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(address)
        parcel.writeString(price)
        parcel.writeString(date)
        parcel.writeString(capacity)
        parcel.writeString(imageUri)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Evento> {
        override fun createFromParcel(parcel: Parcel): Evento {
            return Evento(parcel)
        }

        override fun newArray(size: Int): Array<Evento?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize