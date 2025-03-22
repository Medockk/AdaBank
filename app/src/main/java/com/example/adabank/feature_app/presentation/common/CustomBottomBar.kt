package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adabank.R
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.ui.theme._07041A17
import com.example.adabank.feature_app.presentation.ui.theme._09703E

@Composable
fun CustomBottomBar(
    route: Route,
    navController: NavController,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
) {

    val navBarIconList = listOf(
        ImageVector.vectorResource(R.drawable.home_icon),
        ImageVector.vectorResource(R.drawable.graph_icon),
        ImageVector.vectorResource(R.drawable.scan_icon),
        ImageVector.vectorResource(R.drawable.bill_nav_bar_icon),
        ImageVector.vectorResource(R.drawable.notification_icon),
    )
    val navBarSelectedIconList = listOf(
        ImageVector.vectorResource(R.drawable.selected_home),
        ImageVector.vectorResource(R.drawable.selected_graph),
        ImageVector.vectorResource(R.drawable.scan_icon),
        ImageVector.vectorResource(R.drawable.selected_bill),
        ImageVector.vectorResource(R.drawable.selected_notification),
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .shadow(
                    4.dp, RoundedCornerShape(30.dp),
                    spotColor = _07041A17
                ),
            shape = RoundedCornerShape(30.dp),
        ) {
            NavigationBar(
                containerColor = Color.White,
                windowInsets = WindowInsets(0, 0, 0, 0)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    horizontalArrangement = Arrangement.spacedBy(40.dp)
                ) {
                    repeat(5) {
                        if (it == 2) {
                            Box(Modifier.size(1.dp))
                        } else {
                            NavigationBarItem(
                                selected = false,
                                onClick = {
                                    if (it == 0 && route.route != Route.HomeScreen.route) {
                                        navController.navigate(Route.HomeScreen.route)
                                    } else if (it == 4 && route.route != Route.NotificationScreen.route) {
                                        navController.navigate(Route.NotificationScreen.route)
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (route.route == Route.HomeScreen.route && it == 0) {
                                            navBarSelectedIconList[it]
                                        } else if (route.route == Route.NotificationScreen.route && it == 4) {
                                            navBarSelectedIconList[it]
                                        } else {
                                            navBarIconList[it]
                                        },
                                        contentDescription = null,
                                        tint = Color.Unspecified
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }

        Box(
            Modifier
                .size(50.dp)
                .background(_09703E, RoundedCornerShape(30.dp))
                .align(Alignment.TopCenter),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.scan_icon),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}