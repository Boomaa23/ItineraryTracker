package com.boomaa.itinerarytracker.ui.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.boomaa.itinerarytracker.databinding.FragmentCurrentBinding

class CurrentFragment : Fragment() {
    private lateinit var currentViewModel: CurrentViewModel
    private var _binding: FragmentCurrentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        currentInstanceState: Bundle?
    ): View? {
        currentViewModel =
            ViewModelProvider(this).get(CurrentViewModel::class.java)

        _binding = FragmentCurrentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCurrent
        currentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}