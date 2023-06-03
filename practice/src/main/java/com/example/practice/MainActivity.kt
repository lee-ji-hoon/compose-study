package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.practice.fast.EzDialog
import com.example.practice.ui.theme.ComposestudyTheme

data class ItemData(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String,
)

val items = listOf(
    ItemData(
        imageId = R.drawable.ic_test,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "워터월드",
        description = "워터월드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "미국의 캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "라스베가스",
        description = "라스베가스입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "호르슈 밴드",
        description = "호르슈 밴드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "미국의 길",
        description = "미국의 길입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "엔텔로프 캐년",
        description = "엔텔로프 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.ic_test,
        title = "그랜드 캐년",
        description = "그랜드 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposestudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    EzDialog()
                }
            }
        }
    }
}

@Composable
fun EzItem(itemData: ItemData) {
    Card(
        modifier = Modifier.padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = ""
            )
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Text(
                text = itemData.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun EzCatalogItem(itemList: List<ItemData>) {
    LazyColumn {
        items(itemList) {
            EzItem(itemData = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EzScaffold() {
    var checked by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            title = { "Scafflod App" }
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {

        }
    }) { paddingValue ->
        Surface(modifier = Modifier.padding(paddingValue)) {
            EzCheckBotWithContent(
                checked = checked,
                onChecked = {
                    checked = checked
                }
            ) {
                Text(text = "컴포즈 좋네...")
            }
        }
    }
}

@Composable
fun EzCheckBotWithContent(
    checked: Boolean,
    onChecked: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onChecked() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onChecked() }
        )
        content()
    }
}

@Composable
fun EzContent() {
    var checked by remember { mutableStateOf(false) }
    EzCheckBotWithContent(
        checked = checked,
        onChecked = {
            println(checked)
            checked = checked.not()
        }
    ) {
        Text(text = "텍스트 1")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EzTopAppBar(
    modifier: Modifier = Modifier,
    name: String
) {
    Column {
        TopAppBar(
            title = {
                Text(text = "TopAppBar")
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "뒤로가기"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )
    }
}

@Composable
fun EzCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part1-chapter3/main/part1-chapter3-10/app/src/main/res/drawable-xhdpi/wall.jpg",
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "엔텔로프 캐년 이미지",
                modifier = Modifier.clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(text = "Dalinaum")
                Text(text = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개됐습니다.")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EzItemPreview() {
    EzItem(
        items.first()
    )
}

@Preview(heightDp = 300)
@Composable
fun EzScaffoldPreview() {
    EzScaffold()
}

@Preview(showBackground = true, widthDp = 150)
@Composable
fun EzContentPreview() {
    EzContent()
}

@Preview
@Composable
fun CardPreview() {
    EzCard()
}

@Preview(showBackground = true)
@Composable
fun EzTopAppBarPreview() {
    EzTopAppBar(name = "ezhoon")
}



