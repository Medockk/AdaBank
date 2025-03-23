package com.example.adabank.feature_app.presentation.Notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.feature_app.presentation.Notification.components.CustomCard
import com.example.adabank.feature_app.presentation.Notification.components.CustomNotificationRow
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.common.CustomAlertDialog
import com.example.adabank.feature_app.presentation.common.CustomBottomBar
import com.example.adabank.feature_app.presentation.ui.theme._080422opasity5
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme._130F26
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_09703E
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_Blackopasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50016Bold_080422

@Composable
fun NotificationScreen(
    navController: NavController,
    viewModel: NotificationViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(NotificationEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_F6F6F6)
            .padding(start = 25.dp, end = 25.dp, top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Notification",
            style = poppins50016Bold_080422
        )

        Spacer(Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CustomCard(
                    modifier = Modifier
                        .fillParentMaxWidth()
                ) {
                    Text(
                        text = "Transaction",
                        style = poppins50014_080422opasity20
                    )
                    Spacer(Modifier.height(15.dp))
                    this@LazyColumn.items(state.notifications) { notification ->
                        CustomNotificationRow(
                            leadingIcon = notification.icon,
                            title = notification.title,
                            description = notification.date
                        )
                        Spacer(Modifier.height(15.dp))
                    }
                }
                Spacer(Modifier.height(25.dp))
            }

            item {
                CustomCard(
                    modifier = Modifier
                        .fillParentMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Complete Verification",
                            style = poppins50014_Blackopasity50
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = "${state.completeVerificationPercent}%",
                            style = poppins50014_09703E
                        )
                    }
                    Spacer(Modifier.height(20.dp))
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .background(_080422opasity5, RoundedCornerShape(100.dp))
                    ) {
                        if (
                            state.completeVerificationPercent.isNotBlank() &&
                            state.completeVerificationPercent.toFloatOrNull() != null
                        ) {
                            Box(
                                Modifier
                                    .fillMaxWidth(
                                        state.completeVerificationPercent.toFloat() / 100
                                    )
                                    .height(10.dp)
                                    .background(_09703E, RoundedCornerShape(100.dp))
                            )
                        }
                    }
                    Spacer(Modifier.height(30.dp))
                    this@LazyColumn.items(state.completeVerification){
                        CustomNotificationRow(
                            leadingIcon = it.icon,
                            title = it.title,
                            description = it.description,
                            trailingIcon = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            trailingIconColor = _130F26
                        )
                        Spacer(Modifier.height(15.dp))
                    }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        CustomBottomBar(
            Route.NotificationScreen,
            navController
        )
    }
}