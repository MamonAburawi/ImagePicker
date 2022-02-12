package com.imagepicker.info

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.net.toFile
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.imagepicker.info.databinding.ActivityMainBinding
import com.imagepicker.info.databinding.ItemImageBinding
import gun0912.tedimagepicker.builder.TedImagePicker
import gun0912.tedimagepicker.builder.type.MediaType
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedUriList: List<Uri>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)



        binding.apply {


            btnNormalMulti.setOnClickListener {
                setNormalMultiButton()
            }


        }




    }

    private fun setNormalMultiButton() {
            TedImagePicker.with(this)
//                .mediaType(MediaType.IMAGE)
                //.scrollIndicatorDateFormat("YYYYMMDD")
                //.buttonGravity(ButtonGravity.BOTTOM)
                //.buttonBackground(R.drawable.btn_sample_done_button)
//                .buttonTextColor(R.color.sample_yellow)
                .errorListener { message -> Log.d("ted", "message: $message") }
                .cancelListener { Log.d("ted", "image select cancel") }
                .selectedUri(selectedUriList)
                .startMultiImage { list: List<Uri> -> showMultiImage(list) }

    }


    private fun showMultiImage(uriList: List<Uri>) {
        selectedUriList = uriList
        Log.i("ted", "uriList: ${uriList.size}")


        Toast.makeText(this,"${uriList.size} image is selected",Toast.LENGTH_SHORT).show()

//        binding.containerSelectedPhotos.visibility = View.VISIBLE
//        binding.containerSelectedPhotos.removeAllViews()
//
//        val viewSize =
//            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100f, resources.displayMetrics)
//                .toInt()
//        uriList.forEach {
//            val itemImageBinding = ItemImageBinding.inflate(LayoutInflater.from(this))
//            Glide.with(this)
//                .load(it)
//                .apply(RequestOptions().fitCenter())
//                .into(itemImageBinding.ivMedia)
//            itemImageBinding.root.layoutParams = FrameLayout.LayoutParams(viewSize, viewSize)
//            binding.containerSelectedPhotos.addView(itemImageBinding.root)
//        }

    }
}