import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun App(){
    val headlineText = remember { mutableStateOf("Start adding or generate the text")}

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

            Text(
                text = "Selection saturday / sunday"
            )

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