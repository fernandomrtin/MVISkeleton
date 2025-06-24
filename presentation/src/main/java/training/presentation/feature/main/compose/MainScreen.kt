package training.presentation.feature.main.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import training.presentation.feature.main.navigation.AppNavHost
import training.presentation.feature.main.navigation.NavRoutes
import training.presentation.feature.main.viewmodel.MainIntent
import training.presentation.feature.main.viewmodel.MainViewModel
import training.ui.NavigationDrawer
import training.ui.Toolbar
import training.ui.theme.LocalColors
import training.ui.theme.getLocalColorsByUserType

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val mainState by viewModel.mainState.collectAsState()

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            val isHome = backStackEntry.destination.route == NavRoutes.Home.route
            viewModel.onIntent(MainIntent.ToggleDrawerVisibility(isHome))
        }
    }

    LaunchedEffect(mainState.isDrawerOpen) {
        if (mainState.isDrawerOpen) drawerState.open() else drawerState.close()
    }

    CompositionLocalProvider(LocalColors provides getLocalColorsByUserType()) {
        if (mainState.isDrawerEnabled) {
            NavigationDrawer(
                drawerState = drawerState,
                menuData = mainState.menuData,
                onMenuElementClick = { item ->
                    viewModel.onIntent(MainIntent.SelectMenuElement(item))
                },
                onBackMenuItemClick = {
                    viewModel.onIntent(MainIntent.NavigateBackSubMenu)
                },
                onCloseDrawerClick = {
                    viewModel.onIntent(MainIntent.CloseDrawer)
                }
            ) {
                Scaffold(
                    topBar = {
                        Toolbar(
                            navIcon = training.ui.R.drawable.ic_menu,
                            onIconClick = {
                                viewModel.onIntent(MainIntent.NavigationItemClick)
                            })
                    },
                    containerColor = Color.White
                ) { paddingValues ->
                    AppNavHost(
                        navController = navController,
                        onBackPressed = {},
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        } else {
            AppNavHost(
                navController = navController,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}

