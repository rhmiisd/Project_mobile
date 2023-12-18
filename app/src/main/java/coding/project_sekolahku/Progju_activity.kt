package coding.project_sekolahku

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class Progju_activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var pList = ArrayList<dataprogju>()
    private lateinit var adapter: Progjuchoise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progju)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        adapter = Progjuchoise(pList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
        setupToolbar()
    }

    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Daftar jurusan"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Menetapkan tindakan untuk tombol kembali pada Toolbar
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filterList = ArrayList<dataprogju>()
            for (i in pList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filterList.add(i)
                }
            }

            if (filterList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filterList)
            }
        }
    }


    private fun addDataToList() {
        pList.add(dataprogju("Teknik Komputer dan Jaringan"))
        pList.add(dataprogju("Teknik Elektronika Industri"))
        pList.add(dataprogju("Teknik Pemesinan"))
        pList.add(dataprogju("Teknik Instalasi tenaga listrik"))
        pList.add(dataprogju("Teknik Grafika"))
        pList.add(dataprogju("Tata Boga"))
        pList.add(dataprogju("Teknik Logistik"))
        pList.add(dataprogju("Teknik dan Bisnis Sepede Motor"))
        pList.add(dataprogju("Pariwisata"))
        pList.add(dataprogju("Animasi"))
        pList.add(dataprogju("Akuntansi"))
        pList.add(dataprogju("Busana Butik"))
        pList.add(dataprogju("Teknologi Laboratorium Medik"))
        pList.add(dataprogju("Multimedia"))
    }
}
