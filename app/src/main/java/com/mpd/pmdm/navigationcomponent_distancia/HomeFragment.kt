package com.mpd.pmdm.navigationcomponent_distancia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mpd.pmdm.navigationcomponent_distancia.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    //Dejamos el onCreateView, aplicamos viewBinding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSalir.setOnClickListener {
            activity?.finish()
        }

        binding.btnContinuar.setOnClickListener {
            //findNavController().navigate(R.id.segundoFragment)//pasamos de una pantalla a otra sin argumentos/parametros
            //findNavController().navigate(R.id.action_homeFragment_to_petColorFragment) otra forma de pasar a
            //la siguiente actividad.



            val sexo = when{
                binding.rbtHombre.isChecked ->"Hombre"
                binding.rbtMujer.isChecked -> "Mujer"
                else -> "Otro"
            }

            //Pasando argumentos.
            val action = HomeFragmentDirections.actionHomeFragmentToPetColorFragment(
                binding.editNombre.text.toString(),
                sexo
            )
            findNavController().navigate(action)

        }
    }
}