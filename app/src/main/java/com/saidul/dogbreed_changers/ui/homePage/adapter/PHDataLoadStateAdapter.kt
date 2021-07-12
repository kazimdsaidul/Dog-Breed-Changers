package com.saidul.dogbreed_changers.ui.homePage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saidul.dogbreed_changers.R
import kotlinx.android.synthetic.main.load_state_view.view.*

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/13/21.
 */
class PHDataLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<PHDataLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        val progress = holder.view.load_state_progress
        val btnRetry = holder.view.load_state_retry
        val txtErrorMessage = holder.view.load_state_errorMessage


        btnRetry.isVisible = loadState !is LoadState.Loading
        txtErrorMessage.isVisible = loadState !is LoadState.Loading
        progress.isVisible = loadState is LoadState.Loading

        if (loadState is LoadState.Error) {
            txtErrorMessage.text = loadState.error.localizedMessage
        }

        btnRetry.setOnClickListener {
            retry.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.load_state_view, parent, false)

        return LoadStateViewHolder(view)
    }

    class LoadStateViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}