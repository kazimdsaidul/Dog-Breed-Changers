package com.sundarban.pickndrop.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saidul.dogbreed_changers.R
import com.saidul.dogbreed_changers.base.BaseDialogFragment


class NoInternetConnectionMsgDialog(val onClickHandler: OnClickHandler) : BaseDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.no_internet_connection_msg_dialog, null)
//        view.btRetry.setOnClickListener {
//            dismiss()
//            onClickHandler.onRetry();
//
//        }
        isCancelable = false
        return view

    }

    override fun onStart() {
        super.onStart()

        val dialog: Dialog? = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.getWindow()?.setLayout(width, height)
        }
    }

    public interface OnClickHandler {
        public fun onRetry()
    }


}