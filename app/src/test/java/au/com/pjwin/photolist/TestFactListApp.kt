package au.com.pjwin.photolist

import au.com.pjwin.commonlib.Common
import au.com.pjwin.photolist.util.CommonConfig

class TestFactListApp : FactListApp() {

    override fun initCommon() {
        //todo TestCommonConfig
        Common.init(applicationContext, CommonConfig(), true)
    }
}