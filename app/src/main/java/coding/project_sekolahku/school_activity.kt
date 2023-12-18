package coding.project_sekolahku

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class school_activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<dataschool>()
    private lateinit var adapter: schoolchoise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = schoolchoise(mList)
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
        toolbar.title = "Daftar sekolah"
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
            val filteredList = ArrayList<dataschool>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(dataschool("SMK NEGERI 1 BATAM", R.drawable.logosmkn1))
        mList.add(dataschool("SMK NEGERI 2 BATAM", R.drawable.logosmk2))
        mList.add(dataschool("SMK NEGERI 3 BATAM", R.drawable.logosmk3))
        mList.add(dataschool("SMK NEGERI 4 BATAM", R.drawable.logosmk4))
        mList.add(dataschool("SMK NEGERI 5 BATAM", R.drawable.logosmk5))
        mList.add(dataschool("SMK NEGERI 6 BATAM", R.drawable.logosmk6))
        mList.add(dataschool("SMK NEGERI 7 BATAM", R.drawable.logosmk7))
        mList.add(dataschool("SMK NEGERI 8 BATAM", R.drawable.logosmk8))
        mList.add(dataschool("SMK NEGERI 9 BATAM", R.drawable.logosmk9))
        mList.add(dataschool("SMK NEGERI 3 BATAM", R.drawable.logosmk3))
        mList.add(dataschool("SMK NEGERI 3 BATAM", R.drawable.logosmk3))
    }
}