package ru.netology.nmedia.activity

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.FragmentImageBinding
import ru.netology.nmedia.util.StringArg
import ru.netology.nmedia.view.load


class ImageFragment : Fragment() {

    companion object {
        var Bundle.textArg: String? by StringArg
    }

    private var fragmentBinding: FragmentImageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentImageBinding.inflate(
            inflater,
            container,
            false
        )
        fragmentBinding = binding

        arguments?.textArg
            ?.apply { binding.image.load(this) }

        changeAppBarBackgroundColor(R.color.blackAppBar)

        return binding.root
    }

    override fun onDestroyView() {
        fragmentBinding = null
        changeAppBarBackgroundColor(R.color.colorPrimary)
        super.onDestroyView()
    }

    private fun changeAppBarBackgroundColor(color: Int) {
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(requireActivity(), color)
                )
            )
        }
    }
}