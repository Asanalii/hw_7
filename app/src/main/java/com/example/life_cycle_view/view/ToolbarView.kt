package com.example.life_cycle_view.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.life_cycle_view.R
import com.example.life_cycle_view.databinding.ViewToolbarBinding

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attrs, defStyleAttr) {
    private val binding: ViewToolbarBinding =
        ViewToolbarBinding.inflate(LayoutInflater.from(context), this)

    var backClick: (() -> Unit)? = null
    var favoriteClick: (() -> Unit)? = null

    init {

        setAttrs(attrs, R.styleable.ToolbarView) {
            binding.title.text = it.getString(R.styleable.ToolbarView_toolbar_title)
            binding.favoriteButton.isVisible =
                it.getBoolean(R.styleable.ToolbarView_toolbar_favorite_visibility, false)

            val titleColor = it.getColor(
                R.styleable.ToolbarView_toolbar_title_color,
                ContextCompat.getColor(context, R.color.black)
            )

            val backButtonColor = it.getColor(
                R.styleable.ToolbarView_toolbar_back_color,
                ContextCompat.getColor(context, R.color.black)
            )

            binding.title.setTextColor(titleColor)
            binding.backButton.setColorFilter(backButtonColor)
            binding.favoriteButton.setImageResource(
                it.getResourceId(R.styleable.ToolbarView_toolbar_end_icon, R.drawable.ic_favorite)
            )
        }


        binding.backButton.setOnClickListener {
            backClick?.invoke()
        }

        binding.favoriteButton.setOnClickListener {
            binding.favoriteButton.setColorFilter(ContextCompat.getColor(context, R.color.red))
            favoriteClick?.invoke()
        }
    }

    var title: String
        get() = binding.title.text.toString()
        set(value) {
            binding.title.text = value
        }

    var showFavoriteButton: Boolean
        get() = binding.favoriteButton.isVisible
        set(value) {
            binding.favoriteButton.isVisible = value
        }

    enum class Style {
        WHITE, BLACK, BLUE, RED
    }
}

inline fun View.setAttrs(
    attrs: AttributeSet?,
    styleable: IntArray,
    crossinline body: (TypedArray) -> Unit
) {
    context.theme.obtainStyledAttributes(attrs, styleable, 0, 0)
        .apply {
            try {
                body.invoke(this)
            } finally {
                recycle()
            }
        }
}