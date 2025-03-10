package com.example.myapplication.presentaition.ui.fragments.registration


import android.icu.text.DateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.application.MyApplication
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.domain.models.Note
import com.example.myapplication.presentaition.viewmodels.AddNoteViewModel
import com.example.myapplication.presentaition.viewmodels.NoteViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var text: String? = null
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var addNoteViewModel: AddNoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ARG_TEXT)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun replaceFragment(fragmentName: String) {
        // Проверка, что fragmentName не пустой
        if (fragmentName.isEmpty()) {
            throw IllegalArgumentException("Fragment name cannot be empty")
        }

        try {
            // Создание фрагмента
            val fragment = requireActivity().supportFragmentManager.fragmentFactory
                .instantiate(requireActivity().classLoader, fragmentName)

            // Замена фрагмента
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_id, fragment)
                .addToBackStack(null) // Добавление транзакции в back stack
                .commitAllowingStateLoss() // Подтверждение транзакции
        } catch (e: Fragment.InstantiationException) {
            // Обработка ошибки
            e.printStackTrace()
            throw RuntimeException("Failed to instantiate fragment: $fragmentName", e)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val app = requireActivity().applicationContext as MyApplication
        val addNoteRepository = app.addNoteRepositoryImpl
        val addNoteUseCase = AddNoteUseCase(addNoteRepository)
        val addNoteViewModelFactory = AddNoteViewModelFactory(addNoteUseCase)
        addNoteViewModel = ViewModelProvider(this, addNoteViewModelFactory)[AddNoteViewModel::class.java]

        binding.profileBtnId.setOnClickListener {
            Log.d("ButtenTag", "pressed")
            val name = binding.editUsernameId.text.toString()
            val surname = binding.editPasswordId.text.toString()
            val age = binding.editAgeId.text.toString()
            val phoneNumber = binding.editPhoneNumberId.text.toString()


            if(name.isNotEmpty() && surname.isNotEmpty() && age.isNotEmpty() && phoneNumber.isNotEmpty()){

                addNoteViewModel.addNote(Note(title: String,
                    val dateCreated: DateFormat,
                val dateLastEdited: DateFormat,
                val data: String,username = name, password = surname, phoneNumber = phoneNumber.toInt(), age = age.toInt()))
            }
            replaceFragment(MNoteProfileFragment::class.java.name) // Используем .name для получения полного имени класса
        }

    }


    companion object {
        // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_TEXT = "text"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(text: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT,text)

                }
            }
    }
}