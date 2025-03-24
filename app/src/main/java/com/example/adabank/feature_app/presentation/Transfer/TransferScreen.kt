@file:Suppress("UNCHECKED_CAST")

package com.example.adabank.feature_app.presentation.Transfer

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.Transfer.components.CustomCategory
import com.example.adabank.feature_app.presentation.Transfer.components.CustomContactCard
import com.example.adabank.feature_app.presentation.common.CustomAlertDialog
import com.example.adabank.feature_app.presentation.common.CustomAsyncImage
import com.example.adabank.feature_app.presentation.common.CustomSearchTextField
import com.example.adabank.feature_app.presentation.common.CustomTopAppBar
import com.example.adabank.feature_app.presentation.ui.theme._07041A17
import com.example.adabank.feature_app.presentation.ui.theme._080422opasity10
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme._106048
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_080422opasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins40014_080422opasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_Blackopasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50016Bold_080422

@Composable
fun TransferScreen(
    navController: NavController,
    viewModel: TransferViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val context = LocalContext.current
    val lazyRowState = rememberLazyListState()
    val categoryList = listOf(
        listOf(
            "Bank account",
            true,
            {},
        ),
        listOf(
            "Scan",
            false,
            {},
        ),
        listOf(
            "Nearby",
            false,
            {},
        ),
    )

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickContact()) {
        if (it != null){
            val stream = context.contentResolver.openOutputStream(it)
            viewModel.onEvent(TransferEvent.GetContact(it))
            stream?.close()
        }
    }

    LaunchedEffect(lazyRowState.isScrollInProgress) {
        if (!lazyRowState.isScrollInProgress){
            viewModel.onEvent(TransferEvent.ChangeSelectedContactNumber(lazyRowState.firstVisibleItemIndex))
        }
    }

    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(TransferEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_106048)
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
        Spacer(Modifier.height(50.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(categoryList.size){
                CustomCategory(
                    text = categoryList[it][0] as String,
                    isSelected = categoryList[it][1] as Boolean,
                    onClick = categoryList[it][2] as () -> Unit
                )
            }
        }

        Spacer(Modifier.height(45.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(_F6F6F6, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
            contentPadding = PaddingValues(top = 30.dp, start = 25.dp, end = 25.dp)
        ) {
            item {
                CustomSearchTextField(
                    value = state.searchText,
                    onValueChange = {
                        viewModel.onEvent(TransferEvent.EnterSearchText(it))
                    },
                    hint = "Search Contact",
                    modifier = Modifier
                        .fillParentMaxWidth()
                )
                Spacer(Modifier.height(25.dp))
                Text(
                    text = "Recents Contacts",
                    style = poppins50014_080422opasity20
                )
                Spacer(Modifier.height(25.dp))
                LazyRow(
                    modifier = Modifier
                        .fillParentMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    state = lazyRowState
                ) {
                    itemsIndexed(state.contactList){ index, it ->
                        CustomContactCard(
                            icon = it.icon,
                            name = it.name,
                            bankCardNumber = it.bankCardNumber,
                            index = index,
                            firstVisibleIndex = state.selectedContactNumber
                        ) {
                            viewModel.onEvent(TransferEvent.ChangeSelectedContactNumber(index))
                            Route.TransferDetailScreen.contact = it
                            navController.navigate(Route.TransferDetailScreen.route)
                        }
                        Spacer(Modifier.width(30.dp))
                    }
                }
                Spacer(Modifier.height(50.dp))
                Spacer(Modifier.fillParentMaxWidth().height(1.dp).background(_080422opasity10))
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "All Contacts",
                    style = poppins50014_Blackopasity50
                )
                Spacer(Modifier.height(30.dp))
            }

            items(state.contactList){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            Route.TransferDetailScreen.contact = it
                            navController.navigate(Route.TransferDetailScreen.route)
                        }
                ) {
                    CustomAsyncImage(it.icon)
                    Spacer(Modifier.width(25.dp))
                    Column {
                        Text(
                            text = it.name,
                            style = poppins50016Bold_080422
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = "Bank - ${it.bankCardNumber}",
                            style = poppins40012_080422opasity50
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
            }
        }
    }

    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .shadow(4.dp, spotColor = _07041A17)
                .clickable {
                    launcher.launch(null)
                }
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(_09703E, CircleShape),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Spacer(Modifier.width(25.dp))
            Text(
                text = "Add Contact",
                style = poppins40014_080422opasity50
            )
        }
    }
}