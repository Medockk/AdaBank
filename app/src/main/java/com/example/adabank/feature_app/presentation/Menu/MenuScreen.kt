@file:Suppress("UNCHECKED_CAST")

package com.example.adabank.feature_app.presentation.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.R
import com.example.adabank.feature_app.presentation.Menu.components.CustomMenuCard
import com.example.adabank.feature_app.presentation.common.CustomSearchTextField
import com.example.adabank.feature_app.presentation.common.CustomTopAppBar
import com.example.adabank.feature_app.presentation.ui.theme._106048
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_White

@Composable
fun MenuScreen(
    navController: NavController,
    viewModel: MenuViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val shortcutsList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.send_money_icon),
            "Send Money",
            {},
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.top_up_icon),
            "Top-up Wallet",
            {},
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.selected_bill),
            "Bill Payment",
            {},
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.green_scan_qr_icon),
            "Code Qr",
            {},
        ),
    )
    val otherMenuList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.history_transactions_icon),
            "History Transactions",
            {}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.request_payment_icon),
            "Request Payment",
            {}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.change_money_icon),
            "Change Money",
            {}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.saving_icon),
            "Savings",
            {}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.investment_icon),
            "Investment",
            {}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.setting_icon),
            "Settings",
            {}
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_106048)
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Menu",
            modifier = Modifier
                .fillMaxWidth(),
            background = Color.White
        ) { navController.popBackStack() }

        Spacer(Modifier.height(35.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                CustomSearchTextField(
                    value = state.searchText,
                    onValueChange = {
                        viewModel.onEvent(MenuEvent.EnterSearchText(it))
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    hint = "Search Menu",
                )

                Spacer(Modifier.height(50.dp))
            }
            item {
                Text(
                    text = "Shortcuts",
                    style = poppins50014_White,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            items(shortcutsList) {
                CustomMenuCard(
                    icon = it[0] as ImageVector,
                    text = it[1] as String,
                    modifier = Modifier
                        .fillParentMaxWidth(),
                    onClick = it[2] as () -> Unit
                )
                Spacer(Modifier.height(30.dp))
            }
            item {
                Text(
                    text = "Other Menu",
                    style = poppins50014_White,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            items(otherMenuList) {
                CustomMenuCard(
                    icon = it[0] as ImageVector,
                    text = it[1] as String,
                    modifier = Modifier
                        .fillParentMaxWidth(),
                    onClick = it[2] as () -> Unit
                )
                Spacer(Modifier.height(30.dp))
            }

        }
    }
}