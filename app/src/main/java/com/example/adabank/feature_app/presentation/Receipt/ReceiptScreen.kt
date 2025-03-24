package com.example.adabank.feature_app.presentation.Receipt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.common.CustomTopAppBar
import com.example.adabank.feature_app.presentation.ui.theme._080422
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins50020Bold_080422

@Composable
fun ReceiptScreen(
    navController: NavController,
    viewModel: ReceiptViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_F6F6F6)
            .padding(horizontal = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "",
            background = _080422
        ) {
            navController.navigate(Route.HomeScreen.route){
                popUpTo(Route.ReceiptScreen.route){
                    inclusive = true
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Receipt",
            style = poppins50020Bold_080422
        )
    }
}