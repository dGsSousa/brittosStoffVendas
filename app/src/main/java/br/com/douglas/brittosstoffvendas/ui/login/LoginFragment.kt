package br.com.douglas.brittosstoffvendas.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.douglas.brittosstoffvendas.R
import br.com.douglas.brittosstoffvendas.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        val manterConectado = prefs.getBoolean("manter_conectado", false)
        if (manterConectado) {
            findNavController().navigate(R.id.action_login_to_home)
            return
        }

        binding.btnEntrar.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()

            if (email.isEmpty()) {
                binding.tilEmail.error = "Digite seu e-mail"
                return@setOnClickListener
            }

            if (senha.isEmpty()) {
                binding.tilSenha.error = "Digite sua senha"
                return@setOnClickListener
            }

            binding.tilEmail.error = null
            binding.tilSenha.error = null

            if (email == "admin@teste.com" && senha == "123456") {
                val editor = prefs.edit()
                editor.putBoolean("manter_conectado", binding.switchManter.isChecked)
                editor.apply()

                findNavController().navigate(R.id.action_login_to_home)
            } else {
                Toast.makeText(requireContext(), "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvEsqueci.setOnClickListener {
            Toast.makeText(requireContext(), "Função em desenvolvimento!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
