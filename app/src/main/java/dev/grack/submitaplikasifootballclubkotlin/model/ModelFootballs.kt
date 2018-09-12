package dev.grack.submitaplikasifootballclubkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelFootballs(val name: String,
                          val image: Int?,
                          val description: String) : Parcelable {
}