package com.example.lutluthfi.mvpbasickotlin.data.network

import com.example.lutluthfi.mvpbasickotlin.BuildConfig

object ApiEndPoint {

    // http://belajaryuk.viralio.media/oauth/token
    val ENDPOINT_OAUTH = BuildConfig.BASE_URL + "/oauth/token"

    // http://belajaryuk.viralio.media/api/v1/users/updatePlayerID
    val ENDPOINT_USERS_WITH_PLAYERID = BuildConfig.BASE_URL + "/api/v1/users/updatePlayerID"

    // http://belajaryuk.viralio.media/api/v1/pengajar/updatePlayerID
    val ENDPOINT_LECTURER_WITH_PLAYERID = BuildConfig.BASE_URL + "/api/v1/pengajar/updatePlayerID"

    // http://belajaryuk.viralio.media/api/v1/users
    val ENDPOINT_USERS_WHO_LOGIN = BuildConfig.BASE_URL + "/api/v1/users"

    // http://belajaryuk.viralio.media/api/v1/myprofile
    val ENDPOINT_LECTURER_WHO_LOGIN = BuildConfig.BASE_URL + "/api/v1/pengajar/myprofile"

    // http://belajaryuk.viralio.media/api/v1/berita
    val ENDPOINT_NEWS = BuildConfig.BASE_URL + "/api/v1/berita"

    // http://belajaryuk.viralio.media/api/v1/pengajar
    val ENDPOINT_LECTURER = BuildConfig.BASE_URL + "/api/v1/pengajar"
}