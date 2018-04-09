package com.example.lutluthfi.mvpbasickotlin.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// Use the keyword data to make this class is only use as model auto generate setter and getter
class BeritaResponse {
    data class Beritas(@SerializedName("data") @Expose var data: List<Berita>? = null) : Serializable
    data class Berita(@SerializedName("id") @Expose var id: Int? = null,
                      @SerializedName("judul") @Expose var judul: String? = null,
                      @SerializedName("foto") @Expose var foto: String? = null,
                      @SerializedName("konten") @Expose var konten: String? = null,
                      @SerializedName("sumber") @Expose var sumber: String? = null,
                      @SerializedName("created_at") @Expose var created_at: String? = null) : Serializable
}