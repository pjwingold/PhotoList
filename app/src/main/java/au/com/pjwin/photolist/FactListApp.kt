package au.com.pjwin.photolist

import android.app.Application
import au.com.pjwin.commonlib.Common
import au.com.pjwin.photolist.util.CommonConfig

open class FactListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initCommon()
    }

    protected open fun initCommon() {
        Common.init(applicationContext, CommonConfig(), false)
    }
}