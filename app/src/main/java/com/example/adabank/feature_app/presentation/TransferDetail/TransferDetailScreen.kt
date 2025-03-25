package com.example.adabank.feature_app.presentation.TransferDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.TransferDetail.components.CustomSwipeButton
import com.example.adabank.feature_app.presentation.common.CustomAlertDialog
import com.example.adabank.feature_app.presentation.common.CustomAlphaCard
import com.example.adabank.feature_app.presentation.common.CustomAsyncImage
import com.example.adabank.feature_app.presentation.common.CustomIndicator
import com.example.adabank.feature_app.presentation.common.CustomKeyboard
import com.example.adabank.feature_app.presentation.common.CustomTopAppBar
import com.example.adabank.feature_app.presentation.ui.theme._106048
import com.example.adabank.feature_app.presentation.ui.theme._whiteopasity30
import com.example.adabank.feature_app.presentation.ui.theme.poppins40010_Whiteopasity60
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_Whiteopasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50010_White
import com.example.adabank.feature_app.presentation.ui.theme.poppins50016Bold_White
import com.example.adabank.feature_app.presentation.ui.theme.poppins60044Bold_White
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TransferDetailScreen(
    navController: NavController,
    viewModel: TransferDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val coroutineScope = rememberCoroutineScope()
    val swipeToDismissBoxState = rememberSwipeToDismissBoxState(confirmValueChange = {
        when (it) {
            SwipeToDismissBoxValue.StartToEnd -> {
                coroutineScope.launch {
                    viewModel.onEvent(TransferDetailEvent.ChangeShowIndicatorState(true))
                    delay(500)
                    viewModel.onEvent(TransferDetailEvent.ChangeShowIndicatorState(false))
                    navController.navigate(Route.ReceiptScreen.route)
                }
            }

            SwipeToDismissBoxValue.EndToStart -> {}
            SwipeToDismissBoxValue.Settled -> {}
        }
        true
    })

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(TransferDetailEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_106048),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Transfer",
            background = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            navController.popBackStack()
        }

        Spacer(Modifier.height(20.dp))

        CustomAlphaCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Text(
                text = "Enter amount",
                style = poppins40010_Whiteopasity60
            )
            Spacer(Modifier.height(5.dp))
            TextField(
                value = "$" + state.amount,
                readOnly = true,
                onValueChange = {
                    viewModel.onEvent(TransferDetailEvent.EnterAmount(it))
                },
                textStyle = poppins60044Bold_White,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(Modifier.height(8.dp))
            Box(
                Modifier.background(_whiteopasity30, RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = state.currency,
                        style = poppins50010_White
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Spacer(Modifier.height(30.dp))
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(_whiteopasity30)
            )
            Spacer(Modifier.height(20.dp))

            Box(
                Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.White, RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    CustomAsyncImage(
                        model = Route.TransferDetailScreen.contact.icon
                    )
                    Spacer(Modifier.width(20.dp))
                    Column {
                        Text(
                            text = Route.TransferDetailScreen.contact.name,
                            style = poppins50016Bold_White
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = "Bank - ${Route.TransferDetailScreen.contact.bankCardNumber}",
                            style = poppins40012_Whiteopasity50
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            item {
                CustomKeyboard(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .fillParentMaxHeight(0.7f)
                        .padding(horizontal = 15.dp),
                    onNumberClick = { column, row ->
                        when (column) {
                            0 -> {
                                viewModel.onEvent(
                                    TransferDetailEvent.EnterAmount(
                                        state.amount + (row + 1).toString()
                                    )
                                )
                            }

                            1 -> {
                                viewModel.onEvent(
                                    TransferDetailEvent.EnterAmount(
                                        state.amount + (column + row + 3).toString()
                                    )
                                )
                            }

                            2 -> {
                                viewModel.onEvent(
                                    TransferDetailEvent.EnterAmount(
                                        state.amount + (column + row + 5).toString()
                                    )
                                )
                            }
                        }
                    },
                    zeroClick = {
                        if (it == 0) {
                            viewModel.onEvent(
                                TransferDetailEvent.EnterAmount(state.amount + ".")
                            )
                        } else {
                            viewModel.onEvent(
                                TransferDetailEvent.EnterAmount(state.amount + "0")
                            )
                        }
                    },
                    deleteClick = {
                        viewModel.onEvent(TransferDetailEvent.DeleteLastCharacter)
                    },
                    showButton = false
                ) { }
                Spacer(Modifier.height(20.dp))
            }

            item {
                CustomSwipeButton(
                    state = swipeToDismissBoxState,
                    modifier = Modifier
                        .fillParentMaxWidth(),
                    enabled = state.amount.isNotEmpty()
                )
            }
        }
    }

    CustomIndicator(state.showIndicator)
}