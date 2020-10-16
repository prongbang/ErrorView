package com.prongbang.widget.errorview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.prongbang.widget.errorview.databinding.ViewErrorBinding

class ErrorView @JvmOverloads constructor(
		context: Context,
		attrs: AttributeSet? = null,
		defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

	var onButtonClickListener: () -> Unit = {}

	init {
		val binding = ViewErrorBinding.bind(View.inflate(context, R.layout.view_error, this))
		val attributes = context.obtainStyledAttributes(attrs, R.styleable.ErrorView, defStyleAttr, 0)
		val icon = attributes.getDrawable(R.styleable.ErrorView_errorIcon)
		val iconSize = attributes.getDimension(R.styleable.ErrorView_errorIconSize, 0f)
		val title = attributes.getString(R.styleable.ErrorView_errorTitle)
		val subtitle = attributes.getString(R.styleable.ErrorView_errorSubtitle)
		val buttonText = attributes.getString(R.styleable.ErrorView_errorButtonText)
		val buttonColor = attributes.getDrawable(R.styleable.ErrorView_errorButtonColor)
		val elevation = attributes.getDimension(R.styleable.ErrorView_errorElevation, 0f)
		val backgroundColor = attributes.getColor(R.styleable.ErrorView_errorBackgroundColor, 0)

		binding.apply {
			errorImage.apply {
				setImageDrawable(icon)
				if (iconSize > 0) {
					layoutParams.height = iconSize.toInt()
					layoutParams.width = iconSize.toInt()
					requestLayout()
				}
			}
			titleText.text = title
			subtitleText.text = subtitle
			if (attributes.hasValue(R.styleable.ErrorView_errorBackgroundColor)) {
				errorCardView.setCardBackgroundColor(backgroundColor)
			}
			if (attributes.hasValue(R.styleable.ErrorView_errorElevation)) {
				errorCardView.cardElevation = elevation
			}
			if (attributes.hasValue(R.styleable.ErrorView_errorButtonColor)) {
				actionButton.background = buttonColor
			}
			if (buttonText.isNullOrEmpty()) {
				actionButton.visibility = View.GONE
			} else {
				actionButton.visibility = View.VISIBLE
			}
			actionButton.apply {
				text = buttonText
				setOnClickListener {
					onButtonClickListener.invoke()
				}
			}
		}
		attributes.recycle()
	}

}