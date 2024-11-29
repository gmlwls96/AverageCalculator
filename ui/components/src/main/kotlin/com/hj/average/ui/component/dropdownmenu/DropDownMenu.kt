package com.hj.average.ui.component.dropdownmenu

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hj.average.ui.theme.AppTheme
import com.hj.average.ui.theme.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier,
    options: List<String>,
    selectedOptionText: String,
    onSelect: (Int, String) -> Unit,
    label: String? = null,
) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            readOnly = true,
            singleLine = true,
            label = label?.let {
                {
                    Text(
                        text = label,
                        style = AppTheme.typography.noto14Regular,
                        color = Colors.Gray700
                    )
                }
            },
            value = selectedOptionText.ifEmpty { options[0] },
            onValueChange = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults
                .textFieldColors(
                    focusedTextColor = Colors.Gray900,
                    unfocusedTextColor = Colors.Gray500,
                    focusedContainerColor = Colors.Transparent,
                    unfocusedContainerColor = Colors.Transparent,
                    focusedIndicatorColor = Colors.Gray700,
                    unfocusedIndicatorColor = Colors.Gray200,
                )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            modifier = Modifier.exposedDropdownSize(),
            onDismissRequest = { expanded = false },
        ) {
            options.forEachIndexed { index, selectionOption ->
                DropdownMenuItem(
                    text = {
                        Text(text = selectionOption)
                    },
                    onClick = {
                        onSelect(index, selectionOption)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    colors = MenuDefaults.itemColors(
                        textColor = Colors.Gray700,
                        trailingIconColor = Colors.Gray600
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownMenuPreView() {
    DropDownMenu(
        modifier = Modifier.fillMaxWidth(),
        selectedOptionText = "",
        label = "Number",
        options = listOf("1", "2", "3", "4"),
        onSelect = { index, selectionOption -> },
    )
}