package com.codingwithmitch.mvvmrecipeapp.presentation.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue

@Composable
fun DropdownList(itemList: List<String>, selectedIndex: Int, modifier: Modifier, onItemClick: (Int) -> Unit) {

    var showDropdown by rememberSaveable { mutableStateOf(true) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Box(
            modifier = modifier
                .background(Color.Red)
                .clickable { showDropdown = !showDropdown },
                // .clickable { showDropdown = true },
            contentAlignment = Alignment.Center
        ) {
            Text(text = itemList[selectedIndex], modifier = Modifier.padding(3.dp))
        }

        // dropdown list
        Box {
            if (showDropdown) {
                Popup(
                    alignment = Alignment.TopCenter,
                    properties = PopupProperties(
                        excludeFromSystemGesture = true,
                    ),
                    // to dismiss on click outside
                    onDismissRequest = { showDropdown = false }
                ) {

                    Column(
                        modifier = modifier
                            .heightIn(max = 100.dp)
                            .verticalScroll(state = scrollState)
                            .border(width = 1.dp, color = Color.Gray),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        itemList.onEachIndexed { index, item ->
                            if (index != 0) {
                                Divider(thickness = 1.dp, color = Color.LightGray)
                            }
                            Box(
                                modifier = Modifier
                                    .background(Color.Green)
                                    .fillMaxWidth() // 把这里变长一点儿好看
                                    .clickable {
                                        onItemClick(index)
                                        showDropdown = !showDropdown
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = item)
                            }
                        }

                    }
                }
            }
        }
    }

}

@Composable
fun ContentView() {
    val itemList = listOf("K:Potassium",  "P:Posph..", "Na:Sodium", "Ca", "Urine Acid",)
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    val buttonModifier = Modifier.width(100.dp)

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        DropdownList(itemList = itemList, selectedIndex = selectedIndex, modifier = buttonModifier, onItemClick = { selectedIndex = it})

        Text(text = "You have chosen ${itemList[selectedIndex]}",
             textAlign = TextAlign.Center,
             modifier = Modifier
                 .padding(3.dp)
                 .fillMaxWidth()
                 .background(Color.LightGray),)
    }
}

// @Composable
// fun ContentView() {
//     val itemList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6")
//     //    val itemList = listOf<String>("Item 1", "Item 2", "Item 3")
//     var selectedIndex by rememberSaveable { mutableStateOf(0) }

//     val buttonModifier = Modifier.width(100.dp)

//     Column(

//         modifier = Modifier,
//         horizontalAlignment = Alignment.CenterHorizontally,
//         verticalArrangement = Arrangement.Center
//     ) {
//         DropdownList(itemList = itemList, selectedIndex = selectedIndex, modifier = buttonModifier, onItemClick = { selectedIndex = it})


//         Text(text = "You have chosen ${itemList[selectedIndex]}",
//              textAlign = TextAlign.Center,
//              modifier = Modifier
//                  .padding(3.dp)
//                  .fillMaxWidth()
//                  .background(Color.LightGray),)
//     }
// }


// @Preview(showBackground = true)
// @Composable
// fun GreetingPreview() {
//     Dropdown_demoTheme {
//         Column(
//             verticalArrangement = Arrangement.Center,
//             modifier = Modifier
//                 .fillMaxWidth()
//                 .fillMaxHeight()
//         ) {
//             ContentView()
//         }
//     }
// }