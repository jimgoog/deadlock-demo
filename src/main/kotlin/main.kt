import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.util.*
import kotlin.random.Random

val map = mutableStateMapOf<String, String>()

fun main() = application {
    Thread {
        while(true) {
            map.put("${Random(100).nextInt(100)}", UUID.randomUUID().toString())
        }
    }.start()
    Window(onCloseRequest = ::exitApplication) {
        Column {
            for(entry in map) {
                Text("${entry.key}=${entry.value}")
            }
        }
    }
}
