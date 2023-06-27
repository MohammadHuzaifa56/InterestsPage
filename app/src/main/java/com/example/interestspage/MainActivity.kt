package com.example.interestspage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interestspage.ui.theme.InterestsPageTheme
import com.example.interestspage.ui.theme.mons_bold
import com.example.interestspage.ui.theme.mons_regular

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterestsPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InterestsView()
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InterestsView() {
    val interestItems = remember {
        mutableStateListOf(
            InterestItem(
                "Beauty & Fashion",
                icon = R.drawable.ic_teddy_bear,
                isSelected = false
            ),
            InterestItem(
                "Entertainment",
                icon = R.drawable.ic_bullseye,
                isSelected = false
            ),
            InterestItem(
                "Football",
                icon = R.drawable.ic_controller,
                isSelected = false
            ),
            InterestItem("Pets", icon = R.drawable.ic_football, isSelected = false),
            InterestItem("Music", icon = R.drawable.ic_teddy_bear, isSelected = false),
            InterestItem("Funny", icon = R.drawable.ic_bullseye, isSelected = false),
            InterestItem(
                "DIY & Home",
                icon = R.drawable.ic_football,
                isSelected = false
            ),
            InterestItem("Arts", icon = R.drawable.ic_teddy_bear, isSelected = false),
            InterestItem("Sports", icon = R.drawable.ic_bullseye, isSelected = false),
            InterestItem("Drama & Film", icon = R.drawable.ic_controller, isSelected = false),
            InterestItem("Theatre & Comic", icon = R.drawable.ic_football, isSelected = false),
            InterestItem("Games", icon = R.drawable.ic_teddy_bear, isSelected = false),
            InterestItem("Education & Culture", icon = R.drawable.ic_bullseye, isSelected = false),
            InterestItem("Medicine", icon = R.drawable.ic_controller, isSelected = false),
            InterestItem("Dance & Act", icon = R.drawable.ic_football, isSelected = false),
        )
    }

    val selectedItems = remember { mutableStateListOf<InterestItem>() }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(14.dp)
        ) {
            Text(
                text = "Choose Your \nInterests",
                fontFamily = mons_bold,
                modifier = Modifier.padding(top = 20.dp, end = 20.dp, start = 10.dp),
                fontSize = 32.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Get better video recommendations",
                fontFamily = mons_regular,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 15.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(20.dp))
            FlowRow(horizontalArrangement = Arrangement.Start) {
                interestItems.forEachIndexed { index, item ->
                    val isSelected = selectedItems.contains(item)
                    InputChip(
                        selected = isSelected,
                        label = {
                            Text(
                                text = item.text,
                                fontFamily = mons_regular,
                                fontSize = 12.sp
                            )
                        },
                        shape = CircleShape,
                        modifier = Modifier
                            .wrapContentWidth()
                            .height(70.dp)
                            .padding(horizontal = 10.dp, vertical = 14.dp),
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = if (isSelected) R.drawable.ic_tick else item.icon),
                                modifier = Modifier.size(24.dp),
                                contentDescription = ""
                            )
                        },
                        elevation = InputChipDefaults.inputChipElevation(10.dp),
                        onClick = {
                            if (isSelected)
                                selectedItems.remove(item)
                            else selectedItems.add(item)
                        },
                        border = InputChipDefaults.inputChipBorder(
                            borderColor = Color.Gray,
                            borderWidth = 1.dp,
                            selectedBorderColor = Color.Transparent
                        ),
                        colors = InputChipDefaults.inputChipColors(
                            containerColor = Color.White,
                            selectedContainerColor = Color.Red,
                            labelColor = Color.Black,
                            selectedLabelColor = Color.White,
                            selectedLeadingIconColor = Color.White
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(110.dp))
        }
        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.White, shape = RectangleShape)
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp), color = Color.DarkGray
            )
            Text(
                text = "Update anytime from your settings.",
                modifier = Modifier.padding(14.dp),
                fontSize = 14.sp,
                color = Color.Gray,
                fontFamily = mons_regular
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 14.dp, end = 14.dp, bottom = 14.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .border(width = 1.dp, color = Color.DarkGray),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RectangleShape
                ) {
                    Text(text = "Skip", color = Color.Black, fontFamily = mons_regular)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.Red)
                        .border(width = 1.dp, color = Color.Red),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RectangleShape
                ) {
                    Text(text = "Next", color = Color.White, fontFamily = mons_regular)
                }
            }
        }
    }
}