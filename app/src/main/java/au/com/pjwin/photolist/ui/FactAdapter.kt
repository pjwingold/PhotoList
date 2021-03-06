package au.com.pjwin.photolist.ui

import android.content.Context
import au.com.pjwin.commonlib.ui.adapter.RecyclerListAdapter
import au.com.pjwin.commonlib.ui.adapter.RecyclerViewHolder
import au.com.pjwin.photolist.R
import au.com.pjwin.photolist.databinding.FactItemBinding
import au.com.pjwin.photolist.model.Fact
import com.bumptech.glide.Glide

class FactAdapter(private val context: Context, factList: List<Fact>) :
    RecyclerListAdapter<Fact, FactItemBinding, RecyclerViewHolder>(context, factList) {

    override fun layoutId() = R.layout.fact_item

    override fun bindData(binding: FactItemBinding, data: Fact) {
        if (data.title.isNullOrEmpty() && data.description.isNullOrEmpty() && data.imageHref.isNullOrEmpty()) {
            return
        }
        binding.fact = data

        Glide.with(context)
            .load(data.imageHref)
            //todo add placeholder
            //.apply(RequestOptions().placeholder())
            .into(binding.image)
    }
}