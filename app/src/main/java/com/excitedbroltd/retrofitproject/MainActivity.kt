package com.excitedbroltd.retrofitproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        setContent {
            RetrofitProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        (application as MyApplication).myViewModelComponent.inject(this)
        myViewModel = ViewModelProvider(this, myViewModelFactory).get(Myviewmodel::class.java)
        myViewModel.allPost()
        myViewModel.getAllPost().observe(this) {
            Log.d(TAG, "onCreate: ${it.isSuccessful}")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitProjectTheme {
        Greeting("Android")
    }
}