package cl.eme.countries.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.eme.countries.databinding.ItemListBinding
import cl.eme.countries.model.MinimalCountry
import coil.load

class CountryAdapter : RecyclerView.Adapter<CountryVH>() {

    var items = listOf<MinimalCountry>()

    fun update(minimalList: List<MinimalCountry>) {
        items = minimalList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryVH {
        return CountryVH(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryVH, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

}

class CountryVH(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(country: MinimalCountry) {
        binding.tvName.text = country.name
        binding.ivFlag.load(country.flag)
    }
}
