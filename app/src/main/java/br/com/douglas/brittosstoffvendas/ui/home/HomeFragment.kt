package br.com.douglas.brittosstoffvendas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.douglas.brittosstoffvendas.R
import br.com.douglas.brittosstoffvendas.adapter.PedidoAdapter
import br.com.douglas.brittosstoffvendas.databinding.FragmentHomeBinding
import br.com.douglas.brittosstoffvendas.model.Pedido

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configurarListaDePedidos()
        configurarBotoes()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Configura o RecyclerView com dados de exemplo
    private fun configurarListaDePedidos() {
        // Dados de exemplo (no futuro viram de uma API)
        val pedidos = listOf(
            Pedido(
                id = 1,
                nomeCliente = "Carlos Eduardo M.",
                tipo = "REFORMA",
                status = "Estofamento em curso",
                progresso = 65,
                dataEntrega = "12 Out"
            ),
            Pedido(
                id = 2,
                nomeCliente = "Ana Julia Costa",
                tipo = "FABRICACAO",
                status = "Corte de madeira",
                progresso = 20,
                dataEntrega = "25 Out"
            )
        )

        // Configurar o RecyclerView
        binding.rvPedidos.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PedidoAdapter(pedidos)
        }
    }

    // Configura os cliques dos botoes
    private fun configurarBotoes() {
        binding.btnNovaReforma.setOnClickListener {
            Toast.makeText(requireContext(), "Nova Reforma!", Toast.LENGTH_SHORT).show()
        }

        binding.btnNovaFabricacao.setOnClickListener {
            Toast.makeText(requireContext(), "Nova Fabricacao!", Toast.LENGTH_SHORT).show()
        }

        binding.btnVerModelos.setOnClickListener {
            // Navegar para a tela de Catalogo
            findNavController().navigate(R.id.catalogoFragment)
        }

        binding.tvVerTodos.setOnClickListener {
            // Navegar para a tela de Pedidos
            findNavController().navigate(R.id.pedidosFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
