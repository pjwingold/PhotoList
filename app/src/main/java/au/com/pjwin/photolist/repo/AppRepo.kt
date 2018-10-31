package au.com.pjwin.photolist.repo

import au.com.pjwin.commonlib.repo.retrofit.RetrofitRepo

object AppRepo {

    fun loadFacts(): FactService = RetrofitRepo.RETROFIT_OPEN_AUTH.create(FactService::class.java)
}