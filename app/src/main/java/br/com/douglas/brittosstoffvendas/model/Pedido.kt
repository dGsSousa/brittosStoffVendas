package br.com.douglas.brittosstoffvendas.model

data class Pedido(
    val id: Int,
    val nomeCliente: String,
    val tipo: String,           // Reforma ou Fabricação
    val status: String,         // Ex: Estofamento em curso
    val progresso: Int,         // 0 a 100%
    val dataEntrega: String     // Ex: 12 Out
)