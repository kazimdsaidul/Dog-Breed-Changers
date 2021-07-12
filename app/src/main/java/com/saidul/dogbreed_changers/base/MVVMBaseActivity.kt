package com.saidul.dogbreed_changers.base

import com.saidul.dogbreed_changers.R


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 5/18/21.
 */
open class MVVMBaseActivity : BaseActivity() {

    lateinit var mViewModel: BaseViewModel


    fun setupCommonViewModel(viewModel: Any) {
        mViewModel = viewModel as BaseViewModel
    }

    fun setupCommonUIState() {
        mViewModel.processBarUILiveData.observe(this, {
            if (it) {
                showProgressDialog()
            } else {
                dismissProgressDialog()
            }
        })
        mViewModel.noInternetUILiveData.observe(this, {
            // ApplicationData.showAlertForInternet(this)
        })

        mViewModel.mShowErrorMessageToUser.observe(this, {
            showSimpleFailureDialog(getString(R.string.failed), it, getString(R.string.try_again))
        })


    }

    private fun showSimpleFailureDialog(title: String, content: String, agree: String) {
//        MaterialDialog.Builder(this)
//                .title(title)
//                .content(content)
//                .positiveText(agree).onPositive { dialog, which ->
//
//                }.show()
    }


    interface PositiveCallBack {
        fun onClick()
    }
}