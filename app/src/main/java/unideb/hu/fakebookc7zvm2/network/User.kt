package unideb.hu.fakebookc7zvm2.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: String,
    val name: String,
    val username: String
    ) : Parcelable