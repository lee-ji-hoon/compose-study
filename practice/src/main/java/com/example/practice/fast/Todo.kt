@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.practice.fast

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.ComposestudyTheme

@Composable
fun TopLevel() {
    val (text, setText) = remember { mutableStateOf("") }
    val toDoList = remember { mutableStateListOf<ToDoData>() }

    val onSubmit: (String) -> Unit = { text ->
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(ToDoData(key, text))
        setText("")
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = toDoList.indexOfFirst { key == it.key }
        toDoList[i] = toDoList[i].copy(
            done = checked
        )
    }

    val onDelete: (Int) -> Unit = { key ->
        if (toDoList.size == 1) {
            toDoList.removeFirst()
        } else {
            toDoList.removeAt(key)
        }
    }

    val onEdit: (Int, String) -> Unit = { key, text ->
        val i = toDoList.indexOfFirst { key == it.key }
        toDoList[i] = toDoList[i].copy(
            text = text
        )
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            ToDoInput(
                text = text,
                onTextChange = setText,
                onSubmit = onSubmit,
            )
            LazyColumn {
                items(toDoList, key = { it.key }) { todoData ->
                    ToDo(
                        toDoData = todoData,
                        onEdit = onEdit,
                        onToggle = onToggle,
                        onDelete = onDelete
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopLevelPreview() {
    ComposestudyTheme {
        TopLevel()
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ComposestudyTheme {
        ToDoInput("테스트", {}, {})
    }
}

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp),
    ) {

        Crossfade(targetState = isEditing, label = "") { state ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                if (state) {
                    var (newText, setNewText) = remember { mutableStateOf(toDoData.text) }
                    OutlinedTextField(
                        value = newText,
                        onValueChange = setNewText,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Button(onClick = {
                        onEdit(toDoData.key, newText)
                        isEditing = false
                    }) {
                        Text(text = "완료")
                    }
                } else {
                    Text(
                        text = toDoData.text,
                        modifier = Modifier.weight(1f)
                    )
                    Text(text = "완료")

                    Checkbox(
                        checked = toDoData.done,
                        onCheckedChange = { checked -> onToggle(toDoData.key, checked) }
                    )

                    Button(onClick = {
                        isEditing = true
                    }) {
                        Text(text = "수정")
                    }

                    Spacer(modifier = Modifier.size(4.dp))

                    Button(onClick = { onDelete(toDoData.key) }) {
                        Text(text = "삭제")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ComposestudyTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)
