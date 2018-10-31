package au.com.pjwin.photolist.ui

import android.os.Bundle
import au.com.pjwin.commonlib.ui.BaseFragment
import au.com.pjwin.commonlib.ui.SwipeRefreshActivity
import au.com.pjwin.commonlib.ui.ViewActivity

class MainActivity : ViewActivity(), SwipeRefreshActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            showFragment(FactFragment())
        }
    }

    override fun performRefresh(force: Boolean) {
        val fragment = getExistingFragment<BaseFragment<*, *, *>>()

        if (fragment is FactFragment) {
            fragment.performRefresh(force)
        }
    }
}
