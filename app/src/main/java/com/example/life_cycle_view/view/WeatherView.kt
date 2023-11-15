package com.example.life_cycle_view.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Xml
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.res.getBooleanOrThrow
import androidx.core.content.res.getIntOrThrow
import com.example.life_cycle_view.R
import com.example.life_cycle_view.databinding.ViewWeatherBinding

@SuppressLint("SetTextI18n")
class WeatherView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding: ViewWeatherBinding =
        ViewWeatherBinding.inflate(LayoutInflater.from(context), this)

//    var backClick: (())

    init {
        setAttrs(attrs, R.styleable.WeatherView) {
            binding.city.text = it.getString(R.styleable.WeatherView_weather_city)
            binding.country.text = it.getString(R.styleable.WeatherView_weather_country)
            binding.temperature.text = it.getString(R.styleable.WeatherView_weather_temperature)

           if(it.getBooleanOrThrow(R.styleable.WeatherView_weather_wind)) binding.cloud.setImageResource(R.drawable.ic_tornado)

            binding.precipitation.text = Precipitation.values().firstOrNull{prec ->
                prec.ordinal == it.getIntOrThrow(R.styleable.WeatherView_weather_precipitation)
            }?.description

            when(it.getIntOrThrow(R.styleable.WeatherView_weather_time)){
                Time.DAY.ordinal -> binding.cloud.setImageResource(R.drawable.ic_cloud_sun_heavy_rainy)

            }
//            binding.hTemp.text = it.getString(R.styleable.Wea)

//            binding.precipitation.text = it.getString(R.styleable.WeatherView_weather_precipitation)

            //when(it.getIntOrThrow(R.styleable.WeatherView_weather_precipitation)){
//                Precipitation.SMALL_RAIN.ordinal -> binding.precipitation.text = Precipitation.SMALL_RAIN.description
//
//                Precipitation.MID_RAIN.ordinal -> binding.precipitation.text =  Precipitation.MID_RAIN.description
//
//                Precipitation.HEAVY_RAIN.ordinal -> binding.precipitation.text =  Precipitation.HEAVY_RAIN.description
//
//                Precipitation.SMALL_SNOW.ordinal -> binding.precipitation.text =  Precipitation.SMALL_SNOW.description
//
//                Precipitation.MID_SNOW.ordinal -> binding.precipitation.text =  Precipitation.MID_SNOW.description
//
//                Precipitation.HEAVY_SNOW.ordinal -> binding.precipitation.text = Precipitation.HEAVY_SNOW.description
                //}




        }
    }

    enum class Precipitation(val description: String) {
        SMALL_RAIN("small rain"),
        MID_RAIN("mid rain"),
        HEAVY_RAIN("heavy rain"),
        SMALL_SNOW("light snow"),
        MID_SNOW("mid snow"),
        HEAVY_SNOW("heavy snow")
    }

    enum class Time{
        DAY,NIGHT
    }
}