package cl.awakelabs.kotlin16

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelabs.kotlin16.databinding.ItemBinding
import coil.load

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return paises.size
    }
    fun setData(listaPaises: List<Pais>) {
        this.paises = listaPaises.toMutableList()
    }

    class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pais: Pais) {
            binding.textCountry.text = pais.nombre
            binding.imageFlag.load(pais.imgUrl)
        }
    }
}