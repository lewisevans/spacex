package com.subtronic.spacex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.subtronic.domain.launch.LaunchItemDataDomainEntity
import com.subtronic.spacex.databinding.LaunchItemBinding
import java.text.DateFormat

class MainAdapter : Adapter<MainAdapter.LaunchItemViewHolder>() {

    private val formatter = DateFormat.getDateInstance(DateFormat.MEDIUM)

    private var _items: List<LaunchItemDataDomainEntity> = emptyList()
    var items: List<LaunchItemDataDomainEntity>
        set(value) {
            _items = value
            //TODO only update items here (remove notifyDataSetChanged)
            notifyDataSetChanged()
        }
        get() = _items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchItemViewHolder =
        LaunchItemViewHolder(
            LaunchItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: LaunchItemViewHolder, position: Int) {
        with(holder) {
            with(_items[position]) {
                with(binding) {
                    Glide
                        .with(launchBadge)
                        .load(image)
                        .into(launchBadge)
                    tvHeading.text = name
                    tvLaunchDate.text = itemView.context.getString(
                        R.string.main_view_launch_date,
                        formatter.format(launchDate)
                    )
                    tvOutcome.text = success
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size


    inner class LaunchItemViewHolder(val binding: LaunchItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}