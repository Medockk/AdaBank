package com.example.adabank.feature_app.presentation.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.adabank.R
import com.example.adabank.feature_app.presentation.Home.componets.CustomOptionCard
import com.example.adabank.feature_app.presentation.Home.componets.CustomSendAgainCard
import com.example.adabank.feature_app.presentation.Home.componets.CustomTransactionHistory
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.common.CustomAlertDialog
import com.example.adabank.feature_app.presentation.common.CustomBottomBar
import com.example.adabank.feature_app.presentation.ui.theme._080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme._106048
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F626opasity15
import com.example.adabank.feature_app.presentation.ui.theme._FAFAFAopasity10
import com.example.adabank.feature_app.presentation.ui.theme._FAFAFAopasity5
import com.example.adabank.feature_app.presentation.ui.theme._FAFAFAopasity50
import com.example.adabank.feature_app.presentation.ui.theme._FAFAFAopasity60
import com.example.adabank.feature_app.presentation.ui.theme._FFFFFFopasity30
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_White
import com.example.adabank.feature_app.presentation.ui.theme.poppins40014White
import com.example.adabank.feature_app.presentation.ui.theme.poppins50010_White
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme.poppins50024Bold_White
import com.example.adabank.feature_app.presentation.ui.theme.poppins60044Bold_White

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val optionList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.transfer_icon),
            "Transfer",
            {}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.top_up_icon),
            "Top-up",
            {navController.navigate(Route.TopUpWalletScreen.route)}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.bill_icon),
            "Bill",
            {}
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.more_icon),
            "More",
            {}
        ),
    )

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(HomeEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_106048)
            .padding(
                top = 25.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Column {
                Text(
                    text = "Welcome",
                    style = poppins40014White
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = state.name,
                    style = poppins50024Bold_White
                )
            }
            Spacer(Modifier.weight(1f))
            Box(
                Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(
                        1.dp, Brush.linearGradient(
                            listOf(
                                _FAFAFAopasity10, _FAFAFAopasity60
                            )
                        ), CircleShape
                    )
            ) {
                AsyncImage(
                    model = state.userImage,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .background(_F6F6F626opasity15, RoundedCornerShape(30.dp)),
                    colors = CardDefaults.cardColors(_F6F6F626opasity15),
                    border = BorderStroke(
                        2.dp,
                        Brush.linearGradient(listOf(_FAFAFAopasity5, _FAFAFAopasity50))
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp, vertical = 20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Box(Modifier.size(1.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "total balance",
                                    style = poppins40012_White
                                )
                                Spacer(Modifier.height(5.dp))
                                Text(
                                    text = "$ " + state.totalBalance,
                                    style = poppins60044Bold_White
                                )
                            }
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.eye_icon),
                                contentDescription = null,
                                tint = Color.White,
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Box(Modifier.background(_FFFFFFopasity30, RoundedCornerShape(10.dp))) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(5.dp)
                            ) {
                                Text(
                                    text = "USD",
                                    style = poppins50010_White
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                        Spacer(Modifier.height(25.dp))
                        Spacer(Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(_FFFFFFopasity30))
                        Spacer(Modifier.height(20.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            repeat(optionList.size) {
                                CustomOptionCard(
                                    icon = optionList[it][0] as ImageVector,
                                    title = optionList[it][1] as String,
                                    onClick = optionList[it][2] as () -> Unit
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(30.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .fillParentMaxSize()
                        .background(_F6F6F6, RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                        .padding(horizontal = 25.dp, vertical = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(Modifier.size(20.dp, 1.dp).background(_080422opasity20))
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Send Again",
                        style = poppins50014_080422opasity20,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )
                    Spacer(Modifier.height(15.dp))
                    LazyRow(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(state.sendAgainList){
                            CustomSendAgainCard(
                                image = it.image,
                                name = it.name
                            ) { }
                            Spacer(Modifier.width(32.dp))
                        }
                    }
                    Spacer(Modifier.height(30.dp))
                    Text(
                        text = "Transaction History",
                        style = poppins50014_080422opasity20,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )
                    Spacer(Modifier.height(15.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(state.transactionList){
                            CustomTransactionHistory(
                                image = it.image,
                                title = it.title,
                                date = it.date,
                                price = it.price,
                                sendTo = it.sendTo,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        CustomBottomBar(
            Route.HomeScreen,
            navController
        )
    }
}