package com.example.adabank.feature_app.presentation.Receipt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.R
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.common.CustomAsyncImage
import com.example.adabank.feature_app.presentation.common.CustomButton
import com.example.adabank.feature_app.presentation.common.CustomTopAppBar
import com.example.adabank.feature_app.presentation.ui.theme._05051A14
import com.example.adabank.feature_app.presentation.ui.theme._080422
import com.example.adabank.feature_app.presentation.ui.theme._080422opasity10
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme._whiteopasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_080422opasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_Whiteopasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins40016_080422opasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50012_080422
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
            navController.navigate(Route.HomeScreen.route) {
                popUpTo(Route.ReceiptScreen.route) {
                    inclusive = true
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Receipt",
            style = poppins50020Bold_080422
        )
        Spacer(Modifier.height(25.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            item {
                Box {
                    Image(
                        painter = painterResource(R.drawable.receipt_background),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(30.dp)),
                        contentDescription = null,
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp, top = 30.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CustomAsyncImage(
                                model = Route.TransferDetailScreen.contact.icon,
                            )
                            Spacer(Modifier.width(25.dp))
                            Column {
                                Text(
                                    text = Route.TransferDetailScreen.contact.name,
                                    style = poppins50020Bold_080422
                                )
                                Spacer(Modifier.height(10.dp))
                                Text(
                                    text = "Bank - ${Route.TransferDetailScreen.contact.bankCardNumber}",
                                    style = poppins40012_080422opasity50
                                )
                            }
                        }
                        Spacer(Modifier.height(30.dp))
                        Spacer(Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(_080422opasity10))
                        Spacer(Modifier.height(20.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total",
                                style = poppins40016_080422opasity50
                            )
                            Text(
                                text = "$${state.amount}",
                                style = poppins40016_080422opasity50
                            )
                        }
                        Spacer(Modifier.height(25.dp))
                        Spacer(Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(_080422opasity10))
                        Spacer(Modifier.height(20.dp))
                        Text(
                            text = "Note",
                            style = poppins40016_080422opasity50
                        )
                        Spacer(Modifier.height(25.dp))
                        Spacer(Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(_080422opasity10))
                        Spacer(Modifier.height(20.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Date Transaction",
                                style = poppins40012_080422opasity50
                            )
                            Text(
                                text = state.transactionDate,
                                style = poppins40012_080422opasity50,
                            )
                        }
                        Spacer(Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "ID Transaction",
                                style = poppins40012_080422opasity50
                            )
                            Spacer(Modifier.weight(1f))
                            Text(
                                text = "202108260001@\n" +
                                        "DCB199983",
                                style = poppins40012_080422opasity50
                            )
                        }
                        Spacer(Modifier.height(15.dp))
                        Spacer(Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(_080422opasity10))
                    }
                }
            }
            item {
                Spacer(Modifier.height(30.dp))
                Card(
                    modifier = Modifier
                        .fillParentMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Categories",
                            style = poppins40016_080422opasity50
                        )
                        Spacer(Modifier.weight(1f))
                        Card(
                            modifier = Modifier
                                .shadow(7.dp, RoundedCornerShape(12.dp), spotColor = _05051A14),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(_whiteopasity50)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.camera_icon),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = "Equipment",
                            style = poppins50012_080422
                        )
                        Spacer(Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = _080422
                        )
                    }
                }
                Spacer(Modifier.height(60.dp))
                CustomButton(
                    text = "Download Invoice",
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .height(65.dp)
                ) { }
            }
        }
    }
}