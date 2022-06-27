package com.example.jasaonline.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jasaonline.R
import com.example.jasaonline.activities.EditProfileActivity
import com.example.jasaonline.helpers.SessionHandler
import com.example.jasaonline.models.User
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container,
            false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val session = SessionHandler(requireContext())
        val user: User? = session.getUser()
        val titikDua = ": "
        if(user != null) {
            view.tvNama.text = titikDua + user.nama
            view.tvTanggalLahir.text = titikDua + user.tanggalLahir
            view.tvJenisKelamin.text = titikDua + user.jenisKelamin
            view.tvNomorHP.text = titikDua + user.nomorHP
            view.tvAlamat.text = titikDua + user.alamat
            view.tvEmail.text = titikDua + user.email
            view.tvWaktuSesi.text = titikDua + session.getExpireTime()
        }
        view.btnEditProfil.setOnClickListener {
            val intent = Intent(context, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}