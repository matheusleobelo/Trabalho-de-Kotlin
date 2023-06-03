package com.example.matheusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.matheusapp.DadosAdapter
import com.example.matheusapp.Usuario
import com.google.firebase.database.*

class listaDeDados : AppCompatActivity() {
    private lateinit var empRecyclerView: RecyclerView
    //private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<Usuario>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_dados);


        empRecyclerView = findViewById(R.id.recycler_view_dados)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        //tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<Usuario>()

        getEmployeesData()

    }

    private fun getEmployeesData() {

        empRecyclerView.visibility = View.GONE
        //tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("usuarios")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(Usuario::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = DadosAdapter(empList)
                    empRecyclerView.adapter = mAdapter

//                    mAdapter.setOnItemClickListener(object : EmpAdapter.onItemClickListener{
//                        override fun onItemClick(position: Int) {
//
//                            val intent = Intent(this@FetchingActivity, EmployeeDetailsActivity::class.java)
//
//                            //put extras
//                            intent.putExtra("empId", empList[position].empId)
//                            intent.putExtra("empName", empList[position].empNome)
//                            intent.putExtra("empCargo", empList[position].empCargo)
//                            intent.putExtra("empSalary", empList[position].emSalario)
//                            startActivity(intent)
//                        }
//
//                    })

                    empRecyclerView.visibility = View.VISIBLE
                    //tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}