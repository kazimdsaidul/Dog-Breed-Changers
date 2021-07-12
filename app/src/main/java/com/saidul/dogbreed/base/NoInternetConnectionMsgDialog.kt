package com.saidul.dogbreed.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saidul.dogbreed.R


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
            dialog.window?.setLayout(width, height)
        }
    }

    interface OnClickHandler {
        fun onRetry()
    }


}