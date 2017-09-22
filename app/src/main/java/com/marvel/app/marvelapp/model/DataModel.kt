package com.marvel.app.marvelapp.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Marcin Pogorzelski on 21/09/2017.
 */
data class DataModel (
        val name: String,
        val photo: String,
        val realName: String,
        val height : String,
        val power : String,
        val abilities : String,
        val groups : String

): Parcelable{

    //Source https://medium.com/@BladeCoder/reducing-parcelable-boilerplate-code-using-kotlin-741c3124a49a

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<DataModel> {

            override fun createFromParcel(parcel: Parcel): DataModel {
                return DataModel(parcel)
            }

            override fun newArray(size: Int): Array<DataModel?> {
                return arrayOfNulls(size)
            }
        }
    }

    constructor(source: Parcel) : this(
            name = source.readString(),
            photo = source.readString(),
            realName = source.readString(),
            height = source.readString(),
            power = source.readString(),
            abilities = source.readString(),
            groups = source.readString()
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(photo)
        dest?.writeString(realName)
        dest?.writeString(height)
        dest?.writeString(power)
        dest?.writeString(abilities)
        dest?.writeString(groups)
    }

    override fun describeContents(): Int {
        return 0
    }

}
