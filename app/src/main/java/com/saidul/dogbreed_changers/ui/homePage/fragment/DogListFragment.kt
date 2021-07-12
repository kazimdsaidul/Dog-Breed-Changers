package com.saidul.dogbreed_changers.ui.homePage.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.saidul.dogbreed_changers.R
import com.saidul.dogbreed_changers.base.BaseFragment
import com.saidul.dogbreed_changers.ui.homePage.DogMainActivity
import com.saidul.dogbreed_changers.ui.homePage.adapter.ImagesAdapter
import com.saidul.dogbreed_changers.ui.homePage.adapter.PHDataLoadStateAdapter
import com.saidul.dogbreed_changers.ui.homePage.viewmodel.DogPageViewModel
import kotlinx.android.synthetic.main.fragment_dog_list.view.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class DogListFragment : BaseFragment(), LifecycleOwner, AdapterView.OnItemClickListener {

    lateinit var myViewModel: DogPageViewModel
    private lateinit var mImagesAdapter: ImagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dog_list, container, false)
        myViewModel = ViewModelProvider(requireActivity()).get(DogPageViewModel::class.java)

        initilzationView(view)
        setupUpPagingErrorState(view)
        setupCommonViewModel(myViewModel)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initiOwnViewState()
    }


    private fun initiOwnViewState() {
        myViewModel.showMessageToUser.observe(viewLifecycleOwner, {
            val activity = activity as DogMainActivity
            activity.showToastMessage(it)
        })


        myViewModel.mBreedsItem.observe(viewLifecycleOwner, {
            if (myViewModel.mBreedsItem.value != null) {
                myViewModel.imagePagingSource?.invalidate()

                lifecycleScope.launch {
                    myViewModel.imageData.collectLatest {
                        mImagesAdapter.submitData(it)
                    }
                }
            }
        })


    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


    }

    private fun initilzationView(view: View) {
        setupAdapter(view)


        view.btnRetry.setOnClickListener {
            mImagesAdapter.retry()
        }
    }

    private fun setupAdapter(view: View) {
        mImagesAdapter = ImagesAdapter(requireContext())

        view.movie_recycler.apply {
//            layoutManager = LinearLayoutManager(requireActivity())
            val mLayoutManager = GridLayoutManager(requireActivity(), 3)
            layoutManager = mLayoutManager
            setHasFixedSize(true)
            adapter = mImagesAdapter.withLoadStateFooter(
                footer = PHDataLoadStateAdapter { mImagesAdapter.retry() }
            )
        }
    }

    private fun setupUpPagingErrorState(view: View) {
        mImagesAdapter.addLoadStateListener { loadState ->

            if (loadState.refresh is LoadState.Loading) {
                view.btnRetry.visibility = View.GONE
                view.progressBar.visibility = View.VISIBLE
            } else if (loadState.append.endOfPaginationReached && mImagesAdapter.itemCount < 1) {
                Log.e("", "NO data fond")
                view.progressBar.visibility = View.GONE
                view.tvNoDataFound.visibility = View.VISIBLE
            } else {
                // Hide ProgressBar
                view.progressBar.visibility = View.GONE

                // If we have an error, show a toast
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> {
                        view.btnRetry.visibility = View.VISIBLE
                        loadState.refresh as LoadState.Error
                    }
                    else -> null
                }
                errorState?.let {
                    //                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}