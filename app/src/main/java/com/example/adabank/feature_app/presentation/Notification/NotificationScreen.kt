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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.adabank.feature_app.presentation.Notification.components.CustomCard
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.common.CustomAlertDialog
import com.example.adabank.feature_app.presentation.common.CustomBottomBar
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_Black
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_Blackopasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme.poppins50016Bold_080422

@Composable
fun NotificationScreen(
    navController: NavController,
    viewModel: NotificationViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()){
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
                    this@LazyColumn.items(state.notifications){ notification ->
                        Spacer(Modifier.fillMaxWidth().height(1.dp).background(Color.Black).alpha(0.1f))
                        Spacer(Modifier.height(15.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = notification.icon,
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(25.dp)
                            )
                            Spacer(Modifier.weight(1f))
                            Column {
                                Text(
                                    text = notification.title,
                                    style = poppins40012_Black
                                )
                                Spacer(Modifier.height(5.dp))
                                Text(
                                    text = notification.date,
                                    style = poppins40012_Blackopasity50
                                )
                            }
                            Spacer(Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = _09703E
                            )
                        }
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