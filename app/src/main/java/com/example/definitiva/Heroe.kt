package com.example.definitiva

import android.os.Parcel
import android.os.Parcelable

data class Heroe(
    val nombre: String,
    val nivel: Int,
    val vida: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(nivel)
        parcel.writeInt(vida)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Heroe> {
        override fun createFromParcel(parcel: Parcel): Heroe {
            return Heroe(parcel)
        }

        override fun newArray(size: Int): Array<Heroe?> {
            return arrayOfNulls(size)
        }
    }
}