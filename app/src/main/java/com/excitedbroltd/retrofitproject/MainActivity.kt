package com.excitedbroltd.retrofitproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.excitedbroltd.retrofitproject.di.MyApplication
import com.excitedbroltd.retrofitproject.mvvm.MyViewModelFactory
import com.excitedbroltd.retrofitproject.mvvm.Myviewmodel
import com.excitedbroltd.retrofitproject.ui.theme.RetrofitProjectTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    @Inject
    lateinit var myViewModelFactory: MyViewModelFactory
    private lateinit var myViewModel: Myviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).myViewModelComponent.inject(this)
        myViewModel = ViewModelProvider(this, myViewModelFactory).get(Myviewmodel::class.java)
        myViewModel.allPost()

        setContent {
            RetrofitProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val posts = myViewModel.getAllPost().value

                    LazyColumn() {
                        items(items = posts) { post ->
                            ListDesign(posts = post)
                        }
                    }
                }
            }
        }

    }
}


 