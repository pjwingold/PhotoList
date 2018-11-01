package au.com.pjwin.photolist.viewmodel

import au.com.pjwin.photolist.BaseTest
import au.com.pjwin.photolist.model.FactResponse
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito
import org.mockito.Spy

class FactViewModelTest : BaseTest() {

    @Spy
    private lateinit var factViewModel: FactViewModel

    @Captor
    private lateinit var responseCaptor: ArgumentCaptor<FactResponse>

    @Test
    fun getFacts() {
        factViewModel.getFacts()

        Mockito.verify(factViewModel).onData(responseCaptor.capture())
    }
}