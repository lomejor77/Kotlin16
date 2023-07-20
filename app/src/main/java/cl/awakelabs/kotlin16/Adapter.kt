package cl.awakelabs.kotlin16

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelabs.kotlin16.databinding.ItemBinding
import coil.load

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()
    var callBack: CountryBack? = null


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

    inner class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pais) {
            binding.textCountry.text = item.nombre
            binding.imageFlag.load(item.imgUrl)
            binding.cardView.setOnClickListener(View.OnClickListener {
                val texto = "Pais:${item.nombre} Poblacion:${item.poblacion}"

                callBack?.showCountry(texto)

            })

        }
    }
}
    interface CountryBack  {
        fun showCountry(text: String)
    }
