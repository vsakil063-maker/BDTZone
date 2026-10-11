package com.microtask.app.ui.deposit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.microtask.app.R
import com.microtask.app.databinding.FragmentDepositBinding

class DepositFragment : Fragment(R.layout.fragment_deposit) {

    private var _binding: FragmentDepositBinding? = null
    private val binding get() = _binding!!
    
    private var selectedMethod = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDepositBinding.bind(view)

        // Back Button এ ক্লিক করলে আগের পেজে (Home) ফিরে যাবে
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // পেমেন্ট মেথড সিলেক্ট করার লজিক
        binding.cardNagad.setOnClickListener {
            selectedMethod = "Nagad"
            Toast.makeText(requireContext(), "Selected: Nagad", Toast.LENGTH_SHORT).show()
        }
        
        binding.cardBkash.setOnClickListener {
            selectedMethod = "bKash"
            Toast.makeText(requireContext(), "Selected: bKash", Toast.LENGTH_SHORT).show()
        }
        
        binding.cardBinance.setOnClickListener {
            selectedMethod = "Binance"
            Toast.makeText(requireContext(), "Selected: Binance", Toast.LENGTH_SHORT).show()
        }

        // Proceed Button লজিক
        binding.btnProceed.setOnClickListener {
            if (selectedMethod.isEmpty()) {
                Toast.makeText(requireContext(), "Please select a payment method", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Proceeding with $selectedMethod...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
