package au.com.pjwin.photolist.repo

import au.com.pjwin.photolist.model.FactResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface FactService {

    @GET("facts.json")
    fun getFacts(@Header("refresh") vararg force: Boolean): Call<FactResponse>
}