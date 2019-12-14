package unideb.hu.fakebookc7zvm2.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val id: String,
    val title: String,
    val body: String
) : Parcelable