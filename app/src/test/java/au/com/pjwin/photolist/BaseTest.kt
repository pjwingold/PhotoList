package au.com.pjwin.photolist

import android.support.annotation.CallSuper
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AppTestRunner::class)
@Config(constants = BuildConfig::class, application = TestFactListApp::class)
open class BaseTest {

    @CallSuper
    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)
    }
}