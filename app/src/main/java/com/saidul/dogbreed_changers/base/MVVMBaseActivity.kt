package com.sundarban.pickndrop.base

import com.saidul.dogbreed_changers.R
import com.saidul.dogbreed_changers.base.BaseActivity


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

    fun showSimpleFailureDialog(title: String, content: String, agree: String) {
//        MaterialDialog.Builder(this)
//                .title(title)
//                .content(content)
//                .positiveText(agree).onPositive { dialog, which ->
//
//                }.show()
    }


    fun showSimpleSuccessDialog(
        title: String,
        content: String,
        agree: String,
        isCancelAble: Boolean = false,
        positiveCallBack: PositiveCallBack
    ) {
//        MaterialDialog.Builder(this)
//                .title(title)
//                .cancelable(isCancelAble)
//                .content(content)
//                .positiveText(agree).onPositive { dialog, which ->
//                    positiveCallBack.onClick()
//                }.show()
    }

    interface PositiveCallBack {
        fun onClick()
    }
}