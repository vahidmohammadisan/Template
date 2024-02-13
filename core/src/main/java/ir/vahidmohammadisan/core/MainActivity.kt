package ir.vahidmohammadisan.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.vahidmohammadisan.core.design.AndroidStarterTheme
import ir.vahidmohammadisan.core.navigation.NavigationDestination
import ir.vahidmohammadisan.core.navigation.NavigationFactory
import ir.vahidmohammadisan.core.navigation.NavigationHost
import ir.vahidmohammadisan.core.navigation.NavigationManager
import ir.vahidmohammadisan.core.utils.collectWithLifecycle
import ir.vahidmohammadisan.newtemplate.core.R
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationFactories: @JvmSuppressWildcards Set<NavigationFactory>

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStarterTheme {
                val navController = rememberNavController()

                Scaffold(
                    topBar = { MainTopAppBar() },
                ) {
                    NavigationHost(
                        modifier = Modifier
                            .padding(it),
                        navController = navController,
                        factories = navigationFactories,
                    )
                }

                navigationManager
                    .navigationEvent
                    .collectWithLifecycle(
                        key = navController,
                    ) {
                        when (it.destination) {
                            NavigationDestination.Back.route -> navController.navigateUp()
                            else -> navController.navigate(it.destination, it.configuration)
                        }
                    }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Medium,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}
