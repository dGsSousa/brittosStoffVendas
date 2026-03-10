package br.com.douglas.brittosstoffvendas.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seunome.salessystempro.databinding.ItemPedidoBinding
import com.seunome.salessystempro.model.Pedido

// Adapter: transforma uma lista de Pedidos em itens visuais
class PedidoAdapter(private val pedidos: List<Pedido>) :
    RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>() {

    // ViewHolder: representa um item da lista na tela
    inner class PedidoViewHolder(private val binding: ItemPedidoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Preenche os dados de um pedido no layout
        fun bind(pedido: Pedido) {
            binding.tvNomeCliente.text = pedido.nomeCliente
            binding.tvTipo.text = pedido.tipo
            binding.tvStatus.text = "Status: ${pedido.status}"
            binding.progressBar.progress = pedido.progresso
            binding.tvProgresso.text = "Progresso: ${pedido.progresso}%"
            binding.tvEntrega.text = "Entrega: ${pedido.dataEntrega}"

            // Mudar a cor do badge conforme o tipo
            if (pedido.tipo == "REFORMA") {
                binding.tvTipo.setTextColor(Color.parseColor("#1A237E"))
                binding.tvTipo.setBackgroundResource(R.drawable.bg_badge_reforma)
            } else {
                binding.tvTipo.setTextColor(Color.parseColor("#C62828"))
                binding.tvTipo.setBackgroundResource(R.drawable.bg_badge_fabricacao)
            }
        }
    }

    // Cria o ViewHolder inflando (carregando) o layout do item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder {
        val binding = ItemPedidoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PedidoViewHolder(binding)
    }

    // Vincula os dados ao ViewHolder na posicao correta
    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        holder.bind(pedidos[position])
    }

    // Retorna quantos itens ha na lista
    override fun getItemCount(): Int = pedidos.size
}
