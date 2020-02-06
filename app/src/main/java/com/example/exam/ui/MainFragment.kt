package com.example.exam.ui


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.exam.LoginUserViewModel
import com.example.exam.MainViewModel

import com.example.exam.R
import com.example.exam.databinding.FragmentMainBinding
import com.example.exam.recyclerView.UserAdapter
import com.example.exam.userData.Response
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private val loginViewModel by sharedViewModel<LoginUserViewModel>()
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        val adapter = UserAdapter()
        binding.userList.adapter = adapter

        loginViewModel.defaultResponse.observe(viewLifecycleOwner, Observer {
            binding.tvId.text = it.id.toString()
            binding.tvName.text = it.name
            Picasso.with(context)
                .load(it.photo)
                .into(binding.imageView)
        })

        mainViewModel.itemResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it.response)
            }
            fun filter(text: String) {
                val newList = ArrayList<Response>()
                for (element in it.response) {
                    if (element.title.toLowerCase().contains(text.toLowerCase())) {
                        newList.add(element)
                    }
                }
                adapter.filterList(newList)
            }

            binding.etSearch.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    filter(p0.toString())
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

            })

        })


        return binding.root
    }


}
