package com.example.myapplication.presentaition.ui.fragments.fragmentfactory
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentFactory
//import com.example.myapplication.presentaition.ui.fragments.registration.RegistrationFragment
//import com.example.myapplication.presentaition.ui.fragments.registration.MNoteProfileFragment
//
//class MFragmentFactory(private val text: String, private val number: Int): FragmentFactory() {
//
//    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
//        return when (className){
//            RegistrationFragment::class.java.toString() -> RegistrationFragment.newInstance(text)
//            MNoteProfileFragment::class.java.toString() -> MNoteProfileFragment.newInstance(number)
//            else -> super.instantiate(classLoader, className)
//        }
//    }
//}