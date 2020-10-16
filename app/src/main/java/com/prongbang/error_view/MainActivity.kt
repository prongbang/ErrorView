package com.prongbang.error_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initView()
	}

	private fun initView() {
		cameraErrorView.onButtonClickListener = {
			Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
		}
	}
}