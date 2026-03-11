package br.com.douglas.brittosstoffvendas.ui.pedidos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.douglas.brittosstoffvendas.model.Pedido

class PedidosViewModel : ViewModel() {

    private val _pedidos = MutableLiveData<List<Pedido>>()
    val pedidos: LiveData<List<Pedido>> get() = _pedidos

    init {
        carregarPedidos()
    }

    private fun carregarPedidos() {
        // Simulando a carga de dados (pode vir de um Repository ou API no futuro)
        val lista = listOf(
            Pedido(1, "Carlos Eduardo M.", "REFORMA", "Estofamento em curso", 65, "12 Out"),
            Pedido(2, "Ana Julia Costa", "FABRICACAO", "Corte de madeira", 20, "25 Out"),
            Pedido(3, "Marcos Pereira", "REFORMA", "Acabamento", 90, "05 Out"),
            Pedido(4, "Julia Santos", "FABRICACAO", "Montagem", 45, "30 Out")
        )
        _pedidos.value = lista
    }
}