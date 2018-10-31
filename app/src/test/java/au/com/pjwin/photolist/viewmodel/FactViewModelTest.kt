package au.com.pjwin.photolist.viewmodel

import au.com.pjwin.photolist.BaseTest
import org.junit.Test
import org.mockito.Spy

class FactViewModelTest : BaseTest() {

    @Spy
    private lateinit var factViewModel: FactViewModel

    @Test
    fun getFacts() {
        factViewModel.getFacts(true)
    }
}