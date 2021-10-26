import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Game(var gameClass: String, var gameTime: String, var missingSR: String, var missingKR: String)
val COLOR_BLUE = Color(0xFF426eb9)
val COLOR_DARK_GRAY = Color(0xFF36393f)
val COLOR_LIGHT_GRAY = Color(0xFF3c3f41)
val SATURDAY = 0
val SUNDAY = 1
val allGames = arrayOf(emptyList<Game>(), emptyList<Game>())

@Composable
@Preview
fun App(){
    val headlineText = remember { mutableStateOf("Start adding or generate the text")}
    val saturdayOrSunday = remember { mutableStateOf(SATURDAY) }
    val textFieldValue = remember { mutableStateOf(TextFieldValue("")) }
    val localFocusManager = LocalFocusManager.current
    val focusRequester = FocusRequester()

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = COLOR_LIGHT_GRAY)
                .padding(end = 20.dp, start = 20.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, top = 15.dp)
            ) {
                Text(
                    text = headlineText.value,
                    modifier = Modifier
                        .height(30.dp),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Text(
                text = "Here will be the view of both lists",
                modifier = Modifier
                    .height(150.dp),
                color = Color.White
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                val labelColors = arrayOf(COLOR_BLUE, COLOR_DARK_GRAY)
                Button(
                    onClick = {
                        if(saturdayOrSunday.value != SATURDAY) {
                            localFocusManager.clearFocus()
                            saturdayOrSunday.value = SATURDAY
                        }
                        textFieldValue.value = TextFieldValue("")
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(fraction = 0.5f),
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = labelColors[saturdayOrSunday.value])
                ){
                    Text(
                        text = "Saturday",
                        color = Color.White
                    )
                }
                Button(
                    onClick = {
                        if(saturdayOrSunday.value != SUNDAY) {
                            localFocusManager.clearFocus()
                            saturdayOrSunday.value = SUNDAY
                        }
                        textFieldValue.value = TextFieldValue("")
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(fraction = 1f),
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = labelColors[(saturdayOrSunday.value + 1) % 2])
                ){
                    Text(
                        text = "Sunday",
                        color = Color.White
                    )
                }
            }

            OutlinedTextField(
                value = textFieldValue.value,
                enabled = false,
                onValueChange = { textFieldValue.value = it },
                label = { Text("CLick \"Start2Add\"") },
                placeholder = { Text("Possible Games")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = COLOR_BLUE,
                    unfocusedBorderColor = COLOR_BLUE,
                    focusedLabelColor = COLOR_BLUE,
                    unfocusedLabelColor = COLOR_BLUE,
                    textColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .focusRequester(focusRequester),
                shape = RectangleShape
            )

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = COLOR_BLUE)
                ) {
                    Text(
                        text = "Left",
                        color = Color.White
                    )
                }

                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = COLOR_BLUE)
                ) {
                    Text(
                        text = "Right",
                        color = Color.White
                    )
                }
            }

            Row {
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = COLOR_BLUE)
                ) {
                    Text(
                        text ="Left",
                        color = Color.White
                    )
                }

                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = COLOR_BLUE)
                ) {
                    Text(
                        text = "Right",
                        color = Color.White
                    )
                }
            }
        }
    }
}