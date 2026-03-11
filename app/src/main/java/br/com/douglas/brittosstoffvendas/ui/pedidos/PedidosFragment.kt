package br.com.douglas.brittosstoffvendas.ui.pedidos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.douglas.brittosstoffvendas.adapter.PedidoAdapter
import br.com.douglas.brittosstoffvendas.databinding.FragmentPedidosBinding

class PedidosFragment : Fragment() {

    private var _binding: FragmentPedidosBinding? = null
    private val binding get() = _binding!!

    // Inicializa o ViewModel
    private val viewModel: PedidosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPedidosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.rvTodosPedidos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTodosPedidos.setHasFixedSize(true)
    }

    private fun observeViewModel() {
        // Observa a lista de pedidos que vem do ViewModel
        viewModel.pedidos.observe(viewLifecycleOwner) { listaPedidos ->
            binding.rvTodosPedidos.adapter = PedidoAdapter(listaPedidos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}