import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Game(var gameClass: String, var gameTime: String, var missingSR: String, var missingKR: String)
val SATURDAY = 0
val SUNDAY = 1
val allGames = arrayOf(emptyList<Game>(), emptyList<Game>())

@Composable
@Preview
fun App(){
    val headlineText = remember { mutableStateOf("Start adding or generate the text")}
    val saturdayOrSunday = remember { mutableStateOf(SATURDAY) }

    MaterialTheme {
        Column {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, top = 15.dp, end = 20.dp, start = 20.dp)
            ) {
                Text(
                    text = headlineText.value,
                    modifier = Modifier
                        .height(30.dp),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                text = "Here will be the view of both lists",
                modifier = Modifier
                    .height(150.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp, start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                val labelColors = arrayOf(Color(0xFF426eb9), Color(0xFF36393f))
                Button(
                    onClick = {
                        saturdayOrSunday.value = SATURDAY
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
                        saturdayOrSunday.value = SUNDAY
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

            Text(
                text = "Input field"
            )

            Row {
                Button(
                    onClick = {

                    }
                ) {
                    Text("Left")
                }

                Button(
                    onClick = {

                    }
                ) {
                    Text("Right")
                }
            }

            Row {
                Button(
                    onClick = {

                    }
                ) {
                    Text("Left")
                }

                Button(
                    onClick = {

                    }
                ) {
                    Text("Right")
                }
            }
        }
    }
}