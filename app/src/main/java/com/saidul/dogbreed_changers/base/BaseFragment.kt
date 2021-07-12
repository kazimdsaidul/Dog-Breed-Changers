package com.saidul.dogbreed_changers.base

import androidx.fragment.app.Fragment


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 5/11/21.
 */
open class BaseFragment : Fragment() {
    lateinit var mViewModel: BaseViewModel


    fun setupCommonViewModel(viewModel: Any) {
        mViewModel = viewModel as BaseViewModel
    }

//    fun setupCommonUIState() {
//        mViewModel.processBarUILiveData.observe(viewLifecycleOwner, {
//            if (it) {
//                val activity = activity as ParcelHistoryActivity
//                activity.showProgressDialog()
//            } else {
//                val activity = activity as ParcelHistoryActivity
//                activity.dismissProgressDialog()
//            }
//        })
//
//        mViewModel.noInternetUILiveData.observe(viewLifecycleOwner, {
//            val activity = activity as ParcelHistoryActivity
//            ApplicationData.showAlertForInternet(activity)
//        })
//
//    }
}