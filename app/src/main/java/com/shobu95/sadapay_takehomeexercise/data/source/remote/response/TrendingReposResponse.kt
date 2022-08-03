package com.shobu95.sadapay_takehomeexercise.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo

data class TrendingReposResponse(
    @SerializedName("items") val items: List<GithubRepo> = emptyList(),
)
