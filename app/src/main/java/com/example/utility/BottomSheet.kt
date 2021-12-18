package com.example.utility

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.movie.R
import com.example.movie.databinding.MovieBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*
import javax.inject.Inject

class BottomSheet @Inject constructor() {
    private var bottomSheetContext: Context? = null
    @Inject
    lateinit var binding: MovieBottomSheetBinding
    private var sheetView: View? = null
    private var bottomSheetDialog: BottomSheetDialog? = null
    private var textView: TextView? = null
    fun init(context: Context) {
        this.bottomSheetContext = context

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.movie_bottom_sheet,
            null,
            false
        )

        show()


    }

    fun onClick() {

        binding.tvGeneric.setOnClickListener { it ->
selectPayList()

        }
    }

    fun show() {
        bottomSheetDialog = BottomSheetDialog(bottomSheetContext!!)
        bottomSheetDialog?.setContentView(binding.root!!)
        bottomSheetDialog?.show()


    }
     fun selectPayList()
     {

     }

    fun cancel() {

        sheetView?.findViewById<View>(R.id.button_cancel)?.setOnClickListener {

            bottomSheetDialog?.cancel()
        }
    }
}
