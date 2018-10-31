package au.com.pjwin.photolist.viewmodel

import au.com.pjwin.commonlib.viewmodel.retrofit.RetrofitDataViewModel
import au.com.pjwin.photolist.model.FactResponse
import au.com.pjwin.photolist.repo.AppRepo

open class FactViewModel : RetrofitDataViewModel<FactResponse>() {

    fun getFacts(vararg force: Boolean) {
        enqueue(AppRepo.loadFacts().getFacts(*force), this::onData)
    }
}