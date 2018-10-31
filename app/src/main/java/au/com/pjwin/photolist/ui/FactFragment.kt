package au.com.pjwin.photolist.ui

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import au.com.pjwin.commonlib.ui.BaseActivity
import au.com.pjwin.commonlib.ui.BaseFragment
import au.com.pjwin.commonlib.ui.SwipeRefreshActivity
import au.com.pjwin.commonlib.util.Util
import au.com.pjwin.photolist.R
import au.com.pjwin.photolist.databinding.FragmentFactListBinding
import au.com.pjwin.photolist.model.FactResponse
import au.com.pjwin.photolist.viewmodel.FactViewModel

class FactFragment : BaseFragment<FactResponse, FactViewModel, FragmentFactListBinding>() {

    override fun layoutId() = R.layout.fragment_fact_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFacts()
        binding.apply {
            factList.apply {
                val layoutManager = LinearLayoutManager(Util.context())
                this.layoutManager = layoutManager
                addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
                setHasFixedSize(true)
            }
        }
    }

    override fun onData(data: FactResponse?) {
        data?.let {
            setPageTitle(data.title)
            binding.factList.adapter = FactAdapter(context!!, it)//with LiveData should be safe
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