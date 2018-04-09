package com.example.lutluthfi.mvpbasickotlin.data.network

import com.example.lutluthfi.mvpbasickotlin.data.network.model.BeritaResponse
import io.reactivex.Observable

interface ApiHelper {

    // http://belajaryuk.viralio.media/api/v1/berita?page={page}
    fun getNewsByPage(page: Int): Observable<BeritaResponse.Beritas>

    // http://belajaryuk.viralio.media/api/v1/berita/{id}
    fun getNewsById(id: String): Observable<BeritaResponse.Berita>
}