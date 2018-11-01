package au.com.pjwin.photolist.ui

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import au.com.pjwin.commonlib.ui.BaseFragment
import au.com.pjwin.commonlib.util.Util
import au.com.pjwin.photolist.R
import au.com.pjwin.photolist.databinding.FragmentFactListBinding
import au.com.pjwin.photolist.model.Fact
import au.com.pjwin.photolist.model.FactResponse
import au.com.pjwin.photolist.viewmodel.FactViewModel

class FactFragment : BaseFragment<FactResponse, FactViewModel, FragmentFactListBinding>() {

    private var listData = ArrayList<Fact>()
    private lateinit var factAdapter: FactAdapter

    override fun layoutId() = R.layout.fragment_fact_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.getFacts()
        }

        binding.apply {
            factList.apply {
                val layoutManager = LinearLayoutManager(Util.context())
                this.layoutManager = layoutManager
                addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
                setHasFixedSize(true)
                factAdapter = FactAdapter(context!!, listData)
                binding.factList.adapter = factAdapter
            }
        }
    }

    override fun onData(data: FactResponse?) {
        data?.let {
            setPageTitle(it.title)
            factAdapter.list = it.rows
        }
    }

    override fun onError(throwable: Throwable?) {
        super.onError(throwable)
        //todo show proper error
        Toast.makeText(Util.context(), "cannot load data", Toast.LENGTH_SHORT).show()
    }

    fun performRefresh(force: Boolean) {
        viewModel.getFacts(force)
    }
}