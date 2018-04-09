package com.example.lutluthfi.mvpbasickotlin.data.network

import com.example.lutluthfi.mvpbasickotlin.data.network.model.BeritaResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable

class AppApiHelper : ApiHelper {

    override fun getNewsByPage(page: Int): Observable<BeritaResponse.Beritas> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_NEWS)
                    .addPathParameter("page", page.toString())
                    .build().getObjectObservable(BeritaResponse.Beritas::class.java)

    override fun getNewsById(id: String): Observable<BeritaResponse.Berita> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_NEWS)
                    .addQueryParameter("id", id)
                    .build().getObjectObservable(BeritaResponse.Berita::class.java)
}