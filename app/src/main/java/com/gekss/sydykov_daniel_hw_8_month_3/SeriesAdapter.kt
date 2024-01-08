package com.gekss.sydykov_daniel_hw_8_month_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gekss.sydykov_daniel_hw_8_month_3.databinding.ItemSeriesBinding

class SeriesAdapter(private val seriesList: List<Series>, var onClick: (position: Series) -> Unit) :
    RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSeriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = seriesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(seriesList[position])
    }

    inner class ViewHolder(private val binding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(series: Series) {
            binding.apply {
                series.apply {
                    nameTv.text = name
                    statusTv.text = status
                    posterImg.loadImage(img)
                }
            }
            itemView.setOnClickListener {
                onClick(series)
            }
        }
    }
}